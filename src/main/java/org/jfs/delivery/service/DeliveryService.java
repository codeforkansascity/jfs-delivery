/*
package org.jfs.delivery.service;

import org.jfs.delivery.model.Delivery;
import org.jfs.delivery.repository.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeliveryService {
    
    private final DeliveryRepository deliveryRepository;
    
    @Autowired
    public DeliveryService(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }
    
    public Delivery createDelivery(String customerName, String address) {
        Delivery delivery = new Delivery(customerName, address);
        return deliveryRepository.save(delivery);
    }
    
    public List<Delivery> getAllDeliveries() {
        return (List<Delivery>) deliveryRepository.findAll();
    }
    
    public Optional<Delivery> getDeliveryById(Long id) {
        return deliveryRepository.findById(id);
    }
    
    public List<Delivery> getDeliveriesByStatus(String status) {
        return deliveryRepository.findByStatus(status);
    }
    
    public List<Delivery> searchByCustomerName(String customerName) {
        return deliveryRepository.findByCustomerNameContaining(customerName);
    }
    
    public Delivery updateDeliveryStatus(Long id, String status) {
        Optional<Delivery> optionalDelivery = deliveryRepository.findById(id);
        if (optionalDelivery.isPresent()) {
            Delivery delivery = optionalDelivery.get();
            delivery.setStatus(status);
            return deliveryRepository.save(delivery);
        }
        throw new RuntimeException("Delivery not found with id: " + id);
    }
}
*/ 