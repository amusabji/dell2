package springapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import springapp.domain.Appointment;
import springapp.domain.Client;
import springapp.domain.Pet;

/**
 * This is the client dao that is responsible for managing the clients info in the databsae.
 * The dao acts as the 'gatekeeper' between the rest of the code and the database
 */
@Repository
@Scope("singleton")
public class AppointmentDao {
	//private Logger logger = LoggerFactory.getLogger(AppointmentDao.class);
	
	@Autowired 
	ClientDao clientDao;
	
	@Autowired 
	PetDao petDao;
	
	RowMapper<Appointment> simpleApptMapper = new RowMapper<Appointment>() {

		@Override
		public Appointment mapRow(ResultSet rs, int rowNum) throws SQLException {
		
			Appointment appointment = new Appointment(rs.getInt("id"), rs.getInt("pet_id"), rs.getInt("appt_time"), rs.getDate("appt_date"), rs.getString("appt_type"));
			Pet pet = petDao.get(rs.getInt("pet_id"));
			Client client = pet.getClient();

			appointment.setClient(client);
			appointment.setPet(pet);
			
			return appointment;
		}
	};
	
    @Autowired
    JdbcTemplate jdbcTemplate;
    	
	public List<Appointment> list(){
		List<Appointment> queryResult = jdbcTemplate.query("SELECT id, pet_id, appt_time, appt_date, appt_type FROM appointments",
				simpleApptMapper);
		
		return queryResult;
	}
	
	public Appointment get(int id) {
		List<Appointment> queryResult = jdbcTemplate.query(
				"SELECT id, client_id, pet_id, appt_time, appt_date, appt_type FROM appointments WHERE id = ? LIMIT 1", 
				new Object[] {id},
				simpleApptMapper);
		
		if(queryResult.isEmpty())
			return null;
		
		return queryResult.get(0);
	}
	
	public Appointment save(Appointment appointment) {
		Integer id = appointment.getId();
		
		if(id == null) {
			
			KeyHolder holder = new GeneratedKeyHolder();
			jdbcTemplate.update(new PreparedStatementCreator() {
			
				@Override
				public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
					PreparedStatement statement = con.prepareStatement("INSERT INTO appointments (pet_id, appt_time, appt_date, appt_type) VALUES (?, ?, ?, ?)");

					statement.setInt(2, appointment.getPetId());
					statement.setInt(3, appointment.getApptTime());
					statement.setDate(4, appointment.getApptDate());
					statement.setString(5, appointment.getApptType());
					return statement;
				}
			}, holder);
			
			id = holder.getKey().intValue();
			
		} else {
			jdbcTemplate.update("UPDATE appointments SET pet_id = ? , appt_time = ?, appt_date = ?, appt_type = ? WHERE id = ?",
					new Object[] {appointment.getPetId(), appointment.getApptTime(),  appointment.getApptDate(),  appointment.getApptType(), id});
		}
		
		return get(id);
	}
	
	public void delete(int id) {
		
		jdbcTemplate.update("DELETE FROM appointments WHERE id = ?",
				new Object[] {id});
		
	}
	
}
