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
import corona.nexttargetarea.stagingdatadto.HospitalDataStagingDto;

public class DataProcessingHospitalData implements DataProcessing
{
	private static List<HospitalDataStagingDto> list=new ArrayList<>();

	@Override
	public void fetchDataFromStagingTable(Connection connection)
	{
		PreparedStatement stmt=null;
		String sql="select * from Hospital_Data_STG" ;
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
		long passportNo=0L;
		
		if(0L!=resultSet.getLong(StaggingDataProcessingEnum.ADHAR_ID.toString()))
		{
			adharId=Long. parseLong(resultSet.getString(StaggingDataProcessingEnum.ADHAR_ID.toString()));
		}
		
		if(0L!=resultSet.getLong(StaggingDataProcessingEnum.PASSPORT_NO.toString()))
		{
			passportNo=Long. parseLong(resultSet.getString(StaggingDataProcessingEnum.PASSPORT_NO.toString()));
		}
		String firstName=resultSet.getString("first_name");
		String lastName=resultSet.getString("last_name");
		String patientDiseaseHistory=resultSet.getString("patient_disease_history");
		Date patientAdmittedDate=resultSet.getDate("patient_admitted_date");
		Date patientDischargedDate=resultSet.getDate("patient_discharged_date");
		boolean isCoronaConfirmed=resultSet.getBoolean("is_corona_confirmed");
		boolean isCoronaSuspected=resultSet.getBoolean("is_corona_suspected");
		
		HospitalDataStagingDto dto=new HospitalDataStagingDto();
		dto.setAdharId(adharId);
		dto.setPassportNo(passportNo);
		dto.setFirstName(firstName);
		dto.setLastName(lastName);
		dto.setPatientDiseaseHistory(patientDiseaseHistory);
		dto.setPatientAdmittedDate(patientAdmittedDate);
		dto.setPatientDischargedDate(patientDischargedDate);
		dto.setCoronaConfirmed(isCoronaConfirmed);
		dto.setCoronaSuspected(isCoronaSuspected);
		list.add(dto);
	}

	@Override
	public void validateData()
	{
		System.out.println("----------------------------");
		System.out.println("------HospitalDataStagingDto------");

		for(HospitalDataStagingDto data: list)
		{
			System.out.println("Adhar id is::: " + data.getAdharId());
			System.out.println("Passport id is::: " + data.getPassportNo());
			System.out.println("FirstName is::: " + data.getFirstName());
			System.out.println("Last Name is::: " + data.getLastName());
			System.out.println("Patient disease history is::: " + data.getPatientDiseaseHistory());
			System.out.println("Patient admitted date is::: " + data.getPatientAdmittedDate());
			System.out.println("Patient discharged date is::: " + data.getPatientDischargedDate());
			System.out.println("is corona confirmed ::: " + data.isCoronaConfirmed());
			System.out.println("is corona suspected ::: " + data.isCoronaSuspected());
		}
	}

	@Override
	public void pushDataToMainTable() {
		// TODO Auto-generated method stub
		
	}
}
