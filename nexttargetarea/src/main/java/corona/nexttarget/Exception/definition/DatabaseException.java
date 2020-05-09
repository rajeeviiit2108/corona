package corona.nexttarget.Exception.definition;

public class DatabaseException extends RuntimeException{
	String details;
    int code;
    public DatabaseException(String msg)
    {
    super(msg);
    }
    
    public DatabaseException(String msg,String details)
    {
    super(msg);
    this.details=details;
    }
    
     public DatabaseException(int code,String msg,String details)
    {
    super(msg);
    this.code=code;
    this.details=details;
    }  
    
}
