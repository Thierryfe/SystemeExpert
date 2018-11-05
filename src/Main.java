import Data.Fact;
import Data.FactsBase;
import Data.GeneratRuleBased;
import Motor.ForwardChaining;

public class Main {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		GeneratRuleBased rb = new GeneratRuleBased("Rules");
		rb.generateRuleBased();
		
		FactsBase fb= new FactsBase();
	//	fb.addFact(new Fact("auteur","Boris_Vian"));
	//	fb.addFact(new Fact("theme","dictature"));
		
	// target = new Fact("auteur","George_Orwell");
		
// forward= new ForwardChaining(fb, rb.getRulesBase());
		
	//	forward.work(target);
	}
}