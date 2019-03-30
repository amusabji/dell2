package springapp.command;

import java.sql.Date;
import java.time.LocalDate;
import springapp.domain.Appointment;
import springapp.domain.Client;
import springapp.domain.Pet;

/**
 * This command class is used to pass information back and force between the
 * client and the server
 * 
 */
public class AppointmentCommand {

	private Integer id;
	private Integer pet_id;
	private Integer appt_time;
	private Date appt_date;
	private String appt_type;
	private Pet pet;
	private Client client;

	/**
	 * Creates a command object that has the initial values the same as the appointment
	 * passed in
	 * 
	 */
	public AppointmentCommand(Appointment appointment) {
		if (appointment != null) {
			id = appointment.getId();
			this.pet_id = appointment.getPetId();
			this.appt_date = appointment.getApptDate();
			this.appt_time = appointment.getApptTime();
			this.appt_type = appointment.getApptType();
		}
	}
	
	public AppointmentCommand() {}

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

	public void setId(Integer id) {
		this.id = id;
	}

	public void setPetId(Integer pet_id) {
		this.pet_id = pet_id;
	}

	public void setApptTime(Integer appt_time) {
		this.appt_time = appt_time;
	}

	public void setApptDate(Date appt_date) {
		this.appt_date = appt_date;
	}

	public void setApptType(String appt_type) {
		this.appt_type = appt_type;
	}
	
	public Pet getPet() {
		return pet;
	}
	
	public void setPet(Pet pet) {
		this.pet = pet;
	}
	
	public Client getClient() {
		return client;
	}
	
	public void setClient(Client client) {
		this.client = client;
	}
	

	
}
