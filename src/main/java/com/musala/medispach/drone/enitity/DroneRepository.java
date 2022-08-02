package com.musala.medispach.drone.enitity;

import com.musala.medispach.deliveryItem.entity.DeliveryItem;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Optional;

@Repository
public interface DroneRepository extends CrudRepository<Drone,Long>{

    @Query(value = "select * " +
            "       from Drone " +
            "       where drn_state = :state" +
            "       and drn_batt_capcity > 25 " +
            "       limit 1 ",
            nativeQuery = true)
    Optional<Drone> getAvailableDrone(@Param("state") String state);


    @Query("Select d.batteryCapacity from Drone d where d.id = :drone")
    BigDecimal getDroneBatteryCapacity(@Param("drone") Drone drone);


    @Query(value = "select delivery_item.* " +
            "       from  " +
            "           drone,  " +
            "           delivery,  " +
            "           delivery_order,  " +
            "           delivery_item, " +
            "           medication " +
            "       where  " +
            "           drn_code =del_dr_code " +
            "       and del_do_id = do_id " +
            "       and do_id = item_do_id " +
            "       and med_id = item_med_id " +
            "       and drn_code = :v_drn_code", nativeQuery = true)
    Iterable<DeliveryItem> getDroneDeliveryItems(@Param("v_drn_code") long id);
}
