package corona.nexttarget.Exception.definition;

public class DataException extends RuntimeException {
	  String details;
	  int code;
	    public DataException(String msg)
	    {
	    super(msg);
	    }
	    
	    public DataException(String msg,String details)
	    {
	    super(msg);
	    this.details=details;
	    }
	    
	     public DataException(int code,String msg,String details)
	    {
	    super(msg);
	    this.code=code;
	    this.details=details;
	    }  
}
