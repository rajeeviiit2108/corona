package corona.nexttargetarea.util;

import java.text.DateFormat;
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
	Date dateToBeReturned=null;
	try 
	{
	 dateToBeReturned=new SimpleDateFormat("dd-MMM-yy").parse(dateString);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return dateToBeReturned;
	
}
public static String convertDateToString(Date date)
{
	//DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
	DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yy");  
	return dateFormat.format(date);  
}
}
