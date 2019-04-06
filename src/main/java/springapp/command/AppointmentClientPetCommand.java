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

	private Integer client_id;
	private String client_name;
	private HashMap<Integer, String> pet_id_name;

	/**
	 * Creates a command object that has the initial values the same as the client
	 * passed in
	 * 
	 * @param client the client to initialize the command object with
	 */
	public AppointmentClientPetCommand(AppointmentClientPetRelationship apptClientPet) {
		if (apptClientPet != null) {
			this.client_id = apptClientPet.getClient_id();
			this.client_name = apptClientPet.getClient_name();
			this.pet_id_name = apptClientPet.getPet_id_name();
		}
	}

	public Integer getClient_id() {
		return client_id;
	}
	
	public String getClient_name() {
		return client_name;
	}

	public HashMap<Integer, String> getPet_id_name() {
		return pet_id_name;
	}

	public void setClient_id(Integer client_id) {
		this.client_id = client_id;
	}

	public void setClient_name(String client_name) {
		this.client_name = client_name;
	}
	
	public void setPet_id_name(HashMap<Integer, String> pet_id_name) {
		this.pet_id_name = pet_id_name;
	}

}