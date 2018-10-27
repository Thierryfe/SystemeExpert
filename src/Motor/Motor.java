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
		
		//entrées : base de faits, base de règle et un fait que l'on doit prouver
		//rechercher toute les règles qui donnent sur ce fait et en faire une liste
		
		
	}
	
	public void forwardChaining() {
		//entrées : base de faits, base de règle et un fait que l'on doit prouver
		//tant que le fait n'est pas dans la base de faits && que dans BR il ya une règle applciable
			//choisir règle applicable
			//on désactive cette règle de la base de règle
			//on afjoute cette règle à labase de faits
		//si le fait appartient à la base de faits
			//retourner true
	}
	
	
	public void mixingChaining() {
		//entrée :  un fait que l'on doit prouver
		// remplir la base faits par chainage avant
		//rechercher les faits déductibles
		//creer une question pertinente
		//traiter sa réponse pour l'inserer dans la base de fait
	}

}
