package corona.nexttarget.Exception.definition;

public class FileResolutionException extends RuntimeException{

    String details;
    int code;
    public FileResolutionException(String msg)
    {
    super(msg);
    }
    
    public FileResolutionException(String msg,String details)
    {
    super(msg);
    this.details=details;
    }
    
     public FileResolutionException(int code,String msg,String details)
    {
    super(msg);
    this.code=code;
    this.details=details;
    }  

}
