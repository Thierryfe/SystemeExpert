package Data;

/**
 *  
 *
 *         Enumeration de tous les type d'opérateurs d'un fait (ce qui inclut
 *         les conclusions et les premisses)
 */
public enum Operator {
	SUPERIOR,

	SUPERIOR_OR_EQUAL,

	INFERIOR,

	INFERIOR_OR_EQUAL,

	EQUAL,

	DIFFERENT;
	

	  @Override
	  public String toString() {
	    switch(this) {
	      case SUPERIOR: return ">";
	      case SUPERIOR_OR_EQUAL: return ">=";
	      case INFERIOR: return "<";
	      case INFERIOR_OR_EQUAL: return "<=";
	      case EQUAL: return "=";
	      case DIFFERENT: return "!=";
	      default: throw new IllegalArgumentException();
	    }
	  }

}
