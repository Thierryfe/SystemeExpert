import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

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
		
		System.out.println("Starting Expert system app :\n");
		
		try {
			while(true) {
				System.out.println("Press 1 to start forward chaining :\n");
				System.out.println("Press 2 to start backward chaining :\n");
				BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				String line = reader.readLine();
				
				if(line.equals("1")) {
					m.chainageAvant(but);
				}
				else if(line.equals("2")) {
					m.chainageArrière(but);
				}
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("IO error...");
		}
		//m.chainageArrière(but);

		//FactsBase fb= new FactsBase();
		//		fb.addFact(new Fact("auteur","Boris_Vian"));
		//		fb.addFact(new Fact("theme","dictature"));
		//		
		//		Fact target = new Fact("auteur","George_Orwell");
		//		
		//		ForwardChaining forward= new ForwardChaining(fb, rb.getRulesBase());
		//		
		//		forward.work(target);
		//	
	}
}