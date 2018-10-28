package Data;

public class Fact {
	private String type;
	private String data;
	
	public Fact(String type, String data) {
		super();
		this.type = type;
		this.data = data;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}

	@Override
	public boolean equals(Object arg0) {
		// TODO Auto-generated method stub
		if(((Fact)arg0).getType().equals(this.type) && ((Fact)arg0).getData().equals(this.data)) {
			return (true);
		}else {
			return(false);
		}
		
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.type+"="+this.data;
	}
	
	
}
