package corona.nexttargetarea.app;

import corona.nexttargetarea.impl.CsvOperationDomesticTravel;
import corona.nexttargetarea.impl.CsvOperationHospitalData;
import corona.nexttargetarea.impl.CsvOperationITravelType;
import corona.nexttargetarea.impl.CsvOperationInternationalTravel;
import corona.nexttargetarea.impl.CsvOperationInternetData;
import corona.nexttargetarea.impl.CsvOperationSocialMedia;
import corona.nexttargetarea.util.NextTargetAreaAppOperations;

public class NextTargetAreaApp 
{
    public static void main( String[] args )
    {
        NextTargetAreaAppOperations.operationsOnTravelType(new CsvOperationITravelType());
        
        NextTargetAreaAppOperations.operationsOnHospitalData(new CsvOperationHospitalData());
        
        NextTargetAreaAppOperations.operationsOnDomesticTravel(new CsvOperationDomesticTravel());
        
        NextTargetAreaAppOperations.operationsOnInternationalTravel(new CsvOperationInternationalTravel());
        
        NextTargetAreaAppOperations.operationsOnInternetData(new CsvOperationInternetData());
        
        NextTargetAreaAppOperations.operationsOnSocialMediaData(new CsvOperationSocialMedia());
    }
}
