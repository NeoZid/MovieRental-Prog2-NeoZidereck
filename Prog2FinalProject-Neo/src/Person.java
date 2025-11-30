import java.util.ArrayList;

public class Person implements Payment{
	private Student student;
	private ExternalMember extmemb;
	
	int personId;
	String name;
	int age; 
	String gender;
	public Person(int personId, String name, int age, String gender) {
		this.personId=personId;
		this.name=name;
		this.age=age;
		this.gender=gender;
	}
	
	public Person() {};
	
	public void calculate(int days) {
		System.out.println(days);
	}
	
	public boolean validateIdRegistration(int personId) {
		if(personId==this.personId) {
			System.out.println("Id already taken, re-enter a new id");
			return false;
		} 
		return true;
	}
	

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public ExternalMember getExtmemb() {
		return extmemb;
	}

	public void setExtmemb(ExternalMember extmemb) {
		this.extmemb = extmemb;
	}

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
}
