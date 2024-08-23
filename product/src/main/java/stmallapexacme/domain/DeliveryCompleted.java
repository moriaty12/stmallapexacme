package stmallapexacme.domain;

import java.util.*;
import lombok.*;
import stmallapexacme.domain.*;
import stmallapexacme.infra.AbstractEvent;

@Data
@ToString
public class DeliveryCompleted extends AbstractEvent {

    private Long id;
    private String orderId;
    private String userId;
    private String productName;
    private Integer qty;
    private Date deliveryDt;
    private String status;
}
