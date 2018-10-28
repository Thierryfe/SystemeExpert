package Motor;

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
		
		while(!facts.containsFact(factToProve)&& rules.isApplicableRuleExisting(facts)) {
			
			//on prepare la r�gle applicable
			Rule applicableRule= null;
			//on cherche une r�gle applicable dans la base de r�gle
			for (Rule ruleTocheck : rules) {
				//si on trouve une r�gle applicable
				//alors
				// on le r�cupere
				// on retire cette r�gle de la base de r�gle
				// on stop le for
			}
			
			//pn ajoute la conclusion de cette r�gle � la base de fait
			
		
		}
		
		if(facts.containsFact(factToProve)) {	
			System.out.println("fact is proved.");
		}else {
			System.out.println("fact is wrong.");
		}
	}

}
