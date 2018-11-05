package Rework;


public class Conclusion {
	public Fait fait;
	public Conclusion conclusionEventuelle;
	public Conclusion(Fait fait, Conclusion conclusionEventuelle) {
		super();
		this.fait = fait;
		this.conclusionEventuelle = conclusionEventuelle;
	}
	public Fait getFait() {
		return fait;
	}
	public void setFait(Fait fait) {
		this.fait = fait;
	}
	
	public Conclusion getConclusionEventuelle() {
		return conclusionEventuelle;
	}
	public void setConclusionEventuelle(Conclusion conclusionEventuelle) {
		this.conclusionEventuelle = conclusionEventuelle;
	}
	public String toString() {
		String result="Fait : "+fait.getNom()+" valeur : "+fait.getValue() +" operateur : "+fait.getOperator().toString();
		if(conclusionEventuelle!=null)
			result+="Fait suivant :"+conclusionEventuelle.toString();
		return result;
	}
	
}
