package Motor;

import java.util.List;

import Data.Fact;
import Data.Rule;

public class BackwardChaining implements Motor {

	private List<Fact> facts;
	private List<Rule> rules;


	public BackwardChaining(List<Fact> facts, List<Rule> rules) {
		super();
		this.facts = facts;
		this.rules = rules;
	}


	public void work() {

		//entr�es : base de faits, base de r�gle et un fait que l'on doit prouver
		//rechercher toute les r�gles qui donnent sur ce fait et en faire une liste


	}


}
