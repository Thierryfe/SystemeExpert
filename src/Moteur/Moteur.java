package Moteur;

import java.util.ArrayList;
import java.util.List;

public class Moteur {
	ArrayList<Fait> baseDeFaits;
	ArrayList<Regle> baseDeRegle;
	CreerBaseIncoherence baseIncoherence;

	public Moteur(ArrayList<Fait> baseDeFaits, ArrayList<Regle> baseDeRegle) {
		super();
		this.baseDeFaits = baseDeFaits;
		this.baseDeRegle = baseDeRegle;
		this.baseIncoherence = new CreerBaseIncoherence("Incoherence");
	}

	public void chainageAvant(Fait factToProve, boolean trace) {

		
		ArrayList<Regle> rulesTemp = new ArrayList<Regle>(baseDeRegle);
		ArrayList<Fait> factsTemp = new ArrayList<Fait>(baseDeFaits);

		if (trace) {
			System.out.println("\nStarting forwardchaining...");
			System.out.println("\nBases status :");
			System.out.println("\t" + factsTemp.size() + " facts in fact base ! " + factsTemp);

			System.out.println("\t" + rulesTemp.size() + " rules in rule base ! ");

		}
		System.out.println("Fact to prove : " + factToProve.toString());
		int iteration = 0;
		while (!bdFContientFait(factsTemp, factToProve) && regleApplicable(rulesTemp, factsTemp)) {
			if (trace)
				System.out.println("\nNumber of iteration : " + ++iteration);
			// on prepare la r�gle applicable
			Regle applicableRule = null;
			// on cherche une r�gle applicable dans la base de r�gle
			if (trace)
				System.out.println("Checking rules of the rules base with premisse(s) in facts base :");
			int nbrOfRule = 0;
			for (Regle ruleTocheck : rulesTemp) {
				if (trace) {
					System.out.println("Checking rule number " + ++nbrOfRule);
					System.out.println("Rule contains : " + ruleTocheck);
				}
				// System.out.println("on parcours les r�gles, on est sur :
				// "+ruleTocheck.toString());
				// si on trouve une r�gle applicable donc une pr�misse de cette r�gles dans la
				// base de fait
				// alors
				// on le r�cupere
				// on retire cette r�gle de la base de r�gle
				// on stop le for
				// on ajoute la conclusion de cette r�gle � la base de fait
				if (trace)
					System.out.println("Checking Premisse(s)");
				Premisse premisseActuelle = ruleTocheck.getPremisse();
				int nombreDePremisseValide = 0;
				while (premisseActuelle != null) {
					if (baseDeFaitContientFait(factsTemp, premisseActuelle.getFait())) {
						if (trace) {
							System.out.println("Checking Fact :");
							System.out.println(premisseActuelle.getFait().toString());}
						if (verifierFait(factsTemp, premisseActuelle.getFait(),trace)) {

							nombreDePremisseValide++;

						}
						if (trace)
							System.out.println("\t\t" + nombreDePremisseValide + "/" + ruleTocheck.nombreDePremisse()
							+ " Premisse(s) validated.");
					}

					premisseActuelle = premisseActuelle.getPremisseEventuelle();
				}
				// si on trouve une r�gle applicable alors on stop la recherche
				if ((nombreDePremisseValide == ruleTocheck.nombreDePremisse()) && nombreDePremisseValide > 0) {
					if (trace)
						System.out.println("\tAll premisse(s) validated, rule is applicable.");
					applicableRule = ruleTocheck;
					break;
				}//si on trouve une r�gle applicable


			}
			// si il y une r�gle applicable on la retire de la liste des r�gles et on ajoute
			// les consequences � la base de fait
			if (applicableRule != null) {
				if (trace)
					System.out.println("\tRemoving rule from rules base.");
				rulesTemp.remove(applicableRule);
				Conclusion conclusionActuelle = applicableRule.getConclusion();
				int nbrConclusion = 0;
				while (conclusionActuelle != null) {
					nbrConclusion++;
					if (trace)
						System.out.println("\tAdding conclusion(s) of this rule in facts base (" + nbrConclusion + "/"
								+ applicableRule.nombreDeConclusion() + ").");
					factsTemp.add(conclusionActuelle.getFait());
					conclusionActuelle = conclusionActuelle.getConclusionEventuelle();
				}
			}
			else {
				break;
			}

		}
		System.out.println("\n///////////////////////////////////////////////////////////////////");
		System.out.println("\nForward chaining finished with result :");
		if (trace) {
			System.out.println("Bases status :");
			System.out.println("\t" + factsTemp.size() + " facts in fact base ! " + factsTemp.toString());
			System.out.println("\t" + rulesTemp.size() + " rules in rule base ! ");
		}
		System.out.println("Result :");
		if (bdFContientFait(factsTemp, factToProve)) {
			System.out.println("\tFact is correct !");
		} else {
			System.out.println("\tFact is wrong !");
		}
		System.out.println("\n///////////////////////////////////////////////////////////////////");
	}

