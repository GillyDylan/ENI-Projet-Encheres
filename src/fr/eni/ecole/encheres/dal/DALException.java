package fr.eni.ecole.encheres.dal;

public class DALException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5291299818273966562L;

	//Constructeurs
	public DALException() {
		super();
	}
	
	public DALException(String message) {
		super(message);
	}
	
	public DALException(String message, Throwable exception) {
		super(message, exception);
	}

	//M�thodes
	@Override
	public String getMessage() {
		StringBuffer sb = new StringBuffer("Couche DAL - ");
		sb.append(super.getMessage());
		
		return sb.toString() ;
	}
	
	
}
