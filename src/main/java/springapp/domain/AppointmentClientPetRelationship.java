package springapp.domain;

import java.util.HashMap;

public class AppointmentClientPetRelationship {
	private final Appointment appointment;
	private final String client_name;
	private final HashMap<Integer, String> pet_hashMap;
	
	public AppointmentClientPetRelationship(Appointment appointment, String client_name, HashMap<Integer, String> pet_hashMap) {
		this.appointment = appointment;
		this.client_name = client_name;
		this.pet_hashMap = pet_hashMap;
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
}