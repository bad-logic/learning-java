package bank.jms;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class JMSSender implements IJMSSender{

	@Autowired
	JmsTemplate jmsTemplate;

	public JMSSender(JmsTemplate jmsTemplate){
		this.jmsTemplate = jmsTemplate;
	}
	
	public void sendJMSMessage (String text){
		System.out.println("sending message to the message broker: "+text);
		jmsTemplate.convertAndSend("BankQueue",text);
	}

}
