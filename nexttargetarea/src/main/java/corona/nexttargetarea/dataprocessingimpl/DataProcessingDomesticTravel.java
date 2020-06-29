package corona.nexttargetarea.dataprocessingimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import corona.nexttargetarea.enums.StaggingDataProcessingEnum;
import corona.nexttargetarea.interfaces.DataProcessing;
import corona.nexttargetarea.stagingdatadto.DomesticTravelStagingDataDto;

public class DataProcessingDomesticTravel implements DataProcessing{

	private static List<DomesticTravelStagingDataDto> domesticTravelStagingDataList=new ArrayList<>();
	@Override
	public void fetchDataFromStagingTable(Connection connection)
	{
		PreparedStatement stmt=null;
		String travelTypeFetchSql="select * from Domestic_Travel_STG" ;
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
		
		long adharId=Long. parseLong(resultSet.getString(StaggingDataProcessingEnum.ADHAR_ID.toString()));
		String  travelHistory=resultSet.getString("travel_history");
		Date travelDate=resultSet.getDate("travel_date");
		String  travelFrom =resultSet.getString("travel_from");
		boolean isDomesticTravel=resultSet.getBoolean("is_domestic_travel");
		DomesticTravelStagingDataDto domesticTravelStagingDataDto=new DomesticTravelStagingDataDto();
		domesticTravelStagingDataDto.setAdharId(adharId);
		domesticTravelStagingDataDto.setTravelHistory(travelHistory);
		domesticTravelStagingDataDto.setTravelDate(travelDate);
		domesticTravelStagingDataDto.setTravelFrom(travelFrom);
		domesticTravelStagingDataDto.setDomesticTravel(isDomesticTravel);
		domesticTravelStagingDataList.add(domesticTravelStagingDataDto);
	}

	@Override
	public void validateData() {
		System.out.println("----------------------------");
		System.out.println("------DomesticTravelStagingDataDto------");
		
		for(DomesticTravelStagingDataDto domesticTravel: domesticTravelStagingDataList)
		{
			System.out.println("Aadhar id is::: " +   domesticTravel.getAdharId());
			System.out.println("is domestic travel is is::: " + domesticTravel.isDomesticTravel());
			System.out.println("Travel from id is::: " + domesticTravel.getTravelFrom());
			System.out.println("Travel history is::: " + domesticTravel.getTravelHistory());
			System.out.println("Travel Date is::: " + domesticTravel.getTravelDate());
		}
	}

	@Override
	public void pushDataToMainTable() {
		// TODO Auto-generated method stub
		
	}

}
