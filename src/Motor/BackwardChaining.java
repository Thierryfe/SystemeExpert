package Motor;

import Data.Fact;
import Data.FactsBase;
import Data.RulesBase;

public class BackwardChaining implements Motor {

	private FactsBase facts;
	private RulesBase rules;


	public BackwardChaining(FactsBase facts, RulesBase rules) {
		super();
		this.facts = facts;
		this.rules = rules;
	}


	public void work(Fact factToProve) {
		// TODO Auto-generated method stub
		//entr�es : base de faits, base de r�gle et un fait que l'on doit prouver
		//rechercher toute les r�gles qui donnent sur ce fait et en faire une liste

	}


}
