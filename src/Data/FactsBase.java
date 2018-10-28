package Data;

import java.util.ArrayList;

public class FactsBase extends ArrayList<Fact> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public FactsBase() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void addFact(Fact f) {
		super.add(f);
	}
	
	public void removeFact(Fact f) {
		super.remove(f);
	}
	
	public int factsRemaining() {
		return super.size();
		
	}
	
	public boolean containsFact(Fact f) {
		return false;
		
	}
}
