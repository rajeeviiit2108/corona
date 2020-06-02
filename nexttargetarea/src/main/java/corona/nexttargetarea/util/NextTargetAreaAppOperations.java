package corona.nexttargetarea.util;

import java.sql.Connection;

import corona.nexttargetarea.enums.CsvOperationEnum;
import corona.nexttargetarea.interfaces.CsvOperation;

public class NextTargetAreaAppOperations 
{
	private NextTargetAreaAppOperations()
	{
		
	}
	public static void operationsOnTravelType(CsvOperation csvOperationforTravelData, Connection connection)
    {
    csvOperationforTravelData.readCsvFile(
    		CsvOperationEnum.CSV_FILE_PATH.getCsvInformation(),
			CsvOperationEnum.TRAVEL_TYPE_CSV.getCsvInformation()
			);
    csvOperationforTravelData.pushDataToStaggingTable(connection);		
    }
	public static void operationsOnDomesticTravel(CsvOperation csvOperationforTravelData,Connection connection)
    {
    csvOperationforTravelData.readCsvFile(
    		CsvOperationEnum.CSV_FILE_PATH.getCsvInformation(),
			CsvOperationEnum.DOMESTIC_TRAVEL_CSV.getCsvInformation()
			);
    csvOperationforTravelData.pushDataToStaggingTable(connection);		
    }
	public static void operationsOnInternationalTravel(CsvOperation csvOperationforTravelData, Connection connection)
    {
    csvOperationforTravelData.readCsvFile(
    		CsvOperationEnum.CSV_FILE_PATH.getCsvInformation(),
			CsvOperationEnum.INTERNATIONAL_TRAVEL_CSV.getCsvInformation()
			);
    csvOperationforTravelData.pushDataToStaggingTable(connection);		
    }
	public static void operationsOnInternetData(CsvOperation csvOperationforTravelData,Connection connection)
    {
    csvOperationforTravelData.readCsvFile(
    		CsvOperationEnum.CSV_FILE_PATH.getCsvInformation(),
			CsvOperationEnum.INTERNET_DATA_CSV.getCsvInformation()
			);
    csvOperationforTravelData.pushDataToStaggingTable(connection);		
    }
	public static void operationsOnSocialMediaData(CsvOperation csvOperationforTravelData,Connection connection)
    {
    csvOperationforTravelData.readCsvFile(
    		CsvOperationEnum.CSV_FILE_PATH.getCsvInformation(),
			CsvOperationEnum.SOCIAL_MEDIA_POST_CSV.getCsvInformation()
			);
    csvOperationforTravelData.pushDataToStaggingTable(connection);		
    }
	
	public static void operationsOnHospitalData(CsvOperation csvOperationforTravelData,Connection connection)
    {
    csvOperationforTravelData.readCsvFile(
    		CsvOperationEnum.CSV_FILE_PATH.getCsvInformation(),
			CsvOperationEnum.HOSPITAL_DATA_CSV.getCsvInformation()
			);
    csvOperationforTravelData.pushDataToStaggingTable(connection);		
    }
}
	
	