	public boolean bdFContientFait(List<Fait> baseDeFaits, Fait fait) {
		boolean result = false;
		for (Fait fait2 : baseDeFaits) {
			if (fait2.getNom().equals(fait.getNom()) && fait2.getValue().equals(fait.getValue())
					&& fait2.getOperator() == fait.getOperator()) {
				result = true;
			}
		}
		return result;
	}

	public boolean regleApplicable(List<Regle> baseDeRegles, List<Fait> baseDeFaits) {
		// on verifie si pour chaque regle il y a une premisse dans la base de faits
		// System.out.println("on va rechercher si une r�gle est applicable");
		for (Regle regle : baseDeRegles) {

			for (Fait fait : baseDeFaits) {

				Premisse premisse = regle.getPremisse();
				while (premisse != null) {
					// System.out.println("On compare : "+premisse.getFait().getNom() ==
					// fait.getNom());
					if (premisse.getFait().getNom().equals(fait.getNom())) {
						// System.out.println("il reste des regles applicable.");
						return true;
					}
					premisse = premisse.getPremisseEventuelle();
				}

			}
		}
		// System.out.println("Pas de r�gle applicable");
		return false;
	}

	public boolean verifierFait(List<Fait> baseDeFaits, Fait faitCourant, boolean trace) {

		boolean result = false;

		for (Fait fait : baseDeFaits) {

			if (fait.getNom().equals(faitCourant.getNom())) {

				// on verifie si c'est un chiffre ou un string
				if (verificationNumerique(faitCourant.getValue()) == verificationNumerique(fait.getValue())) {

					if (verificationNumerique(faitCourant.getValue())) {

						result = verificationFaitNumerique(fait, faitCourant,trace);
					} else {

						result = verificationFaitString(fait, faitCourant,trace);
					}
					if(result)
						break;
				} else {
					return result;
				}
			}
		}
		return result;
	}

	public boolean baseDeFaitContientFait(List<Fait> baseDeFaits, Fait faitCourant) {
		boolean result = false;

		for (Fait fait : baseDeFaits) {
			if (fait.getNom().equals(faitCourant.getNom())) {
				result = true;
			}
		}
		return result;
	}

