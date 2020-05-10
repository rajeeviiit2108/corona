package corona.nexttarget.coronaexception;

public class ValidationException extends RuntimeException {

    String details;
    int code;
    public ValidationException(String msg)
    {
    super(msg);
    }
    
    public ValidationException(String msg,String details)
    {
    super(msg);
    this.details=details;
    }
    
     public ValidationException(int code,String msg,String details)
    {
    super(msg);
    this.code=code;
    this.details=details;
    }  
}
