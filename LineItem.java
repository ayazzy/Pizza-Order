

import java.io.Serializable;
/**
 * It represents a single line item
 * in a pizza order. The line item contains a link to the Pizza object as well as the number
 * of these pizzas to be ordered.
 * Student: Ayaz Vural
 * Student ID:20105817
 */
public class LineItem implements Comparable<LineItem>, Serializable {

	private static final long serialVersionUID = -1791484805268644829L;
	private int numberPizzas;
	private Pizza pizza;
	

	public LineItem(int number, Pizza pizza) throws IllegalPizza {
		setNumber(number);
		if (pizza == null)
			throw new IllegalPizza("Pizza not supplied!");
		this.pizza = pizza;
//		this.pizza = pizza.clone();	// If Pizza becomes mutable
	} // end full parameter constructor
	

	public LineItem(Pizza pizza) throws IllegalPizza {
		this(1, pizza);
	} // overloaded constructor
	

	public void setNumber(int number) throws IllegalPizza {
		if (number < 1 || number > 100)
			throw new IllegalPizza("Illegal number of pizzas!");
		numberPizzas = number;		
	} // end setNumber

	public Pizza getPizza() {
		return pizza;	// add .clone() if Pizza becomes mutable
	} // end getPizza
	

	public int getNumber() {
		return numberPizzas;
	} // end getNumber
	

	public float getCost() {
		float discount = 1.0F;
		if (numberPizzas >= 10 && numberPizzas <= 20)
			discount = 0.95F;
		else if (numberPizzas > 20)
			discount = 0.9F;
		return numberPizzas * discount * pizza.getCost();
	} // end getCost
	

	public String toString() {
		if (numberPizzas < 10)
			return " " + numberPizzas + " " + pizza;
		else
			return numberPizzas + " " + pizza;
	} // end toString
	

	public int compareTo(LineItem item) {
		return (int)(item.getCost() - getCost());
	} // end compareTo
	
} // end LineItem class