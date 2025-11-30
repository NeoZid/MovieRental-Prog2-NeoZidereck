import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

public class Company {
	private ArrayList<Movie> movies = new ArrayList<>();
	private Movie movie = new Movie();
	String companyName;
	int companyID;
	public Company(String cn, int cID) {
		companyName=cn;
		companyID=cID;
	}
	
	public Company() {};
	
	public boolean checkReturnMovie(int movieId) {
	    for (int i = 0; i < movies.size(); i++) {
	        Movie m = movies.get(i);

	        if (m.movieID == movieId) {   
	            if (m.availability == false) { 
	                return true;
	            } else {
	                System.out.println("Movie is not being rented or has already been returned");
	                return false;
	            }
	        }
	    }

	    System.out.println("Movie not found");
	    return false;
	}
	
	public void showMovieList() {
		if (movies.isEmpty()) {
			System.out.println("There are no movies listed");
			return;
		}
		
		for (int i = 0; i < movies.size(); i++) {
			if (movies.get(i).getAvailability()==false) {
				System.out.println("No movies availaible currently");
				return;
			}
		}
		
		System.out.println("Movies list");
		for (Movie m : movies) {
			System.out.print("\n----------" + "\nMovieID: " + m.movieID + "\nTitle: " + m.title + "\nGenre: " + m.genre + "\nDuration: " + m.duration + "\nRating: " + m.rating + "\nAvailability: " + m.availability + "\n" + "----------\n");
		}
	}
	
	public void addMovie(Movie movie) {
		
		if (movies.size()>=1) {
			System.out.println("Already added a movie");
			return;
		} else {
			movies.add(movie);
			System.out.println("Movie added succesfully");
		}
	}
	
	public void showMovies() {
		for (int i = 0; i < movies.size(); i++) {
			System.out.println(movies.get(i).toString());
		}
	}
	
	public Movie findMovie(String movieTitle, int movieID) {
		for (Movie m: movies) {
			if (m.getTitle().equalsIgnoreCase(movieTitle) && (m.getMovieID()==movieID)) {
				return m;
			}
		}
		return null;
	}
	
	public int getCompanyId() {
		return this.companyID;
	}
	
	public ArrayList<Movie> getMovies(){
		return movies;
	}
	
	public void saveMovie(String path, ArrayList<Movie> movies) throws IOException {
		Gson gson = new Gson();
		String json = gson.toJson(movies);
		Files.writeString(Path.of(path), json);
	}
	
	public ArrayList<Movie> loadMovies (String path) throws IOException {
		Gson gson = new Gson();
		Type type = new TypeToken<ArrayList<Movie>>() {}.getType();
		String json = Files.readString(Path.of(path));
		return gson.fromJson(json, type);
		
	}
	
	public void setMoviesList(ArrayList<Movie> movies) {
		this.movies=movies;
	}
	
}
