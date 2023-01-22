package com.gl.ticket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gl.ticket.entity.Ticket;
import com.gl.ticket.service.TicketService;

@Controller
public class TicketController {

	@Autowired
	private TicketService ticketservice;

	public TicketController(TicketService ticketservice) {
		super();
		this.ticketservice = ticketservice;
	}

	// handler method to handle list Tickets and return mode and view
	@GetMapping("/tickets")
	public String listTickets(Model model) {
		model.addAttribute("tickets", ticketservice.getAllTickets());
		return "tickets";
	}

	@GetMapping("/tickets/new")
	public String createTicketForm(Model model) {

		// create Ticket object to hold Ticket form data
		Ticket Ticket = new Ticket();
		model.addAttribute("ticket", Ticket);
		return "create_ticket";

	}

	@PostMapping("/tickets")
	public String saveTicket(@ModelAttribute("Ticket") Ticket Ticket) {
		ticketservice.saveTicket(Ticket);
		return "redirect:/tickets";
	}

	@GetMapping("/tickets/edit/{id}")
	public String editTicketForm(@PathVariable Long id, Model model) {
		model.addAttribute("ticket", ticketservice.getTicketById(id));
		return "edit_ticket";
	}

	@PostMapping("/tickets/{id}")
	public String updateTicket(@PathVariable Long id, @ModelAttribute("ticket") Ticket Ticket, Model model) {

		// get Ticket from database by id
		Ticket existingTicket = ticketservice.getTicketById(id);
		// existingTicket.setId(id);
		existingTicket.setTicket_title(Ticket.getTicket_title());
		existingTicket.setTicket_description(Ticket.getTicket_description());
		existingTicket.setTicket_content(Ticket.getTicket_content());
		// save updated Ticket object
		ticketservice.updateTicket(existingTicket);
		return "redirect:/tickets";
	}

	// handler method to handle delete Ticket request

	@GetMapping("/tickets/{id}")
	public String deleteTicket(@PathVariable Long id) {
		ticketservice.deleteTicketById(id);
		return "redirect:/tickets";
	}

	@GetMapping("/tickets/view/{id}")
	public String viewTicketForm(@PathVariable Long id, Model model) {
		model.addAttribute("ticket", ticketservice.getTicketById(id));
		return "view_ticket";
	}

	@GetMapping("/tickets/search")
	public String searchTicket(Model model, String Keyword) {
		List<Ticket> ticketList = ticketservice.searchTicket(Keyword);
		model.addAttribute("tickets", ticketList);
		return "search_ticket";
	}

}
