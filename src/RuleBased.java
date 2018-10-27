import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class RuleBased {
	private String fileName;

	public RuleBased(String fileName) {
		super();
		this.fileName = fileName;
	}
	
	public void generateRuleBased() {
		try {
			InputStream in = new FileInputStream(this.fileName);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
