package springapp.command;

import java.util.HashMap;

import springapp.domain.Appointment;
import springapp.domain.Client;
import springapp.domain.AppointmentClientPetRelationship;

/**
 * This command class is used to pass information back and force between the
 * client and the server
 * 
 */
public class AppointmentClientPetCommand {

	private Appointment appointment;
	private String client_name;
	private HashMap<Integer, String> pet_hashMap;

	/**
	 * Creates a command object that has the initial values the same as the client
	 * passed in
	 * 
	 * @param client the client to initialize the command object with
	 */
	public AppointmentClientPetCommand(AppointmentClientPetRelationship apptClientPet) {
		if (apptClientPet != null) {
			this.appointment = apptClientPet.getAppointment();
			this.client_name = apptClientPet.getClient_name();
			this.pet_hashMap = apptClientPet.getPet_hashMap();
		}
	}

	public Appointment getAppointment() {
		return appointment;
	}
	
	public String getClient_name() {
		return client_name;
	}

	public HashMap<Integer, String> getPet_hashMap() {
		return pet_hashMap;
	}

	public void setClient_id(Appointment appointment) {
		this.appointment = appointment;
	}

	public void setClient_name(String client_name) {
		this.client_name = client_name;
	}
	
	public void setPet_id_name(HashMap<Integer, String> pet_hashMap) {
		this.pet_hashMap = pet_hashMap;
	}

}