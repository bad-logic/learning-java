package designPatterns.labs.lab02.observers;

import designPatterns.labs.lab02.Event;
import designPatterns.labs.lab02.Observer;

public class Logger implements Observer {
    /**
     *
     */
    @Override
    public void callBack(Event event) {
        if(event == Event.ACCOUNT_CHANGE){
            System.out.println("OBSERVER:Logger:Account Change");
        }
    }
}
