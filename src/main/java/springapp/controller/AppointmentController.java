package springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import springapp.command.AppointmentCommand;
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


	@Autowired
	AppointmentService appointmentService;
	
    // injecting in a PetService instance
	@Autowired
	PetService petService;
	
	@Autowired
	ClientService clientService;

	@PreAuthorize("hasAuthority('LIST_APPOINTMENTS')")
	@GetMapping
	public String listAppointments(Model model) {
		List<Appointment> appointments = appointmentService.getAppointments();
		model.addAttribute("appointments", appointments);
		return "appointments/listAppointments";
	}
	
	@PreAuthorize("hasAuthority('GET_APPOINTMENT')")
	@GetMapping("/{id}")
	public String getAppointment(@PathVariable("id") String id,
						 Model model,
						 @RequestParam(name="pet_id", required=false) Integer pet_id,
						 @RequestParam(name="saved", required = false) boolean saved) {

		model.addAttribute("fromPetPage", pet_id != null);
        model.addAttribute("saved", saved);

		AppointmentCommand appointmentCommand;

		if(id.equals("new")) {
            // if the id is 'new' then we create a pet command that only has the client id filled in
			appointmentCommand = new AppointmentCommand();
			
		} else {
			
            Appointment appointment = appointmentService.getAppointment(id);
     
            appointmentCommand = new AppointmentCommand(appointment);
            appointmentCommand.setPetId(appointmentCommand.getPetId());
            appointmentCommand.setApptTime(appointmentCommand.getApptTime());
            appointmentCommand.setApptDate(appointmentCommand.getApptDate());
            appointmentCommand.setApptType(appointmentCommand.getApptType());
            
    		Pet pet = petService.getPet(pet_id.toString());
    		Client client = pet.getClient();
    		appointmentCommand.setPet(pet);
    		appointmentCommand.setClient(client);
    		
    		model.addAttribute("saved2", saved);
		}
		
		// we add the command pet command instance to the mode (which has the client instance as well as the pet info)
		model.addAttribute("command", appointmentCommand);
		return "appointments/editAppointment";
	}
	
	
	@PreAuthorize("hasAuthority('SAVE_APPOINTMENT')")
	@PostMapping
	 public String saveAppointment(AppointmentCommand command, 
			 RedirectAttributes redirectAttributes, boolean fromPetPage) {

	        // we pass in the pet command to the service to update or create a new pet
	        Appointment appointment = appointmentService.saveAppointment(command);

	        redirectAttributes.addAttribute("saved", true);
	        if(fromPetPage) {
	            redirectAttributes.addAttribute("pet_id", appointment.getPetId());
	        }
	        return "redirect:/appointments/";

	    }
	
	@PreAuthorize("hasAuthority('DELETE_APPOINTMENT')")
	@GetMapping("/{id}/delete")
	public String deleteAppointment(@PathVariable("id") String id,
							@RequestParam(name="client_id", required=false) Integer client_id,
							RedirectAttributes redirectAttributes) {

		//int cid = petService.getPet(id).getClientId();
	    // we pass the pet id to the service so it can delete the pet
		appointmentService.deleteAppointment(id);

		// a flag so the page we redirect to can tell that the delete was successful
		redirectAttributes.addFlashAttribute("deleted", true);

//		if(clientId != null){
//            // if a client id was passed in, then we redirect to the client edit page
//			return "redirect:/clients/"+clientId;
//		}
		
		// otherwise we redirect to the petslisting page
		return "redirect:/appointments/";

	}
	

}
