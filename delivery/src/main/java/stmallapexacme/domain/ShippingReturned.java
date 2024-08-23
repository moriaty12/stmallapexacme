package stmallapexacme.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import stmallapexacme.domain.*;
import stmallapexacme.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class ShippingReturned extends AbstractEvent {

    private Long id;
    private String orderId;
    private String userId;
    private String productName;
    private Integer qty;
    private Date deliveryDt;
    private String status;

    public ShippingReturned(Delivery aggregate) {
        super(aggregate);
    }

    public ShippingReturned() {
        super();
    }
}
//>>> DDD / Domain Event
