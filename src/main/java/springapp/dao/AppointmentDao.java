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
/**
 * This is the client dao that is responsible for managing the clients info in
 * the databsae. The dao acts as the 'gatekeeper' between the rest of the code
 * and the database
 */
@Repository
@Scope("singleton")
public class AppointmentDao {
	private Logger logger = LoggerFactory.getLogger(AppointmentDao.class);

	RowMapper<Appointment> simpleMapper = new RowMapper<Appointment>() {

		@Override
		public Appointment mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new Appointment(rs.getInt("id"), rs.getInt("client_id"), rs.getInt("pet_id"),
					rs.getString("appt_time"), rs.getString("appt_date"), rs.getString("appt_type"));
		}
	};

	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<Appointment> list() {
		List<Appointment> queryResult = jdbcTemplate
				.query("SELECT id, client_id, pet_id, appt_time, appt_date, appt_type FROM appointments", simpleMapper);

		return queryResult;
	}
	
	public Appointment get(int id) {
		List<Appointment> queryResult = jdbcTemplate
				.query("SELECT id, client_id, pet_id, appt_time, appt_date, appt_type FROM appointments WHERE id = ? LIMIT 1", new Object[] {id}, simpleMapper);
		
		if(queryResult.isEmpty()) {
			return null;
		}
		
		return queryResult.get(0);
	}
	
	public void delete(int id) {
		jdbcTemplate.update("DELETE FROM appointments WHERE id = ?",
				new Object[] {id});
	}

	public Appointment save(Appointment appointment) {
		Integer id = appointment.getId();
		if(id == null) {

			KeyHolder holder = new GeneratedKeyHolder();

			jdbcTemplate.update(new PreparedStatementCreator() {

				@Override
				public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
					PreparedStatement statement = con.prepareStatement("INSERT INTO appointments(client_id, pet_id, appt_time, appt_date, appt_type) VALUES (?, ?, ?, ?, ?)");
					statement.setInt(1, appointment.getClient_id());
					statement.setInt(2, appointment.getPet_id());
					statement.setString(3, appointment.getAppt_time());
					statement.setString(4, appointment.getAppt_date());
					statement.setString(5, appointment.getAppt_type());
					return statement;

				}
			}, holder);

			id = holder.getKey().intValue();

		} else {
			jdbcTemplate.update("UPDATE appointments SET client_id = ?, pet_id= ? , appt_time = ? , appt_date = ? , appt_type = ? WHERE id = ?",
					new Object[] {appointment.getClient_id(), appointment.getPet_id(), appointment.getAppt_time(), appointment.getAppt_date(), appointment.getAppt_type(), id});
		}

		return get(id);
	}
	
	public List<Appointment> listForClient(int clientId){
		List<Appointment> queryResult = jdbcTemplate.query(
				"SELECT id, client_id, pet_id, appt_time, appt_date, appt_type FROM appointments WHERE client_id = ?",
				new Object[] {clientId},
				simpleMapper);

		return queryResult;
	}

}