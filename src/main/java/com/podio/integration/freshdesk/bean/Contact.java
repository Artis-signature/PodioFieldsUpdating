package com.podio.integration.freshdesk.bean;

public class Contact {
	
	private long id;
	private String name;
	private String email;
	private long requester_id;
	
	
	public long getRequester_id() {
		return requester_id;
	}
	public void setRequester_id(long requester_id) {
		this.requester_id = requester_id;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Contact [id=" + id + ", name=" + name + ", email=" + email + ", requesterId=" + requester_id + "]";
	}
	
	
	

}
