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

import corona.nexttargetarea.csvdto.HospitalDataDto;
import corona.nexttargetarea.customexception.CsvFileReadException;
import corona.nexttargetarea.customexception.FileResolutionException;
import corona.nexttargetarea.interfaces.CsvOperation;
import corona.nexttargetarea.util.NextTargetAreaUtil;
public class CsvOperationHospitalData implements CsvOperation {
	private static List<HospitalDataDto> hospitalDataList=new ArrayList<>();
	@Override
	public void readCsvFile(String filePath, String fileName) 
	{
		CSVReader csvReader =null;
	    try 
	    { 
	        FileReader fileReader = new FileReader(filePath+fileName); 
	        csvReader = new CSVReader(fileReader);
	        HospitalDataDto hospitalDataDto=null;
	        Object[] nextRecord; 
	        nextRecord = csvReader.readNext();
	        while ((nextRecord = csvReader.readNext()) != null) 
	        {
	        	hospitalDataDto=new HospitalDataDto();
	        	if(nextRecord[0]!=null)
	        	{
	        	hospitalDataDto.setAdharId((String)nextRecord[0]);
	        	}
	        	if(nextRecord[1]!=null)
	        	{
	        	hospitalDataDto.setPassportNo((String)nextRecord[1]);
	        	}
	        	if(nextRecord[2]!=null)
	        	{
	        	hospitalDataDto.setFirstName((String)nextRecord[2]);
	        	}
	        	if(nextRecord[3]!=null)
	        	{
	        	hospitalDataDto.setLastName((String)nextRecord[3]);
	        	}
	        	if(nextRecord[4]!=null)
	        	{
	        	hospitalDataDto.setPatientDiseaseHistory((String)nextRecord[4]);
	        	}
	        	try 
	        	{
	        	if(nextRecord[5]!=null)
		        {
	             hospitalDataDto.setPatientAdmittedDate(NextTargetAreaUtil.convertStringToDate((String)nextRecord[5]));
		        }	
	        	if(nextRecord[6]!=null)
	        	{
	        	hospitalDataDto.setPatientDischargedDate(NextTargetAreaUtil.convertStringToDate((String)nextRecord[6]));
	        	}
	        	if(nextRecord[7]!=null)
	        	{
	        	hospitalDataDto.setCoronaSuscpected(Boolean.parseBoolean((String)nextRecord[7]));
	        	}
	        	if(nextRecord[8]!=null)
	        	{
	        	hospitalDataDto.setCoronaConfirmed(Boolean.parseBoolean((String)nextRecord[8]));
	        	}
				} 
	        	catch (ParseException e) 
	        	{
					e.printStackTrace();
				}
	        	hospitalDataList.add(hospitalDataDto);
	        } 
	    } 
	    catch (IOException e) 
	    { 
	       throw new FileResolutionException("Unable to read the data from Hospital_Data.csv", "Unable to read the data from Hospital_Data.csv"); 
	    } 
	    catch (CsvValidationException e) 
	    {
			throw new CsvFileReadException("Unable to validate the Hospital_Data csv", "Unable to validate the Hospital_Data csv");
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
		String hospitalDataSql="insert into Hospital_Data_STG"
				+ "(adhar_id, passport_no, first_name, last_name,"
				+ "patient_disease_history, patient_admitted_date, "
				+ "patient_discharged_date, is_corona_confirmed,is_corona_suspected )"
				+ "values(?,?,?,?,?,?,?,?,?)";
		
	try 
	{
		stmt=connection.prepareStatement(hospitalDataSql);
		for(HospitalDataDto dto: hospitalDataList)
		{
			stmt.setString(1, dto.getAdharId());
			stmt.setString(2, dto.getPassportNo());
			stmt.setString(3, dto.getFirstName());
			stmt.setString(4, dto.getLastName());
			stmt.setString(5, dto.getPatientDiseaseHistory());
			stmt.setDate(6, new Date(dto.getPatientAdmittedDate().getTime()));
			stmt.setDate(7, new Date(dto.getPatientDischargedDate().getTime()));
			stmt.setBoolean(8, dto.isCoronaConfirmed());
			stmt.setBoolean(9, dto.isCoronaSuscpected());
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