package stmallapexacme.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import stmallapexacme.config.kafka.KafkaProcessor;
import stmallapexacme.domain.*;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    InventoryRepository inventoryRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='DeliveryCompleted'"
    )
    public void wheneverDeliveryCompleted_StockDecrease(
        @Payload DeliveryCompleted deliveryCompleted
    ) {
        DeliveryCompleted event = deliveryCompleted;
        System.out.println(
            "\n\n##### listener StockDecrease : " + deliveryCompleted + "\n\n"
        );

        // Sample Logic //
        Inventory.stockDecrease(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Ordered'"
    )
    public void wheneverOrdered_StockDecrease(@Payload Ordered ordered) {
        Ordered event = ordered;
        System.out.println(
            "\n\n##### listener StockDecrease : " + ordered + "\n\n"
        );

        // Sample Logic //
        Inventory.stockDecrease(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='ShippingReturned'"
    )
    public void wheneverShippingReturned_IncreaseStock(
        @Payload ShippingReturned shippingReturned
    ) {
        ShippingReturned event = shippingReturned;
        System.out.println(
            "\n\n##### listener IncreaseStock : " + shippingReturned + "\n\n"
        );

        // Sample Logic //
        Inventory.increaseStock(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
