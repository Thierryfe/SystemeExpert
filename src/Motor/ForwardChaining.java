package Motor;

import java.util.ArrayList;

import Data.Fact;
import Data.FactsBase;
import Data.Rule;
import Data.RulesBase;

public class ForwardChaining implements Motor {

	private FactsBase facts;
	private RulesBase rules;


	public ForwardChaining(FactsBase facts, RulesBase rules) {
		super();
		this.facts = facts;
		this.rules = rules;
	}

	public void work(Fact factToProve) {
		//entr�es : base de faits, base de r�gle et un fait que l'on doit prouver
		//tant que le fait n'est pas dans la base de faits && que dans BR il ya une r�gle applciable
		//choisir r�gle applicable
		//on d�sactive cette r�gle de la base de r�gle
		//on afjoute cette r�gle � labase de faits
		//si le fait appartient � la base de faits
		//retourner true
		RulesBase rulesTemp = rules;
		FactsBase factsTemp =  facts;

		System.out.println("Starting forwardchaining...");

		System.out.println(factsTemp.factsRemaining()+" facts in fact base ! " + factsTemp.toString());

		System.out.println(rulesTemp.size()+" rules in rule base ! ");

		System.out.println("Target : "+factToProve.toString());
		int iteration=0;
		while(!factsTemp.containsFact(factToProve)&& rulesTemp.isApplicableRuleExisting(factsTemp)) {
			//on prepare la r�gle applicable
			Rule applicableRule= null;
			//on cherche une r�gle applicable dans la base de r�gle
			for (Rule ruleTocheck : rulesTemp) {
				//System.out.println("on parcours les r�gles, on est sur  : "+ruleTocheck.toString());
				//si on trouve une r�gle applicable donc une pr�misse de cette r�gles dans la base de fait
				//alors
				// on le r�cupere
				// on retire cette r�gle de la base de r�gle
				// on stop le for
				// on ajoute la conclusion de cette r�gle � la base de fait
				for(Fact premise : ruleTocheck.getPremise()) {
					//System.out.println("Premisse : "+premisse.toString());
					if(factsTemp.containsFact(premise) ) {
						//	System.out.println("Premisse dans la base de fait !");
						applicableRule= ruleTocheck;
						System.out.println(" Applicable rule : "+applicableRule.toString()); 
						break;
					}
				}
				if(applicableRule!=null)
					break;
			}
			
			if(applicableRule!=null) {
				rulesTemp.remove(applicableRule);
				for(Fact consequence: applicableRule.getConsequence()) {

					factsTemp.addFact(consequence);
				}
			}
			
			

		}
		System.out.println(factsTemp.factsRemaining()+" facts in fact base ! " + factsTemp.toString());

		System.out.println(rulesTemp.size()+" rules in rule base ! ");

		if(factsTemp.containsFact(factToProve)) {	
			System.out.println(" fact is proved.");
		}else {
			System.out.println(" fact is wrong.");
		}



	}

}
