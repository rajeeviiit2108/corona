package corona.nexttargetarea.dataprocessingimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import corona.nexttargetarea.dbconnection.DataBaseConnection;
import corona.nexttargetarea.enums.StaggingDataProcessingEnum;
import corona.nexttargetarea.interfaces.DataProcessing;
import corona.nexttargetarea.stagingdatadto.TravelTypeStagingDataDto;

public class DataProcessingTravelType implements DataProcessing
{
	private static List<TravelTypeStagingDataDto> travelTypeStagingDataList=new ArrayList<>();

	@Override
	public void fetchDataFromStagingTable(Connection connection)
	{
		PreparedStatement stmt=null;
		String travelTypeFetchSql="select * from Travel_Type_STG" ;
		try 
		{
			stmt=connection.prepareStatement(travelTypeFetchSql);
			ResultSet resultSet=stmt.executeQuery();
			while (resultSet.next())
			{
				setDataInStagingDto(resultSet);
			}
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		catch (NumberFormatException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	private void setDataInStagingDto(ResultSet resultSet) throws NumberFormatException, SQLException
	{
		TravelTypeStagingDataDto travelTypeStagingDataDto=null;
		long adharId=Long. parseLong(resultSet.getString(StaggingDataProcessingEnum.ADHAR_ID.toString()));
		long passportNo=0L;
		if(0L!=resultSet.getLong(StaggingDataProcessingEnum.PASSPORT_NO.toString()))
		{
			passportNo=Long. parseLong(resultSet.getString(StaggingDataProcessingEnum.PASSPORT_NO.toString()));
		}
		boolean isDomesticTravel=Boolean.parseBoolean(resultSet.getString(StaggingDataProcessingEnum.IS_DOMESTIC_TRAVEL.toString()));
		Date dateOfJourney=resultSet.getDate(StaggingDataProcessingEnum.DATE_OF_JOURNEY.toString());
		travelTypeStagingDataDto=new TravelTypeStagingDataDto();
		travelTypeStagingDataDto.setAdharId(adharId);
		travelTypeStagingDataDto.setPassportNo(passportNo);
		travelTypeStagingDataDto.setDomesticTravel(isDomesticTravel);
		travelTypeStagingDataDto.setDateOfJourney(dateOfJourney);
		travelTypeStagingDataList.add(travelTypeStagingDataDto);
	}

	@Override
	public void validateData() 
	{
		System.out.println("----------------------------");
		System.out.println("------TravelTypeStagingDataDto------");
		
		for(TravelTypeStagingDataDto travelData: travelTypeStagingDataList)
		{
			System.out.println("Aadhar id is::: " + travelData.getAdharId());
			System.out.println("Passport id is::: " + travelData.getPassportNo());
			System.out.println("isDomesticTravel is ::: " + travelData.isDomesticTravel());
			System.out.println("Date of journey is::: " + travelData.getDateOfJourney());
		}
	}

	@Override
	public void pushDataToMainTable() {
		// TODO Auto-generated method stub
		
	}
}
