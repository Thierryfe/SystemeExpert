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
		//entrées : base de faits, base de règle et un fait que l'on doit prouver
		//tant que le fait n'est pas dans la base de faits && que dans BR il ya une règle applciable
			//choisir règle applicable
			//on désactive cette règle de la base de règle
			//on afjoute cette règle à labase de faits
		//si le fait appartient à la base de faits
			//retourner true
		
		while(!facts.containsFact(factToProve)) {
			
		}
	}

}
