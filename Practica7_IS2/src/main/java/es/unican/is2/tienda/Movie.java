// From book: 'Refactoring' by Martin Fowler
// This is the original code before refactoring begins
package es.unican.is2.tienda;
public class Movie {

	public static final int CHILDRENS = 2;
	public static final int NEW_RELEASE = 1;
	public static final int REGULAR = 0;
	
	private String _title;
	private int _priceCode;
	
	public Movie(String title, int priceCode) { //WMC +1
		_title = title;
		_priceCode = priceCode;
	}
	
	public int getPriceCode() { //WMC +1
		return _priceCode;
	}

	public void setPriceCode(int arg) { //WMC +1
		_priceCode = arg;
	}
	public String getTitle() { //WMC +1
		return _title;
	}
	
	
}
