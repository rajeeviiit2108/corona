package corona.nexttargetarea.csvdto;

import java.io.Serializable;
import java.util.Date;
public class DomesticTravelDto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String adhar_id;
	private String is_domestic_travel;
	private String travel_history;
	private Date travel_date;
	private String travel_from;

	public String getAdhar_id() {
		return adhar_id;
	}
	public void setAdhar_id(String adhar_id) {
		this.adhar_id = adhar_id;
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
	public void setTravel_date(Date date) {
		this.travel_date = date;
	}
	public String getTravel_from() {
		return travel_from;
	}
	public void setTravel_from(String travel_from) {
		this.travel_from = travel_from;
	}
	
}
