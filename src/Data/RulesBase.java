package Data;

import java.util.ArrayList;

public class RulesBase extends ArrayList<Rule>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RulesBase() {
		super();
	}
	
	public boolean isApplicableRuleExisting(FactsBase fB) {
		//on verifie si pour chaque règle il y a une prémisse dans la base de faits
		return true;
	}
	
}
