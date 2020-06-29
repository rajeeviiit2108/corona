package corona.nexttargetarea.app;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import corona.nexttargetarea.awscloud.StagingTableCreationOnDyanamoDB;
import corona.nexttargetarea.csvoperationimpl.CsvOperationDomesticTravel;
import corona.nexttargetarea.csvoperationimpl.CsvOperationHospitalData;
import corona.nexttargetarea.csvoperationimpl.CsvOperationInternationalTravel;
import corona.nexttargetarea.csvoperationimpl.CsvOperationInternetData;
import corona.nexttargetarea.csvoperationimpl.CsvOperationSocialMedia;
import corona.nexttargetarea.csvoperationimpl.CsvOperationTravelType;
import corona.nexttargetarea.dataprocessingimpl.DataProcessingDomesticTravel;
import corona.nexttargetarea.dataprocessingimpl.DataProcessingHospitalData;
import corona.nexttargetarea.dataprocessingimpl.DataProcessingInternationalTravel;
import corona.nexttargetarea.dataprocessingimpl.DataProcessingInternetData;
import corona.nexttargetarea.dataprocessingimpl.DataProcessingSocialMediaPost;
import corona.nexttargetarea.dataprocessingimpl.DataProcessingTravelType;
import corona.nexttargetarea.dbconnection.DataBaseConnection;
import corona.nexttargetarea.interfaces.DataProcessing;
import corona.nexttargetarea.util.NextTargetAreaAppOperations;
import corona.nexttargetarea.util.NextTargetAreaStaggingOperations;

public class NextTargetAreaApp {
	private static Connection _connection = null;

	public static void main(String[] args) {
		// awsStaggingTableCreation();

		try {
			_connection = DataBaseConnection.createConnection();
			operationsPerformedOnCsv(_connection);
			operationsPerformedOnStaggingData(_connection);
		} finally {
			try {
				if (_connection != null) {
					_connection.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	private static void operationsPerformedOnCsv(Connection connection) {
		NextTargetAreaAppOperations.operationsOnTravelType(new CsvOperationTravelType(), connection);

		NextTargetAreaAppOperations.operationsOnHospitalData(new CsvOperationHospitalData(), connection);

		NextTargetAreaAppOperations.operationsOnDomesticTravel(new CsvOperationDomesticTravel(), connection);

		NextTargetAreaAppOperations.operationsOnInternationalTravel(new CsvOperationInternationalTravel(), connection);

		NextTargetAreaAppOperations.operationsOnInternetData(new CsvOperationInternetData(), connection);

		NextTargetAreaAppOperations.operationsOnSocialMediaData(new CsvOperationSocialMedia(), connection);

	}

	private static void operationsPerformedOnStaggingData(Connection connection) {
		List<DataProcessing> staggingOperationList = allStaggingOperationList();
		for (DataProcessing processing : staggingOperationList) {
			NextTargetAreaStaggingOperations.operationsPerformedOnStagingData(processing, connection);
		}
	}

	private static List<DataProcessing> allStaggingOperationList() {
		List<DataProcessing> staggingOperationList = new ArrayList<>();

		staggingOperationList.add(new DataProcessingTravelType());
		staggingOperationList.add(new DataProcessingDomesticTravel());
		staggingOperationList.add(new DataProcessingInternationalTravel());
		staggingOperationList.add(new DataProcessingHospitalData());
		staggingOperationList.add(new DataProcessingSocialMediaPost());
		staggingOperationList.add(new DataProcessingInternetData());
		return staggingOperationList;
	}

	private static void awsStaggingTableCreation() {
		StagingTableCreationOnDyanamoDB staggingTableCreation = new StagingTableCreationOnDyanamoDB();
		staggingTableCreation.createTravelTypeStaggingTable();
		staggingTableCreation.createDomesticTravelStaggingTable();
		staggingTableCreation.createHospitalDataStaggingTable();
		staggingTableCreation.createInternationalTravelStaggingTable();
		staggingTableCreation.createSocialMediaStaggingTable();
		staggingTableCreation.createInternetDataStaggingTable();
	}

}