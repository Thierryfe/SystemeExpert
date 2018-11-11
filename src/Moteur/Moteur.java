package Moteur;

import java.util.ArrayList;
import java.util.List;


public class Moteur {
	ArrayList<Fait> baseDeFaits;
	ArrayList<Regle> baseDeRegle;

	
	public Moteur(ArrayList<Fait> baseDeFaits, ArrayList<Regle> baseDeRegle) {
		super();
		this.baseDeFaits = baseDeFaits;
		this.baseDeRegle = baseDeRegle;
	}

	public void chainageAvant(Fait factToProve) {

		ArrayList<Regle> rulesTemp = new ArrayList<Regle> (baseDeRegle);
		ArrayList<Fait> factsTemp =  new ArrayList<Fait> (baseDeFaits);

		
		System.out.println("Starting forwardchaining...");

		System.out.println(factsTemp.size()+" facts in fact base ! " + factsTemp);

		System.out.println(rulesTemp.size()+" rules in rule base ! ");

		System.out.println("Target : "+factToProve.toString());
		
		System.out.println("on entre pas  dans la boucle principale");
		while(!bdFContientFait(factsTemp, factToProve)&& regleApplicable(rulesTemp,factsTemp)) {
			System.out.println("on entre dans la boucle principale");
			//on prepare la rï¿½gle applicable
			Regle applicableRule= null;
			//on cherche une rï¿½gle applicable dans la base de rï¿½gle
			for (Regle ruleTocheck : rulesTemp) {
				System.out.println("on veut verifier la règle : "+ruleTocheck.toString());
				//System.out.println("on parcours les règles, on est sur  : "+ruleTocheck.toString());
				//si on trouve une rï¿½gle applicable donc une prémisse de cette règles dans la base de fait
				//alors
				// on le récupere
				// on retire cette rï¿½gle de la base de rï¿½gle
				// on stop le for
				// on ajoute la conclusion de cette rï¿½gle ï¿½ la base de fait
				System.out.println("La regle possède : "+ruleTocheck.nombreDePremisse()+" premisses");
				Premisse premisseActuelle=ruleTocheck.getPremisse();
				int nombreDePremisseValide=0; 	
				while(premisseActuelle!=null) {
					if(baseDeFaitContientFait(factsTemp, premisseActuelle.getFait())) {
						if(verifierFait(factsTemp, premisseActuelle.getFait())) {
							nombreDePremisseValide++;
							System.out.println("La premisse est juste on passe aux eventuelles suivantes");
							}
					}
					premisseActuelle=premisseActuelle.getPremisseEventuelle();
				}
				//si on trouve une règle applicable alors on stop la recherche
				if((nombreDePremisseValide==ruleTocheck.nombreDePremisse()) && nombreDePremisseValide > 0) {
					System.out.println("La règle est applicable.");
					applicableRule=ruleTocheck;
					break;
				}
					
			}
			//si il y une règle applicable on la retire de la liste des règles et on ajoute les consequences à la base de fait
			if(applicableRule!=null) {
				rulesTemp.remove(applicableRule);
				Conclusion conclusionActuelle=applicableRule.getConclusion();
				while(conclusionActuelle!=null) {
					System.out.println("On ajoute la règle applicable.");
					factsTemp.add(conclusionActuelle.getFait());
					conclusionActuelle=conclusionActuelle.getConclusionEventuelle();
				}
			}
			
			System.out.println("Algo relancé /////////////////////////////////////////////////////////");
			//break;
		}
		System.out.println(factsTemp.size()+" facts in fact base ! " + factsTemp.toString());

		System.out.println(rulesTemp.size()+" rules in rule base ! ");

		if(bdFContientFait(factsTemp,factToProve)) {	
			System.out.println(" fact is proved.");
		}else {
			System.out.println(" fact is wrong.");
		}

	}
	
	public boolean bdFContientFait( List<Fait> baseDeFaits, Fait fait) {
		boolean result=false;
		for (Fait fait2 : baseDeFaits) {
			if(fait2.getNom().equals(fait.getNom())&&fait2.getValue().equals(fait.getValue())&&fait2.getOperator()==fait.getOperator()) {
				result=true;
			}
		}
		return result;
	}
	
	public boolean regleApplicable(List<Regle> baseDeRegles, List<Fait> baseDeFaits) {
		//on verifie si pour chaque regle il y a une premisse dans la base de faits
		System.out.println("on va rechercher si une règle est applicable");
		for(Regle regle: baseDeRegles) {
		
			for(Fait fait: baseDeFaits) {
				
				Premisse premisse= regle.getPremisse();
				while(premisse!=null) {
					//System.out.println("On compare : "+premisse.getFait().getNom() == fait.getNom());
					if(premisse.getFait().getNom().equals(fait.getNom())) {
						System.out.println("il reste des regles applicable.");
						return true;
					}
					premisse=premisse.getPremisseEventuelle();
				}
				
			}
		}
		System.out.println("Pas de règle applicable");
		return false;
	}

	public boolean verifierFait(List<Fait> baseDeFaits, Fait faitCourant) {

		boolean result=false;

		for (Fait fait : baseDeFaits) {
			if(fait.getNom().equals(faitCourant.getNom())) {
				//on verifie si c'est un chiffre ou un string
				if(verificationNumerique(faitCourant.getValue()) == verificationNumerique(fait.getValue())){
					if(verificationNumerique(faitCourant.getValue())) {

						result= verificationFaitNumerique(fait, faitCourant);
					}
					else {

						result= verificationFaitString(fait, faitCourant);
					}
				}
				else {
					return result;
				}
			}
		}
		return result;
	}

