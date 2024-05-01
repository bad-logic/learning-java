package designPatterns.labs.lab02.observers;

import designPatterns.labs.lab02.Event;
import designPatterns.labs.lab02.Observer;

public class EmailSender implements Observer {
    /**
     *
     */
    @Override
    public void callBack(Event event) {
        if(event == Event.ACCOUNT_CREATION){
            System.out.println("OBSERVER:EmailSender:Account Created");
        }
    }
}
