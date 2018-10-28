package Motor;

import java.util.List;

import Data.Fact;
import Data.Rule;

public class ForwardChaining implements Motor {

	private List<Fact> facts;
	private List<Rule> rules;


	public ForwardChaining(List<Fact> facts, List<Rule> rules) {
		super();
		this.facts = facts;
		this.rules = rules;
	}
	
	public void work() {
		//entrées : base de faits, base de règle et un fait que l'on doit prouver
		//tant que le fait n'est pas dans la base de faits && que dans BR il ya une règle applciable
			//choisir règle applicable
			//on désactive cette règle de la base de règle
			//on afjoute cette règle à labase de faits
		//si le fait appartient à la base de faits
			//retourner true
	}
	

}
