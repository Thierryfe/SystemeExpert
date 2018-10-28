package Motor;

import java.util.List;

import Data.Fact;
import Data.Rule;

public class MixingChaining implements Motor {

	private List<Fact> facts;
	private List<Rule> rules;


	public MixingChaining(List<Fact> facts, List<Rule> rules) {
		super();
		this.facts = facts;
		this.rules = rules;
	}


	public void work() {
		//entrée :  un fait que l'on doit prouver
		// remplir la base faits par chainage avant
		//rechercher les faits déductibles
		//creer une question pertinente
		//traiter sa réponse pour l'inserer dans la base de fait
	}


	@Override
	public void work(Fact factToProve) {
		// TODO Auto-generated method stub
		
	}

}
