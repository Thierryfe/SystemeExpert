package Data;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
				Pattern p = Pattern.compile("^([a-zA-Z0-9_]+)([<>]?=)([a-zA-Z0-9_]+)$");
				String line = br.readLine();
				
				while(line != null) {
					Rule rule = new Rule();
					String[] result = line.split(" ALORS ");
					String[] premise = result[0].split(" ");
					String[] consequence = result[1].split(" ");
					
					for(String s : premise) {
						Matcher m = p.matcher(s);
						if(m.matches()) {
							//System.out.println(m.group(1)+m.group(2)+m.group(3));
						//	rule.addFactInPremise(new Fact(m.group(1), m.group(2), m.group(3)));
						}
					}
					
					for(String s : consequence) {
						Matcher m = p.matcher(s);
						if(m.matches()) {
							//System.out.println(m.group(1)+m.group(2)+m.group(3));
						//	rule.addFactInConsequence(new Fact(m.group(1), m.group(2), m.group(3)));
						}
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