	public boolean baseDeFaitContientFait(List<Fait> baseDeFaits, Fait faitCourant) {
		boolean result= false;

		for (Fait fait : baseDeFaits) {
			if(fait.getNom().equals(faitCourant.getNom())) {
				result= true;
			}
		}
		return result;
	}

	public boolean verificationNumerique(String valeurFait) {
		try  
		{  
			double d = Double.parseDouble(valeurFait);  
		}  
		catch(NumberFormatException nfe)  
		{  
			return false;  
		}  
		return true;
	}

	public boolean verificationFaitNumerique(Fait faitBase,Fait faitCourant) {
		boolean result=false;
		Double valeurFaitBase=Double.parseDouble(faitBase.getValue());
		Double valeurFaitCourant=Double.parseDouble(faitCourant.getValue());

		switch (faitCourant.getOperator()) {
		case SUPERIOR:
			result= valeurFaitBase > valeurFaitCourant; 
			break;
		case SUPERIOR_OR_EQUAL:
			result= valeurFaitBase >= valeurFaitCourant;
			break;
		case INFERIOR:
			result= valeurFaitBase < valeurFaitCourant;
			break;
		case INFERIOR_OR_EQUAL:
			result= valeurFaitBase <= valeurFaitCourant;
			break;
		case DIFFERENT:
			result= valeurFaitBase != valeurFaitCourant;
			break;
		case EQUAL:
			result = valeurFaitBase == valeurFaitCourant ;
			break;

		default:
			result=false;
			break;
		}
		
		return result;

	}

	public boolean verificationFaitString(Fait faitBase,Fait faitCourant) {
		boolean result=false;
		
		switch (faitCourant.getOperator()) {
		
		case SUPERIOR:
			result= faitBase.getValue().compareTo(faitCourant.getValue()) > 0; 
			break;
		case SUPERIOR_OR_EQUAL:
			result= faitBase.getValue().compareTo(faitCourant.getValue()) >= 0;
			break;
		case INFERIOR:
			result= faitBase.getValue().compareTo(faitCourant.getValue()) < 0;
			break;
		case INFERIOR_OR_EQUAL:
			result= faitBase.getValue().compareTo(faitCourant.getValue()) <= 0;
			break;
		case DIFFERENT:
			result= !faitBase.getValue().equals(faitCourant.getValue());
			break;
		case EQUAL:
			result = faitBase.getValue().equals(faitCourant.getValue()) ;
			break;

		default:
			result=false;
			break;
		}
		return result;

	}

	public void chainageArrière(Fait factToProve) {
		
		ArrayList<Regle> rulesTemp = new ArrayList<Regle> (baseDeRegle);
		ArrayList<Fait> factsTemp =  new ArrayList<Fait> (baseDeFaits);
		ArrayList<Fait> factsToProve = new ArrayList<Fait>() ;
		factsToProve.add(factToProve);
		
		System.out.println("Base de fait à l'état initial : "+factsTemp);
		while(!baseDeFaitContientFait(factsTemp,factToProve)) {
			
			ArrayList<Regle> ensembleDeRegleValides = new ArrayList<Regle>();
			
			for (Regle regle : rulesTemp) {
				
				int nbrConclusion=0;
				
				Conclusion conclusionActuelle=regle.getConclusion();
				while(conclusionActuelle!=null) {
					if(verifierFait(factsToProve, conclusionActuelle.getFait())) {
						nbrConclusion++;
					}
					conclusionActuelle=conclusionActuelle.getConclusionEventuelle();
				}
				
				if(nbrConclusion==regle.nombreDeConclusion()) {
					System.out.println("On ajoute la regle valide : "+regle.toString());
					ensembleDeRegleValides.add(regle);
				}	
			}
			
			//on verifie si on a des règles valides
			
			if(!ensembleDeRegleValides.isEmpty()) {
				//on parcour les regles valides
				for (Regle regle : ensembleDeRegleValides) {
					int nbrPremisse=0;
					
					Premisse premisseActuelle=regle.getPremisse();
					while(premisseActuelle!=null) {

						if(verifierFait(factsTemp, premisseActuelle.getFait())) {
							nbrPremisse++;
						}
						premisseActuelle=premisseActuelle.getPremisseEventuelle();
					}
					
					if(nbrPremisse==regle.nombreDePremisse()) {
						System.out.println("Premisse de la règle en base de fait !");
						Conclusion conclusionActuelle=regle.getConclusion();
						while(conclusionActuelle!=null) {
							System.out.println("On ajoute la conclusion en base de fait : "+conclusionActuelle.getFait().toString());
							factsTemp.add(conclusionActuelle.getFait());
							factsToProve.remove(conclusionActuelle.getFait());
							
							conclusionActuelle=conclusionActuelle.getConclusionEventuelle();
							
						}
						
						rulesTemp.remove(regle);
					}
					else {
						Premisse premisseActuelleAAjouter=regle.getPremisse();
						while(premisseActuelleAAjouter!=null) {
							//System.out.println("On ajoute a la base de faits, la premisse : "+premisseActuelleAAjouter.getFait());
							factsToProve.add(premisseActuelleAAjouter.getFait());
							//System.out.println("Base de fait apres injection : "+factsToProve);
							premisseActuelleAAjouter=premisseActuelleAAjouter.getPremisseEventuelle();
						}
						
					}
				}
			}
			else{
				//sinon on break le while
				break;
			}
		}
		System.out.println("La base de faits à l'état final contient : "+factsTemp.toString());

		if(bdFContientFait(factsTemp,factToProve)) {	
			System.out.println(" fact is proved.");
		}else {
			System.out.println(" fact is wrong.");
		}
	}

}
