package com.fdmgroup.Message;

import java.sql.Date;

public class Message {

	private String senderUsername;
	private String messages;
	private Date dateNTime;
	
	public Message(){
		
	}
	
	public Message(String senderID, String messages, Date dateNTime) {
		this.senderUsername = senderID;
		this.messages = messages;
		this.dateNTime = dateNTime;
	}

	public String getSenderUsername() {
		return senderUsername;
	}

	public void setSenderUsername(String senderUsername) {
		this.senderUsername = senderUsername;
	}

	public String getMessages() {
		return messages;
	}

	public void setMessages(String messages) {
		this.messages = messages;
	}

	public Date getDateNTime() {
		return dateNTime;
	}

	public void setDateNTime(Date dateNTime) {
		this.dateNTime = dateNTime;
	}
	
}
