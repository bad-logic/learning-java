package com.example.partB.integrations;

public interface IEmailSender {
	void sendEmail(String email, String message);
	String getOutgoingMailServer();
}