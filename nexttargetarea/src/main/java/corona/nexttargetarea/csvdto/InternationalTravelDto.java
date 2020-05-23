package corona.nexttargetarea.csvdto;

import java.io.Serializable;
import java.util.Date;
public class InternationalTravelDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String passport_no;
	private String is_domestic_travel;
	private String travel_history;
	private Date travel_date;
	private String travel_from;
	public String getPassport_no() {
		return passport_no;
	}
	public void setPassport_no(String passport_no) {
		this.passport_no = passport_no;
	}
	public String getIs_domestic_travel() {
		return is_domestic_travel;
	}
	public void setIs_domestic_travel(String is_domestic_travel) {
		this.is_domestic_travel = is_domestic_travel;
	}
	public String getTravel_history() {
		return travel_history;
	}
	public void setTravel_history(String travel_history) {
		this.travel_history = travel_history;
	}
	public Date getTravel_date() {
		return travel_date;
	}
	public void setTravel_date(Date travel_date) {
		this.travel_date = travel_date;
	}
	public String getTravel_from() {
		return travel_from;
	}
	public void setTravel_from(String travel_from) {
		this.travel_from = travel_from;
	}
	

}
