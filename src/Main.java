import java.util.ArrayList;


import Rework.CreateBaseDeRegle;
import Rework.Fait;
import Rework.Moteur;
import Rework.Regle;


public class Main {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CreateBaseDeRegle rb = new CreateBaseDeRegle("Rules");
		rb.generateRuleBased();
		
		ArrayList<Regle>baseDeRegle=rb.getRulesBase();
		
		ArrayList<Fait>baseDeFait= new ArrayList<Fait>();
		
		baseDeFait.add(new Fait("auteur","=","Boris_Vian"));

		baseDeFait.add(new Fait("theme","=","vengeance"));
		
		Fait but = new Fait("livre","=","J_irai_cracher_sur_vos_tombes");
		
		
		Moteur m = new Moteur(baseDeFait,baseDeRegle);
		
		m.chainageAvant(but);
		
//	
		}
}