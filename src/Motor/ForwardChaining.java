package Motor;

import java.util.List;

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
	
	@Override
	public void work(Fact factToProve) {
		//entr�es : base de faits, base de r�gle et un fait que l'on doit prouver
		//tant que le fait n'est pas dans la base de faits && que dans BR il ya une r�gle applciable
			//choisir r�gle applicable
			//on d�sactive cette r�gle de la base de r�gle
			//on afjoute cette r�gle � labase de faits
		//si le fait appartient � la base de faits
			//retourner true
		
		while(!facts.containsFact(factToProve)) {
			
		}
	}

}
