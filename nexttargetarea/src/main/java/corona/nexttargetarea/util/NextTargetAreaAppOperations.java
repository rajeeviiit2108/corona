package corona.nexttargetarea.util;

import corona.nexttargetarea.enums.CsvOperationEnum;
import corona.nexttargetarea.interfaces.CsvOperation;

public class NextTargetAreaAppOperations 
{
	private NextTargetAreaAppOperations()
	{
		
	}
	public static void operationsOnTravelType(CsvOperation csvOperationforTravelData)
    {
    csvOperationforTravelData.readCsvFile(
    		CsvOperationEnum.CSV_FILE_PATH.getCsvInformation(),
			CsvOperationEnum.TRAVEL_TYPE_CSV.getCsvInformation()
			);
    csvOperationforTravelData.pushDataToStaggingTable();		
    }
}
