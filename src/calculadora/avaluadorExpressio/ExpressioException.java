package calculadora.avaluadorExpressio;

public class ExpressioException extends Exception {

	private static final long serialVersionUID = -4858709346501320006L;

	public ExpressioException(String message) {
		super(message);
	}
	
	public ExpressioException(String message, Throwable t) {
		super(message, t);
	}
}
