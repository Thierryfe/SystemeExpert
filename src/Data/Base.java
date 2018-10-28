package Data;

import java.util.ArrayList;
import java.util.List;


public abstract class Base<T> {
	
	private List<T> facts = new ArrayList<T>();
	
	public Base() {	
	}
	
	public void addFact(T f) {
		facts.add(f);
	}
	
	public void removeFact(T f) {
		facts.remove(f);
	}
	
	public int factsRemaining() {
		return facts.size();
	}
	
	public boolean containsFact(T f) {
		return facts.contains(f);
	}
	
	
}