
public class Person2 {
	private String name;
	private String phn;
	private String age;
	String fare;
	String strain;
	String destination;
	String stpoint;
	String sclass;
	
	
	public Person2(String name, String phn,String age,String fare,String strain,String destination,
			String stpoint, String sclass){
		
		this.name= name;
		this.phn=phn;
		this.age=age;
		this.fare=fare;
		this.strain=strain;
		this.destination=destination;
		this.stpoint=stpoint;
		this.sclass=sclass;
	}

	public String getName(){
		return name;
	}
	public String getPhn(){
		return phn;
	}
	public String getAge(){
		return age;
	}
	public String getFare(){
		return fare;
	}
	public String getStrain(){
		return strain;
	}
	public String getDestination(){
		return destination;
	}
	public String getStpoint(){
		return stpoint;
	}
	public String getSclass(){
		return sclass;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", phn=" + phn + ", age=" + age
				+ ", strain=" + strain + ", destination=" + destination
				+ ", stpoint=" + stpoint + ", sclass=" + sclass + "]";
	}


	
	
	
	
	
	

}
