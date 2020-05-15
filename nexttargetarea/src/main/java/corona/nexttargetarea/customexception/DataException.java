package corona.nexttargetarea.customexception;

public class DataException extends RuntimeException{
	private int code;
	private String details;
    private String message;
    
    public DataException(String message)
    {
    this.message=message;
    }
    
    public DataException(String message,String details)
    {
    this.message=message;
    this.details=details;
    }
    
    public DataException(int code,String message,String details)
    {
    this.code=code;
    this.message=message;
    this.details=details;
    }
}
