
public class Movie {
	int movieID;
	String title;
	String genre;
	String duration;
	String rating;
	boolean availability;
	Person rentedBy;
	public Movie(int movieID, String title, String genre, String duration, String rating) {
		this.movieID=movieID;
		this.title=title;
		this.genre=genre;
		this.duration=duration;
		this.rating=rating;
		this.availability=true;
		this.rentedBy=null;
	}
	
	public Movie() {};
	

	
	// method rents to a person, as well as turning availability to false
	public void rentTo(Person person) {
		this.availability=false;
		this.rentedBy=person;
	}
	
	// method for returning
	public void returnMovie(Person person) {
		
		this.availability=true;
		this.rentedBy=null;
	}
	
	public void setAvailability(boolean availability) {
		this.availability=availability;
	}
	
	public int getMovieID() {
		return movieID;
	}
	public void setMovieID(int movieID) {
		this.movieID = movieID;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	
	
	public Person getRentedBy() {
		return rentedBy;
	}

	public void setRentedBy(Person rentedBy) {
		this.rentedBy = rentedBy;
	}

	public boolean getAvailability() {
		return availability;
	}

	@Override
	public String toString() {
		return "Movie [movieID=" + movieID + ", title=" + title + ", genre=" + genre + ", duration=" + duration
				+ ", rating=" + rating + ", availability=" + availability + "]";
	}
	
	
	
}
