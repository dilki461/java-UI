public class Contact{
	private String id;
	private String name;
	private String phoneNumber;
	private String companyName;
	private double salary;
	private String birthday;
	
	
	Contact(String id,String name,String phoneNumber,String companyName,double salary,String birthday){
		this.id=id;
		this.name=name;
		this.phoneNumber=phoneNumber;
		this.companyName=companyName;
		this.salary=salary;
		this.birthday=birthday;
		
	}
	public void setId(String id){
		this.id=id;
	}
	public void setName(String name){
		this.name=name;
	}
	public void setPhoneNumber(String phoneNumber){
		this.phoneNumber=phoneNumber;
	}
	public void setCompanyName(String companyName){
		this.companyName=companyName;
	}
	public void setSalary(double salary ){
		this.salary=salary;
	}
	public void setBirthday(String birthday){
		this.birthday=birthday;
	}
	
	public String getId(){
		return id;
	}
	public String getName(){
		return name;
	}
	public String getPhoneNumber(){
		return phoneNumber;
	}
	public String getCompanyName(){
		return companyName;
	}
	public double getSalary(){
		return salary;
	}
	public String getBirthday(){
		return birthday;
	}

	public String toString() {
        return id+"-"+name+"-"+phoneNumber+"-"+companyName+"-"+salary+"-"+birthday; 
	}
	public boolean equals(Contact contact){
		return this.id.equalsIgnoreCase(contact.id);
	}

}