	public boolean verificationNumerique(String valeurFait) {
		try {
			double d = Double.parseDouble(valeurFait);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

	public boolean verificationFaitNumerique(Fait faitBase, Fait faitCourant, boolean trace) {
		boolean result = false;
		Double valeurFaitBase = Double.parseDouble(faitBase.getValue());
		Double valeurFaitCourant = Double.parseDouble(faitCourant.getValue());

		switch (faitCourant.getOperator()) {
		case SUPERIOR:
			result = valeurFaitBase > valeurFaitCourant;
			break;
		case SUPERIOR_OR_EQUAL:
			result = valeurFaitBase >= valeurFaitCourant;
			break;
		case INFERIOR:
			result = valeurFaitBase < valeurFaitCourant;
			break;
		case INFERIOR_OR_EQUAL:
			result = valeurFaitBase <= valeurFaitCourant;
			break;
		case DIFFERENT:
			result = valeurFaitBase != valeurFaitCourant;
			break;
		case EQUAL:
			result = valeurFaitBase == valeurFaitCourant;
			break;

		default:
			result = false;
			break;
		}

		return result;

	}

	public boolean verificationFaitString(Fait faitBase, Fait faitCourant,boolean trace) {
		boolean result = false;

		if (trace)
			System.out.println("Comparing fact :"+faitBase.getValue()+" "+faitCourant.getOperator()+" "+ faitCourant.getValue());
		switch (faitCourant.getOperator()) {

		case SUPERIOR:
			result = faitBase.getValue().compareTo(faitCourant.getValue()) > 0;
			break;
		case SUPERIOR_OR_EQUAL:
			result = faitBase.getValue().compareTo(faitCourant.getValue()) >= 0;
			break;
		case INFERIOR:
			result = faitBase.getValue().compareTo(faitCourant.getValue()) < 0;
			break;
		case INFERIOR_OR_EQUAL:
			result = faitBase.getValue().compareTo(faitCourant.getValue()) <= 0;
			break;
		case DIFFERENT:
			result = !faitBase.getValue().equals(faitCourant.getValue());
			break;
		case EQUAL:
			result = faitBase.getValue().equals(faitCourant.getValue());
			break;

		default:
			result = false;
			break;
		}
		return result;

	}

	public void chainageArriere(Fait factToProve, boolean trace) {

		ArrayList<Regle> rulesTemp = new ArrayList<Regle>(baseDeRegle);
		ArrayList<Fait> factsTemp = new ArrayList<Fait>(baseDeFaits);
		ArrayList<Fait> factsToProve = new ArrayList<Fait>();
		factsToProve.add(factToProve);

		if (trace) {
			System.out.println("\nStarting backward chaining...");
			System.out.println("\nBases status :");
			System.out.println("\t" + factsTemp.size() + " facts in fact base ! " + factsTemp);

			System.out.println("\t" + rulesTemp.size() + " rules in rule base ! ");

		}
		System.out.println("Fact to prove : " + factToProve.toString());

		while (!baseDeFaitContientFait(factsTemp, factToProve)) {

			ArrayList<Regle> ensembleDeRegleValides = new ArrayList<Regle>();
			if (trace)
				System.out.println("Checking rules of the rules base with conclusion(s) in facts to prove base :");
			int nbrOfRule = 0;
			for (Regle regle : rulesTemp) {
				if (trace) {
					System.out.println("Checking rule number " + ++nbrOfRule);
					System.out.println("Rule contains : " + regle);
				}
				int nbrConclusion = 0;
				if (trace)
					System.out.println("Checking conclusion(s)");
				Conclusion conclusionActuelle = regle.getConclusion();
				while (conclusionActuelle != null) {
					if (verifierFait(factsToProve, conclusionActuelle.getFait(),trace)) {
						nbrConclusion++;
					}
					if (trace)
						System.out.println(
								"\t\t" + nbrConclusion + "/" + regle.nombreDePremisse() + " Conclusion(s) validated.");
					conclusionActuelle = conclusionActuelle.getConclusionEventuelle();
				}

				if (nbrConclusion == regle.nombreDeConclusion()) {
					if (trace)
						System.out
						.println("\tAll Conclusion(s) validated, rule is valid and added to valid rules list.");
					ensembleDeRegleValides.add(regle);
				}
			}

			// on verifie si on a des r�gles valides
			if (trace)
				System.out.println(
						"\nChecking if valid rules list, contains valid premisses according to the facts base.");
			if (!ensembleDeRegleValides.isEmpty()) {
				// on parcour les regles valides
				for (Regle regle : ensembleDeRegleValides) {
					int nbrPremisse = 0;
					if(trace)
						System.out.println("\t Valid Rule : "+regle);
					Premisse premisseActuelle = regle.getPremisse();
					while (premisseActuelle != null) {

						if (verifierFait(factsTemp, premisseActuelle.getFait(),trace)) {
							nbrPremisse++;
						}
						premisseActuelle = premisseActuelle.getPremisseEventuelle();
					}

					if (nbrPremisse == regle.nombreDePremisse()) {
						if (trace)
							System.out.println("\tPremisse(s) of this rule are in facts base.");
						Conclusion conclusionActuelle = regle.getConclusion();
						while (conclusionActuelle != null) {
							if (trace)
								System.out.println("\tAdding conclusion(s) of this rule in facts base.");
							factsTemp.add(conclusionActuelle.getFait());
							factsToProve.remove(conclusionActuelle.getFait());

							conclusionActuelle = conclusionActuelle.getConclusionEventuelle();

						}

						rulesTemp.remove(regle);
					} else {
						Premisse premisseActuelleAAjouter = regle.getPremisse();
						if (trace)
							System.out.println("\tPremisse(s) of this rule are not facts base.");
						while (premisseActuelleAAjouter != null) {
							if (trace)
								System.out.println("\tAdding premisse(s) of this rule in facts to prove base.");
							factsToProve.add(premisseActuelleAAjouter.getFait());
							premisseActuelleAAjouter = premisseActuelleAAjouter.getPremisseEventuelle();
						}

					}
				}
			} else {
				if (trace)
					System.out.println("\tNo valid rules.");
				// sinon on break le while
				break;
			}
		}
		System.out.println("\n///////////////////////////////////////////////////////////////////");
		System.out.println("\nBackward chaining finished with result :");
		if (trace) {
			System.out.println("Bases status :");
			System.out.println("\t" + factsTemp.size() + " facts in fact base ! " + factsTemp.toString());
			System.out.println("\t" + rulesTemp.size() + " rules in rule base ! ");
		}
		System.out.println("Result :");
		if (bdFContientFait(factsTemp, factToProve)) {
			System.out.println("\tFact is correct !");
		} else {
			System.out.println("\tFact is wrong !");
		}
		System.out.println("\n///////////////////////////////////////////////////////////////////");
	}

}
