package Moteur;

public class Incoherence {
	private Fait fait;
	
	public Incoherence(Fait fait) {
		this.fait = fait;
	}

	public Fait getFait() {
		return fait;
	}

	public void setFait(Fait fait) {
		this.fait = fait;
	}

	@Override
	public String toString() {
		return "Coherence [fait=" + fait + "]";
	}
}

