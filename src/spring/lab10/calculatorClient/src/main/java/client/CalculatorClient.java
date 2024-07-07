package client;

import generated.*;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class CalculatorClient extends WebServiceGatewaySupport {

	public int add(int num1, int num2) {
		AddRequest request = new AddRequest();
		request.setNumber1(num1);
		request.setNumber2(num2);
		
		AddResponse response = (AddResponse) getWebServiceTemplate().marshalSendAndReceive(request);
		return response.getResult();
	}

	public int subtract(int num1, int num2) {
		SubtractRequest request = new SubtractRequest();
		request.setNumber1(num1);
		request.setNumber2(num2);

		SubtractResponse response = (SubtractResponse) getWebServiceTemplate().marshalSendAndReceive(request);
		return response.getResult();
	}

	public int multiply(int num1, int num2) {
		MultiplyRequest request = new MultiplyRequest();
		request.setNumber1(num1);
		request.setNumber2(num2);

		MultiplyResponse response = (MultiplyResponse) getWebServiceTemplate().marshalSendAndReceive(request);
		return response.getResult();
	}
}


