package com.gl.ticket.service;

import java.util.List;

import com.gl.ticket.entity.Ticket;

public interface TicketService {
	List<Ticket> getAllTickets();

	Ticket saveTicket(Ticket employee);

	Ticket getTicketById(Long id);

	Ticket updateTicket(Ticket ticket);

	void deleteTicketById(Long id);

	List<Ticket> searchTicket(String ticketTitle);

}
