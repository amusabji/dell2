package springapp.domain;

import java.sql.Date;
import java.time.LocalDate;

public class Appointment {
	private final Integer id;
	private final Integer pet_id;
	private final Integer appt_time;
	private final Date appt_date;
	private final String appt_type;
	
	private Client client;
	private Pet pet;
	
	public Appointment(Integer id, Integer pet_id, Integer appt_time, Date date, String appt_type) {
		this.id = id;
		this.pet_id = pet_id;
		this.appt_time = appt_time;
		this.appt_date = date;
		this.appt_type = appt_type;
	}

	public Integer getId() {
		return id;
	}

	public Integer getPetId() {
		return pet_id;
	}

	public Integer getApptTime() {
		return appt_time;
	}

	public Date getApptDate() {
		return appt_date;
	}

	public String getApptType() {
		return appt_type;
	}
	
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	
	public Pet getPet() {
		return pet;
	}
	public void setPet(Pet pet) {
		this.pet = pet;
	}
}
