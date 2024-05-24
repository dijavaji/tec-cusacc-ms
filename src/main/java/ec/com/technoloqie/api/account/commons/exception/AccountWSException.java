package ec.com.technoloqie.api.account.commons.exception;

public class AccountWSException extends RuntimeException{
	
	public AccountWSException() {
        super();
    }
    
	public AccountWSException (String msg, Throwable nested) {
        super(msg, nested);
    }
    
	public AccountWSException (String message) {
        super(message);
    }
    
	public AccountWSException(Throwable nested) {
        super(nested);
	}
	
	private static final long serialVersionUID = 1L;

}