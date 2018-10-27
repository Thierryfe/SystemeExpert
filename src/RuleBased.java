import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class RuleBased {
	private File file;

	public RuleBased(String fileName) {
		super();
		this.file = new File(fileName);
	}
	
	public void generateRuleBased() {
		try {
			FileReader fr = new FileReader(this.file);
			BufferedReader br = new BufferedReader(fr);
			
			try {
				String line = br.readLine();
				
				while(line != null) {
					System.out.println(line);
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
}
