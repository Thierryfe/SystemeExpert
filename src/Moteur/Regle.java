package Moteur;

public class Regle {
	Premisse premisse;
	Conclusion conclusion;
	
	public Regle() {
		super();
		this.premisse = null;
		this.conclusion = null;
	}
	
	public Premisse getPremisse() {
		return premisse;
	}

	public void setPremisse(Premisse premisse) {
		this.premisse = premisse;
	}

	public Conclusion getConclusion() {
		return conclusion;
	}

	public void setConclusion(Conclusion conclusion) {
		this.conclusion = conclusion;
	}

	public int nombreDePremisse() {
		int cpt=0;
		Premisse premisseActuelle=premisse;
	
		while(premisseActuelle!=null) {
			cpt++;
			premisseActuelle=premisseActuelle.getPremisseEventuelle();
		}
		
		return cpt;
		
	}
	
	public int nombreDeConclusion() {
		int cpt=0;
		Conclusion conclusionActuelle=conclusion;
	
		while(conclusionActuelle!=null) {
			cpt++;
			conclusionActuelle=conclusionActuelle.getConclusionEventuelle();
		}
		
		return cpt;
		
	}
	public String toString() {
		String result="";
		result+="\n Premisse(s) :" + premisse.toString();
		result+="\n Conclusion(s) :" + conclusion.toString();
		return result;
	}
}
