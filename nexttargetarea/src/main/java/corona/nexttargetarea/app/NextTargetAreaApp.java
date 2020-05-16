package corona.nexttargetarea.app;

import corona.nexttargetarea.impl.CsvOperationITravelType;
import corona.nexttargetarea.interfaces.CsvOperation;
import corona.nexttargetarea.util.NextTargetAreaAppOperations;

public class NextTargetAreaApp 
{
    public static void main( String[] args )
    {
    	CsvOperation csvOperationforTravelData=new CsvOperationITravelType();
    	NextTargetAreaAppOperations.operationsOnTravelType(csvOperationforTravelData);
    }
}
