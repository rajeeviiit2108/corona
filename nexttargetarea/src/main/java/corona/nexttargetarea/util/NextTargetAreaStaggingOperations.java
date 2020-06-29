package corona.nexttargetarea.util;

import java.sql.Connection;

import corona.nexttargetarea.interfaces.DataProcessing;

public class NextTargetAreaStaggingOperations {
	private NextTargetAreaStaggingOperations()
	{
		
	}
	public static void operationsPerformedOnStagingData(
			DataProcessing dataProcessing,Connection connection)
    {
		dataProcessing.fetchDataFromStagingTable(connection);	
		dataProcessing.validateData();
    }
}
