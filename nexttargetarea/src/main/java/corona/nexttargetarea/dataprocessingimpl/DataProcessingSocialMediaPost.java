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
import corona.nexttargetarea.stagingdatadto.SocialMediaPostStagingDataDto;

public class DataProcessingSocialMediaPost implements DataProcessing
{
	private static List<SocialMediaPostStagingDataDto> list=new ArrayList<>();

	@Override
	public void fetchDataFromStagingTable(Connection connection)
	{
		PreparedStatement stmt=null;
		String sql="select * from Social_Media_STG" ;
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
		long adharId=0L;
		if(0L!=resultSet.getLong(StaggingDataProcessingEnum.ADHAR_ID.toString()))
		{
			adharId=Long. parseLong(resultSet.getString(StaggingDataProcessingEnum.ADHAR_ID.toString()));
		}
		long  mobileNumber=resultSet.getLong("mobile_no");
		String emailId=resultSet.getString("email_id");
		String  mediaPost =resultSet.getString("media_post");
		Date postDate=resultSet.getDate("post_date");

		SocialMediaPostStagingDataDto dto=new SocialMediaPostStagingDataDto();
		dto.setAdharId(adharId);
		dto.setEmailId(emailId);
		dto.setMobileNumber(mobileNumber);
		dto.setMediaPost(mediaPost);
		dto.setPostDate(postDate);
		list.add(dto);
	}

	@Override
	public void validateData()
	{
		System.out.println("----------------------------");
		System.out.println("------SocailMediaPostStagingDataDto------");

		for(SocialMediaPostStagingDataDto data: list)
		{
			System.out.println("Adhar id is::: " + data.getAdharId());
			System.out.println("Email id is::: " + data.getEmailId());
			System.out.println("Media Post is::: " + data.getMediaPost());
			System.out.println("Mobile number is::: " + data.getMobileNumber());
			System.out.println("Post date is::: " + data.getPostDate());
		}
	}

	@Override
	public void pushDataToMainTable() {
		// TODO Auto-generated method stub
		
	}

}
