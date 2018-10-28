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
	
	public void addRule(Rule r) {
		super.add(r);
	}
	
	public void removeRule(Rule r) {
		super.remove(r);
	}
	
	public int ruleRemaining() {
		return super.size();
		
	}
	
	public boolean containsRule(Rule r) {
		return false;
		
	}
	
	public boolean isApplicableRuleExisting(FactsBase fB) {
		//on verifie si pour chaque regle il y a une premisse dans la base de faits
		return true;
	}
	
}
