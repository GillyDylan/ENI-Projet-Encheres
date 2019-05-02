package fr.eni.ecole.encheres.bll;

public class BLLException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8977775951105351704L;
	private int numException;
	

	
	public BLLException() {
		super();
	}
	
	public BLLException(String message) {
		super(message);
	}
	


	public BLLException(int numException, String message) {
		super(message);
		this.numException = numException;
	}
	
	public BLLException(String message, Throwable exception) {
		super(message, exception);
	}

	@Override
	public String getMessage() {
		
		return super.getMessage();
	}
	
	public int getNumException() {
		return numException;
	}
	
	
}
