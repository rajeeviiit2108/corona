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
import corona.nexttargetarea.stagingdatadto.InternationalTravelStaggingDataDto;

public class DataProcessingInternationalTravel implements DataProcessing
{
	private static List<InternationalTravelStaggingDataDto> internationalTravelStagingDataList=new ArrayList<>();

	@Override
	public void fetchDataFromStagingTable(Connection connection)
	{
		PreparedStatement stmt=null;
		String sql="select * from International_Travel_STG" ;
		try 
		{
			stmt=connection.prepareStatement(sql);
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
		long passportNo=0L;
		if(0L!=resultSet.getLong(StaggingDataProcessingEnum.PASSPORT_NO.toString()))
		{
			passportNo=Long. parseLong(resultSet.getString(StaggingDataProcessingEnum.PASSPORT_NO.toString()));
		}
		String  travelHistory=resultSet.getString("travel_history");
		Date travelDate=resultSet.getDate("travel_date");
		String  travelFrom =resultSet.getString("travel_from");
		boolean isDomesticTravel=resultSet.getBoolean("is_domestic_travel");
		
		InternationalTravelStaggingDataDto dto=new InternationalTravelStaggingDataDto();
		dto.setPassportNo(passportNo);
		dto.setDomesticTravel(isDomesticTravel);
		dto.setTravelHistory(travelHistory);
		dto.setTravelDate(travelDate);
		dto.setTravelFrom(travelFrom);
		internationalTravelStagingDataList.add(dto);
	}

	@Override
	public void validateData()
	{
		System.out.println("----------------------------");
		System.out.println("------InternationalTravelStaggingDataDto------");

		for(InternationalTravelStaggingDataDto data: internationalTravelStagingDataList)
		{
			System.out.println("Passport id is::: " + data.getPassportNo());
			System.out.println("is domestic travel is is::: " + data.isDomesticTravel());
			System.out.println("Travel history is::: " + data.getTravelHistory());
			System.out.println("Travel Date is::: " + data.getTravelDate());
			System.out.println("Travel from id is::: " + data.getTravelFrom());
		}
	}

	@Override
	public void pushDataToMainTable() {
		// TODO Auto-generated method stub
		
	}
}