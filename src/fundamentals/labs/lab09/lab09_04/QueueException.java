package fundamentals.labs.lab09.lab09_04;

@SuppressWarnings("serial")
public class QueueException extends Exception {
    public QueueException() {
        super();
    }
    public QueueException(String msg) {
        super(msg);
    }
    public QueueException(Throwable t) {
        super(t);
    }
}