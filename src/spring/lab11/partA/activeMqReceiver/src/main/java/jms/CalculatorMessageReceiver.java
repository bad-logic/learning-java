package jms;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CalculatorMessageReceiver {
    @Autowired
    private Calculator calculator;
    CalculatorMessageReceiver(Calculator calculator){
        this.calculator = calculator;
    }

    @JmsListener(destination = "calcQueue")
    public void receiveMessage(final String opAsString) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            CalculatorOperation op = objectMapper.readValue(opAsString, CalculatorOperation.class);
            int result = this.calculator.operate(op.getOperation(),op.getOperand());
            System.out.println("performed: " + op.getOperation() +" "+ op.getOperand()+" = "+ result);
        } catch (IOException e) {
            System.out.println("JMS receiver: Cannot convert : " + opAsString+" to a CalculatorOperation object");
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
