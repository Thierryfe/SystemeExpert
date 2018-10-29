package Data;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class GeneratRuleBased {
	private File file;
	private RulesBase rulesBase;

	public GeneratRuleBased(String fileName) {
		super();
		this.file = new File(fileName);
		this.rulesBase = new RulesBase();
	}
	
	public void generateRuleBased() {
		try {
			FileReader fr = new FileReader(this.file);
			BufferedReader br = new BufferedReader(fr);
			
			try {
				String line = br.readLine();
				
				while(line != null) {
					Rule rule = new Rule();
					String[] result = line.split(" ALORS ");
					String[] premise = result[0].split(" ");
					String[] consequence = result[1].split(" ");
					
					for(String s : premise) {
						String[] equal = s.split("=");
						rule.addFactInPremise(new Fact(equal[0], equal[1]));
					}
					
					for(String s : consequence) {
						String[] equal = s.split("=");
						rule.addFactInConsequence(new Fact(equal[0], equal[1]));
					}
					
					this.rulesBase.addRule(rule);
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

	public RulesBase getRulesBase() {
		return rulesBase;
	}
	
	
}
