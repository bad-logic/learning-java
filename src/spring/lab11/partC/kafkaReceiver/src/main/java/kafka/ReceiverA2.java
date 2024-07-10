package kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class ReceiverA2 {
    @KafkaListener(topics = {"topicA2"})
    public void receive(@Payload String message) {
        System.out.println("ReceiverA2 received message= "+ message);
    }
}
