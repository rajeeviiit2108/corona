package corona.nexttargetarea.app;

import corona.nexttargetarea.impl.CsvOperationDomesticTravel;
import corona.nexttargetarea.impl.CsvOperationHospitalData;
import corona.nexttargetarea.impl.CsvOperationITravelType;
import corona.nexttargetarea.impl.CsvOperationInternationalTravel;
import corona.nexttargetarea.impl.CsvOperationInternetData;
import corona.nexttargetarea.impl.CsvOperationSocialMedia;
import corona.nexttargetarea.interfaces.CsvOperation;
import corona.nexttargetarea.util.NextTargetAreaAppOperations;

public class NextTargetAreaApp 
{
    public static void main( String[] args )
    {
    	CsvOperation csvOperationForHospitalData=new CsvOperationHospitalData();
        NextTargetAreaAppOperations.operationsOnHospitalData(csvOperationForHospitalData);

    	
    	CsvOperation csvOperationforTravelData=new CsvOperationITravelType();
        NextTargetAreaAppOperations.operationsOnTravelType(csvOperationforTravelData);
        
    	CsvOperation csvOperationforDomesticData=new CsvOperationDomesticTravel();
        NextTargetAreaAppOperations.operationsOnDomesticTravel(csvOperationforDomesticData);
        
    	CsvOperation csvOperationforInternationaltravel=new CsvOperationInternationalTravel();
        NextTargetAreaAppOperations.operationsOnInternationalTravel(csvOperationforInternationaltravel);
        
    	CsvOperation csvOperationforInternetData=new CsvOperationInternetData();
        NextTargetAreaAppOperations.operationsOnInternetData(csvOperationforInternetData);
        
    	CsvOperation csvOperationforSocialMediaData=new CsvOperationSocialMedia();
        NextTargetAreaAppOperations.operationsOnSocialMediaData(csvOperationforSocialMediaData);
        
    	
    }
}
