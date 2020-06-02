package corona.nexttargetarea.interfaces;

import java.sql.Connection;

public interface DataProcessing 
{
void fetchDataFromStagingTable(Connection connection);
void validateData();
void pushDataToMainTable();
}
