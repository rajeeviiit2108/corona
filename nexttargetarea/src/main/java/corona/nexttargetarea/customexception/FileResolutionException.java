package corona.nexttargetarea.customexception;

public class FileResolutionException extends RuntimeException{
	private int code;
	private String details;
    private String message;
    
    public FileResolutionException(String message)
    {
    this.message=message;
    }
    
    public FileResolutionException(String message,String details)
    {
    this.message=message;
    this.details=details;
    }
    
    public FileResolutionException(int code,String message,String details)
    {
    this.code=code;
    this.message=message;
    this.details=details;
    }
}
