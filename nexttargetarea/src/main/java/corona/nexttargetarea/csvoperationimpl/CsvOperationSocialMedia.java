package corona.nexttargetarea.csvoperationimpl;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import corona.nexttargetarea.csvdto.Social_MediaDto;
import corona.nexttargetarea.customexception.CsvFileReadException;
import corona.nexttargetarea.customexception.FileResolutionException;
import corona.nexttargetarea.interfaces.CsvOperation;
import corona.nexttargetarea.util.NextTargetAreaUtil;
public class CsvOperationSocialMedia implements CsvOperation {
	
	private static List<Social_MediaDto> socialMedia=new ArrayList<>();
	@Override
	public void readCsvFile(String filePath, String fileName) 
	{
		CSVReader csvReader =null;
	    try 
	    { 
	        FileReader fileReader = new FileReader(filePath+fileName); 
	        csvReader = new CSVReader(fileReader);
	        Social_MediaDto socialMediaDto=null;
	        Object[] nextRecord; 
	        nextRecord = csvReader.readNext();
	        while ((nextRecord = csvReader.readNext()) != null) 
	        {
	        	socialMediaDto=new Social_MediaDto();
	        	if(nextRecord[0]!=null && !("".equals(nextRecord[0])))
	        	{
	        		socialMediaDto.setAdhar_id((String)nextRecord[0]);
	        	}
	        	if(nextRecord[1]!=null && !("".equals(nextRecord[1])))
	        	{
	        		socialMediaDto.setMobile_no((String)nextRecord[1]);
	        	}
	        	if(nextRecord[2]!=null && !("".equals(nextRecord[2])))
	        	{
	        		socialMediaDto.setEmail_id((String)nextRecord[2]);
	        	}
	        	if(nextRecord[3]!=null && !("".equals(nextRecord[3])))
	        	{
	        		socialMediaDto.setMedia_post((String)nextRecord[3]);
	        	}
	        	try 
	        	{
	        	if(nextRecord[4]!=null && !("".equals(nextRecord[4])))
		        {
	        		socialMediaDto.setPost_date(NextTargetAreaUtil.convertStringToDate((String)nextRecord[4]));
		        }					} 
	        	catch (ParseException e) 
	        	{
					e.printStackTrace();
				}
	        	socialMedia.add(socialMediaDto);
	        } 
	    } 
	    catch (IOException e) 
	    { 
	       throw new FileResolutionException("Unable to read the data from Social_Media_Post.csv", "Unable to read the data from Social_Media_Post.csv"); 
	    } 
	    catch (CsvValidationException e) 
	    {
			throw new CsvFileReadException("Unable to validate the Social_Media_Post csv", "Unable to validate the Social_Media_Post csv");
		}
	    finally
	    {
	    	if(csvReader!=null)
	    	{
	    		try
	    		{
					csvReader.close();
				} catch (IOException e) 
	    		{
					e.printStackTrace();
				}
	    	}
	    }
	}
	
	@Override
	public void pushDataToStaggingTable(Connection connection) 
	{
		PreparedStatement stmt=null;
		String socialMediaSql="insert into Social_Media_STG"
				+ "(adhar_id, mobile_no, email_id, media_post, post_date)"
				+ "values(?,?,?,?,?)";
	try 
	{
			stmt=connection.prepareStatement(socialMediaSql);
		for(Social_MediaDto dto:socialMedia )
		{
			stmt.setString(1, dto.getAdhar_id());
			stmt.setString(2, dto.getMobile_no());
			stmt.setString(3, dto.getEmail_id());
			stmt.setString(4, dto.getMedia_post());
			try
			{
			if(null!=dto.getPost_date())
			{
			stmt.setDate(5, new Date(dto.getPost_date().getTime()));
			}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			stmt.executeUpdate();
		}	
	}
	catch (SQLException e) 
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
	
}





