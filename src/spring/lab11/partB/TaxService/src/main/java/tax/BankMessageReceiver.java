package tax;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class BankMessageReceiver {

    @JmsListener(destination = "BankQueue")
    public void receive(String message){
        System.out.println("Received: "+message);
    }
}
