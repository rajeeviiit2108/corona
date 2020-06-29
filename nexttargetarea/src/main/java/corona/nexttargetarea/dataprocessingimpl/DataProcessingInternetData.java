package corona.nexttargetarea.dataprocessingimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import corona.nexttargetarea.interfaces.DataProcessing;
import corona.nexttargetarea.stagingdatadto.InternetDataStagingDataDto;

public class DataProcessingInternetData implements DataProcessing
{
	private static List<InternetDataStagingDataDto> list=new ArrayList<>();

	@Override
	public void fetchDataFromStagingTable(Connection connection)
	{
		PreparedStatement stmt=null;
		String sql="select * from Internet_Data_STG" ;
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
		String emailId=resultSet.getString("email_id");
		String information=resultSet.getString("information");
		String  link =resultSet.getString("link");
		String  placeName =resultSet.getString("place_name");
		
		String  numberOfInfectedPeople =resultSet.getString("no_of_infected_people");
		InternetDataStagingDataDto dto=new InternetDataStagingDataDto();
		dto.setEmailId(emailId);
		dto.setInformation(information);
		dto.setLink(link);
		dto.setNumberOfInfectedPeople(numberOfInfectedPeople);
		dto.setPlaceName(placeName);
		list.add(dto);
	}

	@Override
	public void validateData()
	{
		System.out.println("----------------------------");
		System.out.println("------InternetDataStagingDataDto------");

		for(InternetDataStagingDataDto data: list)
		{
			System.out.println("Email id is::: " + data.getEmailId());
			System.out.println("Information is::: " + data.getInformation());
			System.out.println("Link is::: " + data.getLink());
			System.out.println("Infected people is::: " + data.getNumberOfInfectedPeople());
			System.out.println("Place name is::: " + data.getPlaceName());
		}
	}

	@Override
	public void pushDataToMainTable() {
		// TODO Auto-generated method stub
		
	}
}
