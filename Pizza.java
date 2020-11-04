
import java.io.Serializable;
/**
 * The class is made to represent a pizza order,we are able to determine
 * the size, the amount of cheese, pineapple, green pepper and ham and also we get a chance to
 * decide if it is vegetarian or not. It can also produce the cost 
 * of that pizza using hard-coded prices.
 * 
 * Student: Ayaz Vural
 * Student ID: 20105817
 */
public class Pizza implements Serializable {

	private static final long serialVersionUID = 1856146538106631512L;
	private String size;
	private String cheese;
	private String pineapple;
	private String greenPepper;
	private String ham;
	private boolean vegetarian;
	
	private final float SMALL_COST = 7.00F;	// Includes one cheese
	private final float MEDIUM_COST = 9.00F;
	private final float LARGE_COST = 11.00F;
	private final float COST_PER_TOPPING = 1.50F;
	
	private void setSize(String size) throws IllegalPizza {
		// to set the size of our pizza.
		if ((size == null) || (size.equals("")))
			throw new IllegalPizza("Size not provided!");
		if (size.equals("Small") || size.equals("Medium") || size.equals("Large"))
			this.size = size.toLowerCase();
		else 
			throw new IllegalPizza("Illegal pizza " + size);
	} // end setSize
	
	private void setVegetarian(boolean vegetarian)throws IllegalPizza{
		// setting if the pizza is vegetarian or not.
		if ((vegetarian != true) && (vegetarian != false))
			throw new IllegalPizza("Vegetarian option not provided!");
		if (vegetarian == true)
			this.vegetarian = true;	
		else 
			this.vegetarian = false;
		}// end setVegetarian
			
	private void setCheese(String cheese) throws IllegalPizza {
		if ((cheese == null) || (cheese.equals("")))
			throw new IllegalPizza("Cheese not provided!");
		if (cheese.equals("Single") || cheese.equals("Double") || cheese.equals("Triple"))
			this.cheese = cheese.toLowerCase();
		else
			throw new IllegalPizza("Illegal pizza " + cheese);		
	} // end setCheese
	
	
	private void setPineapple(String pineapple) throws IllegalPizza {
		if ((pineapple == null) || (pineapple.equals("")))
			throw new IllegalPizza("Pineapple not provided!");
		if (pineapple.equals("None") || pineapple.equals("Single"))
			this.pineapple = pineapple.toLowerCase();
		else
			throw new IllegalPizza("Illegal pizza " + pineapple);		
	} // end setPineapple
	
	
	private void setGreenPepper(String greenPepper) throws IllegalPizza {
		if ((greenPepper == null) || (greenPepper.equals("")))
			throw new IllegalPizza("Green pepper not provided!");
		if (greenPepper.equals("None") || greenPepper.equals("Single"))
			this.greenPepper = greenPepper.toLowerCase();
		else
			throw new IllegalPizza("Illegal pizza " + greenPepper);		
	} // end setGreenPepper
	
	 
	private void setHam(String ham) throws IllegalPizza {
		if ((ham == null) || (ham.equals("")))
			throw new IllegalPizza("Ham not provided!");
		if (ham.equals("None") || ham.equals("Single"))
			this.ham = ham.toLowerCase();
		else
			throw new IllegalPizza("Illegal pizza " + ham);		
	} // end setHam
	
	/**
	 * The Pizza constructor.
	 * size Must be "Small", "Medium" or "Large".
	 * vegetarian must be "yes" or " no"
	 * cheese Must be "Single", "Double" or "Triple".
	 * pineapple Must be "None" or "Single".
	 * greenPepper Must be "None" or "Single".
	 * ham Must be "None" or "Single".
	 * IllegalPizza If any of the parameters are not legal or if ham is "None" and
	 * pineapple or greenPepper is not "None".
	 */
	public Pizza(String sizeIn, Boolean vegetarianIn, String cheeseIn, String pineappleIn, String greenPepperIn, String hamIn) throws IllegalPizza {
		setSize(sizeIn);
		setVegetarian(vegetarianIn);
		setCheese(cheeseIn);
		setPineapple(pineappleIn);
		setGreenPepper(greenPepperIn);
		setHam(hamIn);
		if (this.ham.equals("None") && (!this.pineapple.equals("None") || !this.greenPepper.equals("None")))
			throw new IllegalPizza("You must have ham with your pineapple or green pepper!");
	} // end full parameter constructor
	
	/**
	 * The default Pizza constructor.
	 * IllegalPizza Should not be thrown.
	 */
	public Pizza() throws IllegalPizza {
		this("Small", null, "Single", "None", "None", "Single");
	} // end default constructor
	
	public Pizza(String size, String cheese, String pineapple, String greenPepper, String ham) throws IllegalPizza{
		setSize(size);
	
		setCheese(cheese);
		setPineapple(pineapple);
		setGreenPepper(greenPepper);
		setHam(ham);
	}
	
	private float getSizeCost(String size) {
		switch (size) {
		case "small":
			return SMALL_COST;
		case "medium":
			return MEDIUM_COST;
		}
		return LARGE_COST;
	} // end getSizeCost
	
	private int cheeseCost(String cheese) {
		if (cheese.equals("double"))
			return 2;
		else if (cheese.equals("triple"))
			return 3;
		else
			return 0;
	}
	
	private int translateTopping(String topping) {
		if (topping.equals("none"))
			return 0;
		else
			return 1;
	} // end translateTopping
	
	/**
	 * Returns the cost of the current Pizza object.
	 * returns the cost in dollars.  No tax.
	 */
	public float getCost() {
		float cost = getSizeCost(size);
		cost += (cheeseCost(cheese));
		cost += (translateTopping(pineapple) + translateTopping(greenPepper) + 
				translateTopping(ham)) * COST_PER_TOPPING;
		return cost;
	} // end getCost
	
	/**
	 * Returns a string representation of the current object.
	 * returns a string description of the current Pizza object.
	 */
	public String toString() {
		String out = size + " pizza, " + cheese + " cheese";
		if (pineapple.equals("single"))
			out += ", pineapple";
		if (greenPepper.equals("single"))
			out += ", green pepper";
		if (ham.equals("single"))
			out += ", ham";
		out += String.format(". Cost: $%.2f each.", getCost());
		return out;
	} // end toString
	
	/**
	 * Tests to see if the current object is equal to the supplied Pizza object. Equality is
	 * defined as all attributes being exactly equal.
	 * @param other The supplied object for comparison.
	 * @return false if the objects are not equal or the supplied object is not a Pizza, true
	 * otherwise.
	 */
	public boolean equals(Object other) {
		if (other instanceof Pizza) {
			Pizza otherP = (Pizza)other;
			return size.equals(otherP.size) && cheese.equals(otherP.cheese) && 
				   pineapple.equals(otherP.pineapple) && greenPepper.equals(otherP.greenPepper) && 
				   ham.equals(otherP.ham);
		}
		return false;
	} // end equals
	
	/**
	 * Creates and returns a clone of the current Pizza object.
	 * @return A deep copy or clone of the current object. 
	 */
	public Pizza clone() {
		Pizza outP = null;
		try {
			outP = new Pizza(size,vegetarian, cheese, pineapple, greenPepper, ham);
		} catch (IllegalPizza e) {
		}
		return outP;
	} // end clone
	
} // end Pizza class

