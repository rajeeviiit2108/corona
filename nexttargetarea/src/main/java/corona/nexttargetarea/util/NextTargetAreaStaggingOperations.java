package corona.nexttargetarea.util;

import java.sql.Connection;

import corona.nexttargetarea.interfaces.DataProcessing;

public class NextTargetAreaStaggingOperations {
	private NextTargetAreaStaggingOperations()
	{
		
	}
	public static void operationsOnTravelTypeStagingData(DataProcessing dataProcessingTravelType,Connection connection)
    {
		dataProcessingTravelType.fetchDataFromStagingTable(connection);	
		dataProcessingTravelType.validateData();
    }
}
