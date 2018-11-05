package Rework;

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
	public String toString() {
		String result="";
		result+=" Premisse :" + premisse.toString();
		result+=" Conclusion :" + conclusion.toString();
		return result;
	}
}
