package Motor;
import java.util.List;

import Data.Fact;
import Data.Rule;
public class Motor {
	private List<Fact> facts;
	private List<Rule> rules;
	
	public Motor(List<Fact> facts, List<Rule> rules) {
		super();
		this.facts = facts;
		this.rules = rules;
	}

	
	public void backwardChaining() {
		
		//entr�es : base de faits, base de r�gle et un fait que l'on doit prouver
		//rechercher toute les r�gles qui donnent sur ce fait et en faire une liste
		
		
	}
	
	public void forwardChaining() {
		//entr�es : base de faits, base de r�gle et un fait que l'on doit prouver
		//tant que le fait n'est pas dans la base de faits && que dans BR il ya une r�gle applciable
			//choisir r�gle applicable
			//on d�sactive cette r�gle de la base de r�gle
			//on afjoute cette r�gle � labase de faits
		//si le fait appartient � la base de faits
			//retourner true
	}
	
	
	public void mixingChaining() {
		//entr�e :  un fait que l'on doit prouver
		// remplir la base faits par chainage avant
		//rechercher les faits d�ductibles
		//creer une question pertinente
		//traiter sa r�ponse pour l'inserer dans la base de fait
	}

}
