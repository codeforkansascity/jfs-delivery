package org.jfs.delivery.controller;

import org.jfs.delivery.model.Delivery;
import org.jfs.delivery.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/deliveries")
public class DeliveryController {
    
    private final DeliveryService deliveryService;
    
    @Autowired
    public DeliveryController(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }
    
    @GetMapping
    public List<Delivery> getAllDeliveries() {
        return deliveryService.getAllDeliveries();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Delivery> getDeliveryById(@PathVariable Long id) {
        return deliveryService.getDeliveryById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @PostMapping
    public Delivery createDelivery(@RequestParam String customerName, @RequestParam String address) {
        return deliveryService.createDelivery(customerName, address);
    }
    
    @PutMapping("/{id}/status")
    public Delivery updateStatus(@PathVariable Long id, @RequestParam String status) {
        return deliveryService.updateDeliveryStatus(id, status);
    }
    
    @GetMapping("/status/{status}")
    public List<Delivery> getDeliveriesByStatus(@PathVariable String status) {
        return deliveryService.getDeliveriesByStatus(status);
    }
} 