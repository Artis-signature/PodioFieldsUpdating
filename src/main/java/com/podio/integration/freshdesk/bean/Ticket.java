package com.podio.integration.freshdesk.bean;

import java.util.Date;

public class Ticket {
	
	private long email_config_id;
    private long group_id;
    private int priority;
    private long requester_id;
    private long responder_id;
    private long source;
    private long company_id;
    private int status;
    private String subject;
    private String to_emails;
    private long product_id;
    private int id;
    private String type;
    private Date due_by;
    private Date fr_due_by;
    private boolean is_escalated;
    private String description_text;
    private Date created_at;
    private Date updated_at;
    	
	public long getEmail_config_id() {
		return email_config_id;
	}
	public void setEmail_config_id(long email_config_id) {
		this.email_config_id = email_config_id;
	}
	public long getGroup_id() {
		return group_id;
	}
	public void setGroup_id(long group_id) {
		this.group_id = group_id;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public long getRequester_id() {
		return requester_id;
	}
	public void setRequester_id(long requester_id) {
		this.requester_id = requester_id;
	}
	public long getResponder_id() {
		return responder_id;
	}
	public void setResponder_id(long responder_id) {
		this.responder_id = responder_id;
	}
	public long getSource() {
		return source;
	}
	public void setSource(long source) {
		this.source = source;
	}
	public long getCompany_id() {
		return company_id;
	}
	public void setCompany_id(long company_id) {
		this.company_id = company_id;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getTo_emails() {
		return to_emails;
	}
	public void setTo_emails(String to_emails) {
		this.to_emails = to_emails;
	}
	public long getProduct_id() {
		return product_id;
	}
	public void setProduct_id(long product_id) {
		this.product_id = product_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getDue_by() {
		return due_by;
	}
	public void setDue_by(Date due_by) {
		this.due_by = due_by;
	}
	public Date getFr_due_by() {
		return fr_due_by;
	}
	public void setFr_due_by(Date fr_due_by) {
		this.fr_due_by = fr_due_by;
	}
	public boolean isIs_escalated() {
		return is_escalated;
	}
	public void setIs_escalated(boolean is_escalated) {
		this.is_escalated = is_escalated;
	}
	public String getDescription_text() {
		return description_text;
	}
	public void setDescription_text(String description_text) {
		this.description_text = description_text;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	public Date getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}
    
    

}
