package soap;


import generated.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class CalculatorEndpoint {

    @Autowired
    Calculator calculator;
    private static final String NAMESPACE_URI = "http://springtraining/calculator";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "AddRequest")
    @ResponsePayload
    public AddResponse add(@RequestPayload AddRequest request) {
        AddResponse response = new AddResponse();
        int calcresult= calculator.add(request.getNumber1(),
                request.getNumber2());
        response.setResult(calcresult);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "SubtractRequest")
    @ResponsePayload
    public SubtractResponse add(@RequestPayload SubtractRequest request) {
        SubtractResponse response = new SubtractResponse();
        int calcresult= calculator.subtract(request.getNumber1(),
                request.getNumber2());
        response.setResult(calcresult);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "MultiplyRequest")
    @ResponsePayload
    public MultiplyResponse add(@RequestPayload MultiplyRequest request) {
        MultiplyResponse response = new MultiplyResponse();
        int calcresult= calculator.multiply(request.getNumber1(),
                request.getNumber2());
        response.setResult(calcresult);
        return response;
    }


}
