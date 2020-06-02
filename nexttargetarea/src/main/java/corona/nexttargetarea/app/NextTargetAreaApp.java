package corona.nexttargetarea.app;
import java.sql.Connection;
import java.sql.SQLException;

import corona.nexttargetarea.csvoperationimpl.CsvOperationDomesticTravel;
import corona.nexttargetarea.csvoperationimpl.CsvOperationHospitalData;
import corona.nexttargetarea.csvoperationimpl.CsvOperationInternationalTravel;
import corona.nexttargetarea.csvoperationimpl.CsvOperationInternetData;
import corona.nexttargetarea.csvoperationimpl.CsvOperationSocialMedia;
import corona.nexttargetarea.csvoperationimpl.CsvOperationTravelType;
import corona.nexttargetarea.dataprocessingimpl.DataProcessingTravelType;
import corona.nexttargetarea.dbconnection.DataBaseConnection;
import corona.nexttargetarea.util.NextTargetAreaAppOperations;
import corona.nexttargetarea.util.NextTargetAreaStaggingOperations;

public class NextTargetAreaApp 
{
	private static Connection _connection=null;
	
    public static void main( String[] args )
    {
    	try
		{
			_connection=DataBaseConnection.createConnection();
			operationsPerformedOnCsv(_connection);
	    	operationsPerformedOnStaggingData(_connection);
		}
		finally
		{
			try {
				if(_connection!=null)
				{
					_connection.close();
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
    }
    private static void operationsPerformedOnCsv(Connection connection)
    {
    	NextTargetAreaAppOperations.operationsOnTravelType(new CsvOperationTravelType(),connection);
        NextTargetAreaAppOperations.operationsOnHospitalData(new CsvOperationHospitalData(),connection);
        NextTargetAreaAppOperations.operationsOnDomesticTravel(new CsvOperationDomesticTravel(),connection);
        NextTargetAreaAppOperations.operationsOnInternationalTravel(new CsvOperationInternationalTravel(),connection);
        NextTargetAreaAppOperations.operationsOnInternetData(new CsvOperationInternetData(),connection);
        NextTargetAreaAppOperations.operationsOnSocialMediaData(new CsvOperationSocialMedia(),connection);
    }
    private static void operationsPerformedOnStaggingData(Connection connection)
    {
    	NextTargetAreaStaggingOperations.operationsOnTravelTypeStagingData(new DataProcessingTravelType(),connection);
}
}
