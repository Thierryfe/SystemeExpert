package Data;

public class Fact {
	private String type;
	private String sign;
	private String data;
	
	public Fact(String type, String sign,String data) {
		super();
		this.type = type;
		this.sign = sign;
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
	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	@Override
	public boolean equals(Object arg0) {
		// TODO Auto-generated method stub
		if(((Fact)arg0).getType().equals(this.type) && ((Fact)arg0).getData().equals(this.data) && ((Fact)arg0).getSign().equals(this.sign)) {
			return (true);
		}else {
			return(false);
		}
		
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.type+this.sign+this.data;
	}
	
	
}
