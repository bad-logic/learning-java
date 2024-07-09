package jms;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;



@SpringBootApplication
@EnableJms
public class SpringJmsPersonSenderApplication implements CommandLineRunner {
	@Autowired
	JmsTemplate jmsTemplate;


	public static void main(String[] args)  {
		ConfigurableApplicationContext context = SpringApplication.run(SpringJmsPersonSenderApplication.class, args);
		context.close();
	}

	@Override
	public void run(String... args) throws Exception {
		Person person = new Person("Frank", "Brown");
		//convert person to JSON string
		ObjectMapper objectMapper = new ObjectMapper();
		String personAsString = objectMapper.writeValueAsString(person);

		System.out.println("Sending a JMS message:" + personAsString);
		jmsTemplate.convertAndSend("testQueue",personAsString);

		CalculatorOperation op1 = new CalculatorOperation("+",5);
		CalculatorOperation op2 = new CalculatorOperation("-",3);
		CalculatorOperation op3 = new CalculatorOperation("*", 4);
		CalculatorOperation op4 = new CalculatorOperation("+",5);

		String op1s = objectMapper.writeValueAsString(op1);
		jmsTemplate.convertAndSend("calcQueue",op1s);
		System.out.println("Sending a JMS message:" + op1s);

		String op2s = objectMapper.writeValueAsString(op2);
		jmsTemplate.convertAndSend("calcQueue",op2s);
		System.out.println("Sending a JMS message:" + op2s);

		String op3s = objectMapper.writeValueAsString(op3);
		jmsTemplate.convertAndSend("calcQueue",op3s);
		System.out.println("Sending a JMS message:" + op3s);

		String op4s = objectMapper.writeValueAsString(op4);
		jmsTemplate.convertAndSend("calcQueue",op4s);
		System.out.println("Sending a JMS message:" + op4s);
	}

}
