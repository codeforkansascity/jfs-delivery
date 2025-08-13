package org.jfs.delivery.repository;

import org.jfs.delivery.model.Delivery;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeliveryRepository extends CrudRepository<Delivery, Long> {
    
    @Query("SELECT * FROM deliveries WHERE status = :status")
    List<Delivery> findByStatus(@Param("status") String status);
    
    @Query("SELECT * FROM deliveries WHERE customer_name ILIKE :customerName")
    List<Delivery> findByCustomerNameContaining(@Param("customerName") String customerName);
} 