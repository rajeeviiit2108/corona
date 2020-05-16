package corona.nexttargetarea.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NextTargetAreaUtil 
{
private NextTargetAreaUtil()
{
	
}
public static Date convertStringToDate(String dateString) throws ParseException  
{
	Date dateToBeReturned=new SimpleDateFormat("yyyy-mm-dd").parse(dateString);
	return dateToBeReturned;
}
}
