package com.podio.integration.freshdesk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.podio.integration.freshdesk.bean.Contact;
import com.podio.integration.freshdesk.bean.Ticket;
import com.podio.integration.freshdesk.services.FreshdeskService;
import com.podio.integration.freshdesk.services.PodioService;

@RestController
public class FreshdeskController {
	
	@Autowired
	public FreshdeskService freshdeskService;
	
	@Autowired
	public PodioService podioService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String hello() {
		return "Good morning";
	}
	
	@RequestMapping(value = "/contacts", method = RequestMethod.GET)
	public List<Contact> getAllContacts(){
		System.out.println("Inside getAllContact");
		Object object = freshdeskService.getAllContacts();
		List<Contact> conatcts = (List<Contact>) object;
		return conatcts;
	}
	
	@RequestMapping(value = "/contacts/{id}", method = RequestMethod.GET)
	public Contact getCurrentContact(@PathVariable("id") long id) {
		System.out.println("Inside getCurrentContact");
		Object object = freshdeskService.getCurrentContact(id);
		Contact contact = (Contact) object;
//		podioService.getRequesterFields(contact);
		podioService.updateRequester(contact);
		return contact;
	}
	
	@RequestMapping(value = "/tickets", method = RequestMethod.GET)
	public List<Ticket> getAllTicket(){
		System.out.println("inside getAllTicket");
		Object object = freshdeskService.getAllTickets();
		List<Ticket> tickets = (List<Ticket>) object;
		return tickets;
	}
	
	@RequestMapping(value = "/tickets/{id}", method = RequestMethod.GET)
	public Ticket getTicket(@PathVariable("id") long id){
		System.out.println("inside getAllTicket");
		Object object = freshdeskService.getTicket(id);
		Ticket ticket = (Ticket) object;
		return ticket;
	}
}
