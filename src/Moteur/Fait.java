package Moteur;

import Data.Operator;

/**
 *   Classe modélisant un fait, composé d'un nom d'un opérateur et
 *         d'une valeur 
 *         Exemple : livre = Les_enfants_de_Hurin
 */
public class Fait {

	public String nom;
	public Operator operator;
	public String value;

	public Fait(String nom, String operator, String value) {
		super();
		this.nom = nom;
		this.operator = setOperator(operator);
		this.value = value;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Operator getOperator() {
		return operator;
	}

	public void setOperator(Operator operator) {
		this.operator = operator;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Operator setOperator(String operator) {
		if (operator.equals(">=")) {
			return Operator.SUPERIOR_OR_EQUAL;
		}
		if (operator.equals(">")) {
			return Operator.SUPERIOR;
		}
		if (operator.equals("<=")) {
			return Operator.INFERIOR_OR_EQUAL;
		}
		if (operator.equals("<")) {
			return Operator.INFERIOR;
		}
		if (operator.equals("=")) {

			return Operator.EQUAL;
		}
		if (operator.equals("!=")) {
			return Operator.DIFFERENT;
		}

		return null;
	}

	public String toString() {
		return nom + " " + operator + " " + value;
	}

}
