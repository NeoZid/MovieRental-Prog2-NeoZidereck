
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainDriver {
	public static void main(String[] args) 
	{
		PersonHandler pH = new PersonHandler();
		Person p = new Person(); // for methods
		Company c = new Company(); // for methods
		RentalService rts = new RentalService(c);
		Movie m = new Movie();
		Scanner in = new Scanner(System.in);
		ArrayList<Company> companies = new ArrayList<>();
		
		try {
			ArrayList<Student> savedListStudents = pH.loadStudent("studentsList.json");
			pH.setStudentList(savedListStudents);
		} catch (Exception e) {
			System.out.println("Student Member List is non existent, starting with empty lists!");
		}
		
		try {
			ArrayList<ExternalMember> savedListExtMemb = pH.loadExtMember("externalMemList.json");
			pH.setExtMemberList(savedListExtMemb);
		} catch (Exception e) {
			System.out.println("External Member list is non existent, starting with empty list");
		}
		
		try {
			ArrayList<Movie> savedMoviesList = c.loadMovies("moviesList.json");
			c.setMoviesList(savedMoviesList);
		} catch (Exception e) {
			System.out.println("Movies list is non existent, starting with empty list");
		}
		
		
		
		boolean isRunning = true;
		while (isRunning) 
		{
			System.out.println("Welcome to movie rental company: Matrix!");
			System.out.println("What would you like to do?");
			try 
			{
				System.out.println("1- Register Member, 2- Rent movies, 3- Add a movie, 4- Return a movie 5- Show movies available, 6- Show Students List, 7- Show External Member List");
				int choice = in.nextInt();
				in.nextLine();
				switch (choice) 
				{
				case 1:
					System.out.println("Are you a student(1) or an external member? (2) ");
					int ch1 = in.nextInt();
					in.nextLine();
					switch (ch1) {
					case 1: 
						System.out.println("Enter ID");
						int id = in.nextInt();
						in.nextLine();
						if (p.validateIdRegistration(id)!=true) {
							break;
						}
						System.out.println("Enter Name");
						String name = in.nextLine();
						System.out.println("Enter age");
						int age = in.nextInt();
						in.nextLine();
						System.out.println("Enter gender");
						String gender = in.nextLine();
						System.out.println("Enter school name");
						String school = in.nextLine();
						System.out.println("Enter grade");
						String grade = in.nextLine();
						Student st = new Student(id, name, age, gender,school, grade);
						pH.registerStu(st);
						try {
							pH.saveStudent("studentsList.json", pH.getStudentList());
						} catch (IOException e) {
							e.printStackTrace();
						}
						break;
					case 2:
						System.out.println("Enter ID");
						int id1 = in.nextInt();
						in.nextLine();
						System.out.println("Enter Name");
						String name1 = in.nextLine();
						System.out.println("Enter age");
						int age1 = in.nextInt();
						in.nextLine();
						System.out.println("Enter gender");
						String gender1 = in.nextLine();
						System.out.println("Enter job");
						String job = in.nextLine();
						System.out.println("Enter organization");
						String org = in.nextLine();
						ExternalMember extMem = new ExternalMember(id1, name1, age1, gender1, job, org);
						pH.registerExtM(extMem);
						try {
							pH.saveExtMember("externalMemList.json", pH.getExtMemberList());
						} catch (IOException e) {
							e.printStackTrace();
						}
						
						break;
					}
					break;
				case 2:
					System.out.println("Rent a movie!");
					System.out.println("Are you a student (1) or an external member(2)");
					try {
						int rentChoice = in.nextInt();
						switch (rentChoice) {
						case 1: 
							System.out.println("Enter student ID");
							int rentStuId = in.nextInt();
							in.nextLine();
								if (pH.findStudent(rentStuId)!=null) {
									System.out.println("Enter Movie Title");
									String rentalMovieTitle = in.nextLine();
									System.out.println("Enter Movie Id");
									int rentalMovieId = in.nextInt();
									in.nextLine();
									rts.rentMovie(p, rentalMovieTitle, rentalMovieId);
									break;
								} else {
									System.out.println("Student not found, try again");
								}
								break;
						case 2:
							System.out.println("Enter external member ID");
							int rentExtId = in.nextInt();
							in.nextLine();
								if (pH.findExtMember(rentExtId)!=null) {
									System.out.println("Enter movie title");
									String rentalMovieTitle1 = in.nextLine();
									System.out.println("Enter movie id");
									int rentalMovieId1 = in.nextInt();
									in.nextLine();
									rts.rentMovie(p, rentalMovieTitle1, rentalMovieId1);
									break;
								} else {
									System.out.println("External member not found");
								}
								break;
						}
					} catch (InputMismatchException e) {
						System.out.println("Inputs are only 1 or 2");
						in.nextLine();
					}
					break;
				case 3:
					System.out.println("Enter Movie ID");
					int movieID = in.nextInt();
					in.nextLine();
					System.out.println("Enter movie title");
					String title = in.nextLine();
					System.out.println("Enter movie genre");
					String genre = in.nextLine();
					System.out.println("Enter duration of the movie");
					String duration = in.nextLine();
					System.out.println("Enter rating of movie from 1 to 10");
					String rating = in.nextLine();
					Movie movie = new Movie(movieID, title, genre, duration, rating);
					c.addMovie(movie);
					
					try {
						c.saveMovie("moviesList.json", c.getMovies());
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				case 4:
				    System.out.println("Return your movie!");
				    System.out.println("Are you a student (1) or an external member(2)");
				    try {
				        int returnChoice = in.nextInt();
				        boolean handled = false;   
				        switch (returnChoice) {
				        
				        case 1: 
				            System.out.println("Enter student ID");
				            int returnStuId = in.nextInt();
				            in.nextLine();

				            if (pH.findStudent(returnStuId) != null) {
				                Student student = pH.findStudent(returnStuId);

				                System.out.println("Enter Movie Title");
				                String returnMovieTitle = in.nextLine();
				                System.out.println("Enter Movie Id");
				                int returnMovieId = in.nextInt();
				                in.nextLine();


				                if (!c.checkReturnMovie(returnMovieId)) {
				                    break;  
				                }

				                System.out.println("How many days did you rent it?");
				                int daysRented = in.nextInt();
				                in.nextLine();

				                boolean success = rts.returnMovie(p, returnMovieTitle, returnMovieId);
				                if (success) student.calculate(daysRented);

				                handled = true;
				            } else {
				                System.out.println("Student not found, try again");
				            }
				            break; 

				        case 2:
				            System.out.println("Enter external member ID");
				            int returnExtId = in.nextInt();
				            in.nextLine();

				            if (pH.findExtMember(returnExtId) != null) {
				                ExternalMember external = pH.findExtMember(returnExtId);

				                System.out.println("Enter movie title");
				                String returnMovieTitle1 = in.nextLine();
				                System.out.println("Enter movie id");
				                int returnMovieId1 = in.nextInt();
				                in.nextLine();

				                if (!c.checkReturnMovie(returnMovieId1)) {
				                    break; 
				                }

				                System.out.println("How many days did you rent it?");
				                int daysRented1 = in.nextInt();
				                in.nextLine();

				                boolean success = rts.returnMovie(p, returnMovieTitle1, returnMovieId1);
				                if (success) external.calculate(daysRented1);

				                handled = true;
				            } else {
				                System.out.println("External member not found");
				            }
				            break; 
				        
				        }

		
				        break;  

				    } catch (InputMismatchException e) {
				        System.out.println("Inputs are invalid");
				        in.nextLine();
				    }
				    break; 
				case 5:
					c.showMovieList();
					break;
				case 6:
					pH.showStudentList();
					break;
				case 7:
					pH.showExternalMember();
					break;
				case 8:
					System.out.println("Now exiting, thank you for using");
					isRunning = false;
				}
			}catch (InputMismatchException e) {
					System.out.println("Invalid input, must be (1, 2 , 3)");
			}
		}
      //  
	}
	
	
	

}
