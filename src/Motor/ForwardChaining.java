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
		//entrï¿½es : base de faits, base de rï¿½gle et un fait que l'on doit prouver
		//tant que le fait n'est pas dans la base de faits && que dans BR il ya une rï¿½gle applciable
		//choisir rï¿½gle applicable
		//on dï¿½sactive cette rï¿½gle de la base de rï¿½gle
		//on afjoute cette rï¿½gle ï¿½ labase de faits
		//si le fait appartient ï¿½ la base de faits
		//retourner true
		RulesBase rulesTemp = rules;
		FactsBase factsTemp =  facts;

		System.out.println("Starting forwardchaining...");

		System.out.println(factsTemp.factsRemaining()+" facts in fact base ! " + factsTemp.toString());

		System.out.println(rulesTemp.size()+" rules in rule base ! ");

		System.out.println("Target : "+factToProve.toString());
		int iteration=0;
		while(!factsTemp.containsFact(factToProve)&& rulesTemp.isApplicableRuleExisting(factsTemp)) {
			//on prepare la rï¿½gle applicable
			Rule applicableRule= null;
			//on cherche une rï¿½gle applicable dans la base de rï¿½gle
			for (Rule ruleTocheck : rulesTemp) {
				//System.out.println("on parcours les règles, on est sur  : "+ruleTocheck.toString());
				//si on trouve une rï¿½gle applicable donc une prémisse de cette règles dans la base de fait
				//alors
				// on le récupere
				// on retire cette rï¿½gle de la base de rï¿½gle
				// on stop le for
				// on ajoute la conclusion de cette rï¿½gle ï¿½ la base de fait
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
