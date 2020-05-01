package es.unican.is2.tiendaRefactorizada;
import java.util.Iterator;

import java.util.LinkedList;
import java.util.List;


//From book: 'Refactoring' by Martin Fowler
//This is the original code before refactoring begins

public class Customer {

	private String _name;
	private List<Rental> _rentals = new LinkedList<Rental>();
	
	public Customer(String name) {  //WMC +1
		_name = name;
	}
	
	public void addRental(Rental arg) {   //WMC +1
		_rentals.add(arg);
	}
	
	public String getName() {  //WMC +1
		return _name;
	}
	
	public String statement() { //WMC +1
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		Iterator<Rental> rentals = _rentals.iterator();
		String result = "Rental Record for " + getName() + "\n";
		
		while (rentals.hasNext()) {  //WMC +1    //CCog +1
			double thisAmount = 0;
			Rental each = (Rental) rentals.next();		
			//determine amounts for each line
			switch (each.getMovie().getPriceCode()) {    //WMC +3	//CCog +2
			case Movie.REGULAR:
				thisAmount += 2;
				if (each.getDaysRented() > 2)			//WMC +1	//CCog +3
					thisAmount += (each.getDaysRented() - 2) * 1.5;
				break;
			case Movie.NEW_RELEASE:
				thisAmount += each.getDaysRented() * 3;
				break;
			case Movie.CHILDRENS:
				thisAmount += 1.5;
				if (each.getDaysRented() > 3) 				//WMC +1   //CCog +3
					thisAmount += (each.getDaysRented() - 3) * 1.5;
				break;
			}		
			// add frequent renter points
			frequentRenterPoints++;
			// add bonus for a two day new release rental
			if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDaysRented() > 1) //WMC +2   //CCog +3
				frequentRenterPoints++;		
			// show figures for this rental
			result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(thisAmount) + "\n";
			totalAmount += thisAmount;
		}	
		// add footer lines
		result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
		result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";	
		return result;
	}
}
