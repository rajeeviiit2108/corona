package corona.nexttargetarea.customexception;

public class CsvFileReadException extends RuntimeException{
	private int code;
	private String details;
    private String message;
    
    public CsvFileReadException(String message)
    {
    this.message=message;
    }
    
    public CsvFileReadException(String message,String details)
    {
    this.message=message;
    this.details=details;
    }
    
    public CsvFileReadException(int code,String message,String details)
    {
    this.code=code;
    this.message=message;
    this.details=details;
    }
}
