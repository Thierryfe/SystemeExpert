package IHM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import Moteur.CreateBaseDeRegle;
import Moteur.CreerBaseIncoherence;
import Moteur.Fait;
import Moteur.Moteur;
import Moteur.Regle;

public class MenuConsole {
	public static void menuConsole() {
		CreateBaseDeRegle rb = new CreateBaseDeRegle("Rules");
		rb.generateRuleBased();

		ArrayList<Regle>baseDeRegle=rb.getRulesBase();

		ArrayList<Fait>baseDeFait= new ArrayList<Fait>();

		baseDeFait.add(new Fait("auteur","=","Boris_Vian"));

		baseDeFait.add(new Fait("theme","=","vengeance"));

		Fait but = new Fait("livre","=","J_irai_cracher_sur_vos_tombes");


		Moteur m = new Moteur(baseDeFait,baseDeRegle);

		try {
			while(true) {
				System.out.println("\n1. Start forward chaining");
				System.out.println("2. Start backward chaining");
				System.out.println("3. Exit  \n");
				BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				String line = reader.readLine();

				if(line.equals("1")) {
					boolean isTrace=false;
					while(true) {
						System.out.println("Enable trace ?(Y/N)");
						line=reader.readLine();

						if(line.equals("Y")) {
							isTrace=true;
							break;
						}
						if(line.equals("N")) {
							break;
						}
					}
					m.chainageAvant(butMenu(),isTrace);
				}
				else if(line.equals("2")) {
					boolean isTrace=false;
					while(true) {
						System.out.println("Enable trace ?(Y/N)");
						line=reader.readLine();

						if(line.equals("Y")) {
							isTrace=true;
							break;
						}
						if(line.equals("N")) {
							break;
						}
					}
					m.chainageArriere(butMenu(),isTrace);

				}else if(line.equals("3")) {
					System.out.println("Expert system app closed.");
					break;

				}
				else {
					System.out.println("Incorrect input.  \n");
				}

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("IO error...");
		}
	}

	public static Fait butMenu() {
		Fait butResult=null;
		while(true) {
			System.out.println(" Use default fact  ?(Y/N) \n");
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
						System.out.println("Name of the fact : \n");
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
							System.out.println("6. !=  \n");

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
						System.out.println("Value of the fact :\n");
						String valueLine;
						valueLine=reader.readLine();
						
						
						while(true) {
							System.out.println("Fact : "+nameLine+" "+operatorLine+" "+valueLine);
							System.out.println("It is correct ?(Y/N)\n");
							line=reader.readLine();
							if(line.equals("Y")) {
								butResult= new Fait(nameLine,operatorLine,valueLine);
								break;
							}else if(line.equals("N")) {
								System.out.println("Reseting inputs...\n");
							}else {
								System.out.println("Incorrect input.\n");
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
