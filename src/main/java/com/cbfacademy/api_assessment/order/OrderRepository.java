package com.cbfacademy.api_assessment.order;

import java.util.UUID;
import org.springframework.data.repository.ListCrudRepository;

public interface OrderRepository extends ListCrudRepository<Order, UUID>{
    
}
