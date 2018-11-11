import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

import Moteur.CreateBaseDeRegle;
import Moteur.Fait;
import Moteur.Moteur;
import Moteur.Regle;

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
				System.out.println("1. Start forward chaining");
				System.out.println("2. Start backward chaining");
				System.out.println("3. Exit");
				BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				String line = reader.readLine();

				if(line.equals("1")) {
					m.chainageAvant(butMenu());
				}
				else if(line.equals("2")) {
					m.chainageArrière(butMenu());
					
				}else if(line.equals("3")) {
					System.out.println("Expert system app closed.");
					break;
					
				}
				else {
					System.out.println("Incorrect input.");
				}

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("IO error...");
		}
		//m.chainageArrière(but);

	}

	public static Fait butMenu() {
		Fait butResult=null;
		while(true) {
			System.out.println(" Use default fact  ?(Y/N)");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			String line;
			try {
				line = reader.readLine();
				if(line.equals("Y")) {
					butResult=new Fait("livre","=","J_irai_cracher_sur_vos_tombes");
					break;
				}
				else if(line.equals("N")) {
					while(true) {
						System.out.println("Name of the fact :");
						String nameLine;
						nameLine = reader.readLine();
						String operatorLine;
						while(true) {
							System.out.println("Operator :");
							System.out.println("1. <");
							System.out.println("2. >");
							System.out.println("3. =");
							System.out.println("4. <=");
							System.out.println("5. >=");
							System.out.println("6. !=");

							;
							operatorLine = reader.readLine();

							if(operatorLine.equals("1")||operatorLine.equals("2")||operatorLine.equals("3")||operatorLine.equals("4")||operatorLine.equals("5")||operatorLine.equals("6")) {
								switch (operatorLine) {
								case "1":
									operatorLine="<";
									break;
								case "2":
									operatorLine=">";
									break;
								case "3":
									operatorLine="=";
									break;
								case "4":
									operatorLine="<=";
									break;
								case "5":
									operatorLine=">=";
									break;
								case "6":
									operatorLine="!=";
									break;
								}
								break;
							}else {
								System.out.println("Incorrect input.");
							}
						}
						System.out.println("Value of the fact :");
						String valueLine;
						valueLine=reader.readLine();
						
						
						while(true) {
							System.out.println("Fact : "+nameLine+" "+operatorLine+" "+valueLine);
							System.out.println("It is correct ?(Y/N)");
							line=reader.readLine();
							if(line.equals("Y")) {
								butResult= new Fait(nameLine,operatorLine,valueLine);
								break;
							}else if(line.equals("N")) {
								System.out.println("Reseting inputs...");
							}else {
								System.out.println("Incorrect input.");
							}
						}
						if(butResult!=null)
							break;

					}
					break;
				}else {
					System.out.println("Incorrect input.");
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


		}

		return butResult;

	}
}