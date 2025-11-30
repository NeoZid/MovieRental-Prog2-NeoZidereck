import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

public class PersonHandler {
	ArrayList<Student> studentList = new ArrayList<>();
	ArrayList<ExternalMember> extMemberList = new ArrayList<>();
	
	public void registerStu(Student student) {
		studentList.add(student);
		System.out.println("Register succesful!");
	}
	public void registerExtM(ExternalMember extmemb) {
		extMemberList.add(extmemb);
	}
	public Student findStudent(int studentId) {
		for (Student s : studentList) {
			if (s.personId==studentId) {
				return s;
			}
		}
		return null;
	}
	public ExternalMember findExtMember(int extMemberId) {
		for (ExternalMember ext : extMemberList) {
			if(ext.personId==extMemberId) {
				return ext;
			}
		}
		return null;
	}
	public ArrayList<Student> getStudentList(){
		return studentList;
	}
	
	public void showStudentList() {
		if (studentList.size()==0) {
			System.out.println("No students listed");
			return;
		}
		
		System.out.println("List of Students");
		for (Student s : studentList) {
			System.out.print("Name: " + s.name + "\nAge: " + s.age + "\nID: " + s.personId + "\nGender: " + s.gender + "\nSchool:" + s.schoolName + "\nGrade: " + s.grade + "\n");
		}
	}
	
	public void showExternalMember() {
		if (extMemberList.isEmpty()) {
			System.out.println("No external members listed");
			return;
		} 
		
		System.out.println("List of External Members");
		for (ExternalMember e : extMemberList) {
			System.out.print("\n----------"+"\nName: " + e.name + "\nAge: " + e.age + "\nID: " + e.personId + "\nGender: " + e.gender + "\nJob:" + e.job + "\nOrganization: " + e.organization + "\n----------\n");
		}
	}
	
	public ArrayList<ExternalMember> getExtMemberList() {
		return extMemberList;
	}
	
	public void setStudentList(ArrayList<Student> studentList) {
		this.studentList=studentList;
	}
	
	public void setExtMemberList(ArrayList<ExternalMember> extMemberList) {
		this.extMemberList=extMemberList;
	}
	
	public ArrayList<Student> loadStudent(String path) throws IOException {
		Gson gson = new Gson();
		Type type = new TypeToken<ArrayList<Student>>() {}.getType();
		String json = Files.readString(Path.of(path));
		return gson.fromJson(json, type);
	}
	
	public void saveStudent(String path, ArrayList<Student> studentsList) throws IOException {
		Gson gson = new Gson();
		String json = gson.toJson(studentsList);
		Files.writeString(Path.of(path), json);
	}
	
	public ArrayList<ExternalMember> loadExtMember(String path) throws IOException {
		Gson gson = new Gson();
		Type type = new TypeToken<ArrayList<ExternalMember>>() {}.getType();
		String json = Files.readString(Path.of(path));
		return gson.fromJson(json, type);
	}
	
	public void saveExtMember(String path, ArrayList<ExternalMember> extMemberList) throws IOException {
		Gson gson = new Gson();
		String json = gson.toJson(extMemberList);
		Files.writeString(Path.of(path), json);
	}
	
}
