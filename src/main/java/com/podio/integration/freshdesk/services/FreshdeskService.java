package com.podio.integration.freshdesk.services;

import java.nio.charset.Charset;
import java.util.Base64;
import java.util.Collections;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import com.podio.integration.freshdesk.bean.Contact;
import com.podio.integration.freshdesk.bean.Ticket;

@Service
public class FreshdeskService {
	
	public List<Contact> getAllContacts(){
		
		final String uri = "https://artis-akshay.freshdesk.com/api/v2/contacts";
		RestTemplate template = new RestTemplate();
		HttpEntity<String> entity = new HttpEntity<String>(createHeader());
		ResponseEntity<List<Contact>> result = template.exchange(uri, HttpMethod.GET, entity, new ParameterizedTypeReference<List<Contact>>() {
			
		});
		return result.getBody();
	}
	
	public Contact getCurrentContact(long id) {
		final String uri = "https://artis-akshay.freshdesk.com/api/v2/contacts/" + id;
		RestTemplate template = new RestTemplate();
		HttpEntity<String> entity = new HttpEntity<String>(createHeader());
		ResponseEntity<Contact> result = template.exchange(uri, HttpMethod.GET, entity, new ParameterizedTypeReference<Contact>() {
			
		});
		return result.getBody();
	}
	
	public List<Ticket> getAllTickets() {
		final String uri = "https://artis-akshay.freshdesk.com/api/v2/tickets";
		RestTemplate template = new RestTemplate();
		HttpEntity<String> entity = new HttpEntity<>(createHeader());
		ResponseEntity<List<Ticket>> result = template.exchange(uri, HttpMethod.GET, entity, new ParameterizedTypeReference<List<Ticket>>() {
			
		});
		return result.getBody();
	}
	
	public Ticket getTicket(long id) {
		final String uri = "https://artis-akshay.freshdesk.com/api/v2/tickets/" + id;	
		RestTemplate template = new RestTemplate();
		HttpEntity<String> entity = new HttpEntity<String>(createHeader());
		ResponseEntity<Ticket> result = template.exchange(uri, HttpMethod.GET, entity, new ParameterizedTypeReference<Ticket>(){
			
		});
		return result.getBody();
		
	}
	
	private HttpHeaders createHeader() {
		HttpHeaders headers = new HttpHeaders();
		String auth = "akshaykulkarni239@rediffmail.com" + ":" + "Artissol@123";
		byte[] encodedAuth = Base64.getEncoder().encode(auth.getBytes(Charset.forName("US-ASCII")));
		String authHeader = "Basic " + new String(encodedAuth);

		headers.add("Authorization", authHeader);
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		return headers;
		
	}
}
