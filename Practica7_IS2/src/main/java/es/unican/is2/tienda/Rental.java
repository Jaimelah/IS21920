//From book: 'Refactoring' by Martin Fowler
//This is the original code before refactoring begins
package es.unican.is2.tienda;
/**
 * The rental class represents a customer renting a movie.
 */
public class Rental {

	private Movie _movie;
	private int _daysRented;
	
	public Rental(Movie movie, int daysRented) { //WMC +1
		_movie = movie;
		_daysRented = daysRented;
	}

	public int getDaysRented() { //WMC +1
		return _daysRented;
	}

	public Movie getMovie() { //WMC +1
		return _movie;
	}
	
}
