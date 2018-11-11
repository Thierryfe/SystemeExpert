package Rework;

public class Premisse {
	public Fait fait;
	public Premisse premisseEventuelle;
	
	public Premisse(Fait fait,  Premisse premisseEventuelle) {
		super();
		this.fait = fait; 
		this.premisseEventuelle = premisseEventuelle;
	}

	public Fait getFait() {
		return fait;
	}

	public void setFait(Fait fait) {
		this.fait = fait;
	}


	public Premisse getPremisseEventuelle() {
		return premisseEventuelle;
	}

	public void setPremisseEventuelle(Premisse premisseEventuelle) {
		this.premisseEventuelle = premisseEventuelle;
	}
	
	public String toString() {
		String result="\n["+fait.getNom() +" "+fait.getOperator().toString()+" "+fait.getValue()+"]";
		if(premisseEventuelle!=null)
			result+=premisseEventuelle.toString();
		return result;
	}
}
