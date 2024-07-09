package kafka;


public class BankMessage {
    private MessageType message;
    private Object payload;

    public BankMessage(MessageType message, Object payload) {
        this.message = message;
        this.payload = payload;
    }

    public MessageType getMessage() {
        return message;
    }

    public void setMessage(MessageType message) {
        this.message = message;
    }

    public Object getPayload() {
        return payload;
    }

    public void setPayload(Object payload) {
        this.payload = payload;
    }

    @Override
    public String toString() {
        return "BankMessage{" +
                "message=" + message +
                ", payload=" + payload +
                '}';
    }
}
