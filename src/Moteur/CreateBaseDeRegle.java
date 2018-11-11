package Moteur;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class CreateBaseDeRegle {
	private File file;
	private ArrayList<Regle> baseDeRegle;

	public CreateBaseDeRegle(String fileName) {
		super();
		this.file = new File(fileName);
		this.baseDeRegle = new ArrayList<Regle>();
	}
	
	public void generateRuleBased() {
		try {
			FileReader fr = new FileReader(this.file);
			BufferedReader br = new BufferedReader(fr);
			
			try {
				Pattern p = Pattern.compile("^([a-zA-Z0-9_]+)(<|>|=|>=|<=)([a-zA-Z0-9_]+)$");
				String line = br.readLine();
			//	System.out.println("ligne à parser : "+line);
				while(line != null) {
					Regle rule = new Regle();
					String[] result = line.split(" ALORS ");
					String[] premise = result[0].split(" ");
					String[] consequence = result[1].split(" ");
				//	System.out.println("Result trouvé : "+result[0]);
				//	System.out.println("Premisse trouvé : "+premise[1]);
				//	System.out.println("Concluision trouvé : "+consequence[0]);
					Premisse premissesPrincipale= null;
					Premisse premissesSuivante= null;
					for(String s : premise) {
						Matcher m = p.matcher(s);
						if(m.matches()) {
							
							if (premissesPrincipale == null) {
								premissesPrincipale=new Premisse(new Fait(m.group(1), m.group(2), m.group(3)),null);
								//System.out.println("operateur "+premissesPrincipale.getFait().getOperator());
							}else {
								Premisse premisseTmp= premissesSuivante;
								premissesSuivante= new Premisse(new Fait(m.group(1), m.group(2), m.group(3)),null);
								premissesSuivante.setPremisseEventuelle(premisseTmp);
								premissesPrincipale.setPremisseEventuelle(premissesSuivante);
								
							}
						//	rule.addFactInPremise(new Fact(m.group(1), m.group(2), m.group(3)));
						}
					}
				//	System.out.println("on ajoute la premisse : "+premissesPrincipale.getFait().getNom());
					rule.setPremisse(premissesPrincipale);
					
					Conclusion conclusionPrincipale= null;
					Conclusion conclusionSuivante= null;
					for(String s : consequence) {
						Matcher m = p.matcher(s);
						if(m.matches()) {
							//System.out.println(m.group(1)+m.group(2)+m.group(3));
						//	rule.addFactInConsequence(new Fact(m.group(1), m.group(2), m.group(3)));
							if (conclusionPrincipale == null)
								conclusionPrincipale=new Conclusion(new Fait(m.group(1), m.group(2), m.group(3)),null);
							else {
								Conclusion conlusionTmp= conclusionSuivante;
								conclusionSuivante= new Conclusion(new Fait(m.group(1), m.group(2), m.group(3)),null);
								conclusionSuivante.setConclusionEventuelle(conlusionTmp);
								conclusionPrincipale.setConclusionEventuelle(conclusionSuivante);
								
							}
						}
					}
					rule.setConclusion(conclusionPrincipale);
					//System.out.println("On ajout la règle : "+rule);
					this.baseDeRegle.add(rule);
					//System.out.println(rule);
					line = br.readLine();
				}
				
				br.close();
				fr.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("Read line error : " + e.getMessage());
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("File doesn't find");
		}
		
	
		
		
		
	}

	public ArrayList<Regle> getRulesBase() {
		return baseDeRegle;
	}
	
	
}
