package corona.nexttargetarea.customexception;

public class ValidationException extends RuntimeException{
	private int code;
	private String details;
    private String message;
    
    public ValidationException(String message)
    {
    this.message=message;
    }
    
    public ValidationException(String message,String details)
    {
    this.message=message;
    this.details=details;
    }
    
    public ValidationException(int code,String message,String details)
    {
    this.code=code;
    this.message=message;
    this.details=details;
    } 
}
