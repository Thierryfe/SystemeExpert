package Moteur;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CreerBaseIncoherence {
	private File file;
	private List<Incoherence> listeCoherence;
	
	public CreerBaseIncoherence(String file) {
		this.file = new File(file);
		this.listeCoherence = new ArrayList<Incoherence>();
	}
	
	public void genererBaseIncoherence() {
		
		try {
			FileReader fr = new FileReader(this.file);
			BufferedReader br = new BufferedReader(fr);
			
			try {
				Pattern p = Pattern.compile("^([a-zA-Z0-9_]+)(<|>|=|>=|<=)([a-zA-Z0-9_]+)$");
				
				String line = br.readLine();
				
				while(line != null) {
					String[] s = line.split(" ");
					
					Matcher m = p.matcher(s[0]);
					
					m.matches();

					Fait fait = new Fait(m.group(1), m.group(2), m.group(3));

					this.listeCoherence.add(new Incoherence(fait));
					
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
	
	public boolean compare(ArrayList<Regle> baseDeRegle) {
		for(Incoherence i : this.listeCoherence) {
			for(Regle r : baseDeRegle) {
				List<Premisse> p = new ArrayList<Premisse>();
				Premisse tmp = r.getPremisse();
				p.add(tmp);
				while(tmp.getPremisseEventuelle() != null) {
					p.add(tmp.getPremisseEventuelle());
					tmp = tmp.getPremisseEventuelle();
				}
				
				for(Premisse pre : p) {
					if(pre.getFait().equals(i.getFait())) {
						return false;
					}
				}
			}
		}
		return true;
	}
	
	public boolean compareFact(ArrayList<Fait>bdf) {
		for(Incoherence i : this.listeCoherence) {
			for(Fait f : bdf) {
				
					if(f.equals(i)) {
						return false;
					}
				
			}
		}
		return true;
	}
}