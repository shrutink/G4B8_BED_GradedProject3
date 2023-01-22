package com.gl.ticket.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import com.gl.ticket.entity.Ticket;
import com.gl.ticket.repository.TicketRepository;
import com.gl.ticket.service.TicketService;

@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	private TicketRepository ticketrepository;

	@Override
	public List<Ticket> getAllTickets() {
		return ticketrepository.findAll();
	}

	@Override
	public Ticket saveTicket(Ticket Ticket) {
		return ticketrepository.save(Ticket);
	}

	@Override
	public Ticket getTicketById(Long id) {
		return ticketrepository.findById(id).get();
	}

	@Override
	public Ticket updateTicket(Ticket Ticket) {
		return ticketrepository.save(Ticket);
	}

	@Override
	public void deleteTicketById(Long id) {
		ticketrepository.deleteById(id);
	}

	@Override
	public List<Ticket> searchTicket(String ticketTitle) {
		Ticket tickets = new Ticket();
		tickets.setTicket_title(ticketTitle);
		ExampleMatcher exampleMatcher = ExampleMatcher.matching()
				.withMatcher("ticketTitle", ExampleMatcher.GenericPropertyMatchers.contains())
				.withIgnorePaths("ticket_createdon", "ticket_content", "id");
		Example<Ticket> example = Example.of(tickets, exampleMatcher);
		// return ticketrepository.exists(example);
		return ticketrepository.findAll(example);
	}
}
