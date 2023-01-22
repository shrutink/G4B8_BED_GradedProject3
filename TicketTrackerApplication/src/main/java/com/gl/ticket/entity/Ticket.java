package com.gl.ticket.entity;



import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

@Entity
@Table(name = "ticket")
public class Ticket {
	
	public Ticket() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Ticket(Long id, String ticket_title, String ticket_description, String ticket_content,
			Date ticket_createdon) {
		super();
		this.id = id;
		this.ticket_title = ticket_title;
		this.ticket_description = ticket_description;
		this.ticket_content = ticket_content;
		this.ticket_createdon = ticket_createdon;
	}

	@Override
	public String toString() {
		return "Ticket [id=" + id + ", ticket_title=" + ticket_title + ", ticket_description=" + ticket_description
				+ ", ticket_content=" + ticket_content + ", ticket_createdon=" + ticket_createdon + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTicket_title() {
		return ticket_title;
	}

	public void setTicket_title(String ticket_title) {
		this.ticket_title = ticket_title;
	}

	public String getTicket_description() {
		return ticket_description;
	}

	public void setTicket_description(String ticket_description) {
		this.ticket_description = ticket_description;
	}

	public String getTicket_content() {
		return ticket_content;
	}

	public void setTicket_content(String ticket_content) {
		this.ticket_content = ticket_content;
	}

	public Date getTicket_createdon() {
		return ticket_createdon;
	}

	public void setTicket_createdon(Date ticket_createdon) {
		this.ticket_createdon = ticket_createdon;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "ticket_title", nullable = false)
	private String ticket_title;
	
	@Column(name = "ticket_description", nullable = false)
	private String ticket_description;

	@Column(name = "ticket_content", nullable = false)
	private String ticket_content;
	
	
	@CreationTimestamp
	@Column(name = "ticket_createdon", nullable = false, updatable = false)
	private Date ticket_createdon;


}
