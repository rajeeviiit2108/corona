package corona.nexttargetarea.dbconnection;


import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseConnection {

	private static Connection _connection;
	private static String pass="MyPrivacy@555";
	private DataBaseConnection()
	{
		
	}
	public static Connection createConnection()
	{
		try
		{  
		    Class.forName("com.mysql.jdbc.Driver");  
		    
		    	if(_connection==null)
		    	{
		    		synchronized(DataBaseConnection.class)
				    {
		    			if(_connection==null)
		    			{
		    				_connection=DriverManager.getConnection(  
		    					    "jdbc:mysql://localhost:3306/nexttargetarea?autoReconnect=true&useSSL=false","root",pass);
		    			}
				    }
		    	}
		    }
		catch(Exception e)
		{ 
			System.out.println(e);
		}
		return _connection;
	}
}
