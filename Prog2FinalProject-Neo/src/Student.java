
public class Student extends Person implements Payment{
	String schoolName;
	String grade;
	public Student(int personId, String name, int age, String gender, String schoolName, String grade) {
		super(personId, name, age, gender);
		this.schoolName=schoolName;	this.grade=grade;
	}
	public Student() {
	}
	
	@Override
	public void calculate(int days) {
	    int baseFee = 5;
	    int allowedDays = 7;

	    if (days <= allowedDays) {
	        System.out.println("Rent fee due: " + baseFee + "$");
	    } else {
	        int extraDays = days - allowedDays;
	        int total = baseFee + extraDays;
	        System.out.println("Rent fee due: " + total + "$");
	    }
	}
	
	public void status() {
		System.out.println("This person" + this.name + "is a student");
	}
	
	
}
