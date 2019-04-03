package springapp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import springapp.command.AppointmentCommand;
import springapp.command.ClientCommand;
import springapp.domain.Appointment;
import springapp.domain.Client;
import springapp.domain.Pet;
import springapp.service.AppointmentService;
import springapp.service.ClientService;
import springapp.service.PetService;

/**
 * This controller handles all client related pages
 *
 * Notice the @PreAuthorize annotations on the methods
 */
@Controller
@RequestMapping("/appointments") // notice that this path is set at the class level.
public class AppointmentController {

	// Inject in a ClientService class
	@Autowired
	AppointmentService appointmentService;
	
	@Autowired
	PetService petService;

	@PreAuthorize("hasAuthority('LIST_CLIENTS')")
	@GetMapping
	public String listAppointments(Model model) {
		List<Appointment> appointments = appointmentService.getAppointments();
		model.addAttribute("appointments", appointments);
		return "appointments/listAppointments";
	}
	
	 @PreAuthorize("hasAuthority('GET_CLIENT')")
	 @GetMapping("/{id}")
	 public String getAppointment(@PathVariable("id") String id, Model model, boolean saved) {

		model.addAttribute("saved", saved);
	    if(id.equals("new")) {
	     model.addAttribute("command", new AppointmentCommand(null));	
		
	    } else {
	        // since we have a valid id, get the client object from the service
			Appointment appointment = appointmentService.getAppointment(Integer.parseInt(id));
			// we create a client command that can be used when the browser sends the save object
			model.addAttribute("command", new AppointmentCommand(appointment));
		}
		return "appointments/editAppointments";
	}

}