package designPatterns.labs.lab02;

public interface Observer {
    default void subscribe(Subject sub){
        sub.registerObserver(this);
    }

    default void unsubscribe(Subject sub){
        sub.removeObserver(this);
    }

    void callBack(Event event);

}
