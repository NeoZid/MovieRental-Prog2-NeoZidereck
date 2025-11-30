
public class ExternalMember extends Person implements Payment{
	String job;
	String organization;
	public ExternalMember(int personId, String name, int age, String gender, String job, String organization) {
		super(personId,name,age,gender);
		this.job=job;
		this.organization=organization;
	}
	
	public ExternalMember() {
		
	}
	@Override
	public void calculate(int days) {
	    int baseFee = 5;          // cost for the first 7 days
	    int allowedDays = 7;
	    int lateFeePerDay = 2;    // $2 per day after allowed days

	    if (days <= allowedDays) {
	        System.out.println("Rent fee due: $" + baseFee + "$");
	    } else {
	        int extraDays = days - allowedDays;
	        int total = baseFee + (extraDays * lateFeePerDay);
	        System.out.println("Rent fee due: $" + total + "$");
	    }
	}
	
	public boolean validateIdRegistration(int personId) {
		if(personId==this.personId) {
			System.out.println("Id already taken, re-enter a new id");
			return false;
		} 
		return true;
	}
	
	public void status() {
		System.out.println("This person" + this.name + "is an external member");
	}
}
