package corona.nexttargetarea.csvdto;

import java.io.Serializable;
public class InternetDataDto  implements Serializable{
	
	private static final long serialVersionUID = 1L;
    private String email_id;
    private String information;
    private String link;
    private String place_name;
    private String no_of_infected_people;
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public String getInformation() {
		return information;
	}
	public void setInformation(String information) {
		this.information = information;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getPlace_name() {
		return place_name;
	}
	public void setPlace_name(String place_name) {
		this.place_name = place_name;
	}
	public String getNo_of_infected_people() {
		return no_of_infected_people;
	}
	public void setNo_of_infected_people(String no_of_infected_people) {
		this.no_of_infected_people = no_of_infected_people;
	}

}
