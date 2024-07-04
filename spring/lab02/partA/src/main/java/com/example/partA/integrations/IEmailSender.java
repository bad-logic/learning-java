package com.example.partA.integrations;

public interface IEmailSender {
	void sendEmail(String email, String message);
	String getOutgoingMailServer();
}