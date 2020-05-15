package corona.nexttargetarea.customexception;

public class DatabaseException extends RuntimeException{
	private int code;
	private String details;
    private String message;
    
    public DatabaseException(String message)
    {
    this.message=message;
    }
    
    public DatabaseException(String message,String details)
    {
    this.message=message;
    this.details=details;
    }
    
    public DatabaseException(int code,String message,String details)
    {
    this.code=code;
    this.message=message;
    this.details=details;
    }
    
}
