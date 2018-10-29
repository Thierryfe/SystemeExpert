package Data;

public class Rule {
	
	private FactsBase premise;
	private FactsBase consequence;
	
	public Rule() {
		super();
		this.premise = new FactsBase();
		this.consequence = new FactsBase();
	}
	
	public void addFactInPremise(Fact fact) {
		this.premise.addFact(fact);
	}
	
	public void addFactInConsequence(Fact fact) {
		this.consequence.addFact(fact);
	}

	
	public FactsBase getPremise() {
		return premise;
	}

	public void setPremise(FactsBase premise) {
		this.premise = premise;
	}

	public FactsBase getConsequence() {
		return consequence;
	}

	public void setConsequence(FactsBase consequence) {
		this.consequence = consequence;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String string = "";
		
		for(Fact f : premise) {
			string += f.toString();
		}
		
		string += " ALORS ";
		
		for(Fact f : consequence) {
			string += f.toString();
		}
		
		return string;
	}
	
	
}
