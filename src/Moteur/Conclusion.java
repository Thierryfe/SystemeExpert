package Moteur;

/**
 * 
 *
 *         Classe similaire à prémisse symbolisant une conclusion, une
 *         conclusion possède un fait et evntuellement un autre fait. Exemple :
 *         fait1 && fait2 && fait3 
 *         Correspond à une conclusion composée de 3 faits 
 *         L'attribut conclusionEventuelle de type conclusion permet de
 *         modeliser cette chaine
 */
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
		String result = "\n[" + fait.getNom() + " " + fait.getOperator().toString() + " " + fait.getValue() + "]";
		if (conclusionEventuelle != null)
			result += conclusionEventuelle.toString();
		return result;
	}

}
