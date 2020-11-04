
public class IllegalPizza extends Exception {
	
	/**
	 * This class is created for handling the exceptions.
	 * It stores the IllegalPizza exception for when an input is not valid 
	 * during the selection of the desired pizza entries.
	 */

	private static final long serialVersionUID = 4593713417540203652L;

	/**
	 * The exception class' constructor.
	 * @param message A message describing the error.
	 */
	public IllegalPizza (String message) {
		super(message);
	} // end constructor
	
} // end IllegalPizza class