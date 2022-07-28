package com.musala.medispach.deliveryOrder;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryOrderRepository extends CrudRepository<DeliveryOrder,Long> {
}
