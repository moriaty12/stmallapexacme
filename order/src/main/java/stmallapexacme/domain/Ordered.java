package stmallapexacme.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import stmallapexacme.domain.*;
import stmallapexacme.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class Ordered extends AbstractEvent {

    private Long id;
    private String userId;
    private String productName;
    private String productId;
    private String qty;
    private String producName;
    private Integer qty;
    private Date orderDt;
    private String status;
    private String address;
    private String address;
    private String orderId;

    public Ordered(Order aggregate) {
        super(aggregate);
    }

    public Ordered() {
        super();
    }
}
//>>> DDD / Domain Event
