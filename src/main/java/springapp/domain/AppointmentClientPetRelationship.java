package springapp.domain;

import java.util.HashMap;

public class AppointmentClientPetRelationship {
	private final Integer client_id;
	private final String client_name;
	private final HashMap<Integer, String> pet_id_name;

	public AppointmentClientPetRelationship(Integer client_id, String client_name, HashMap<Integer, String> pet_id_name) {
		this.client_id = client_id;
		this.client_name = client_name;
		this.pet_id_name = pet_id_name;
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
}