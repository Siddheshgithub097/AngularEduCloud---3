package in.codetech.angulareducloud.portal.exception;

public class UsernotFoundException extends RuntimeException
{

	private String message;

	public UsernotFoundException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	
	

	
	
	
	
}
