
public class RentalService{
	private Company company;
	private Movie m = new Movie();
	private Person person;
	String rentalDates;
	public RentalService(Company company) {
		this.company=company;
	}
	
	public boolean rentMovie(Person person, String movieName, int movieId) {
		Movie movie = company.findMovie(movieName, movieId);
		if (movie == null) {
			System.out.println("Movie not found");
			return false;
		}
		
		if (movie.availability==false) {
			System.out.println("Movie is already being rented");
			return false;
		}
		
		movie.rentTo(person);
		System.out.println("Movie rented succesfully!");
		return true;
 	}
	
	public boolean returnMovie(Person person, String movieName, int movieId) {
		Movie movie = company.findMovie(movieName, movieId);
		if (movie == null) {
			System.out.println("Movie not found");
			return false;
		}
		
		if (movie.availability==true) {
			System.out.println("Movie already returned or was never rented");
			return false;
		} 
		
		movie.returnMovie(person);
		System.out.println("Returned succesfully");
		return true;
		
	}
	
	
}
