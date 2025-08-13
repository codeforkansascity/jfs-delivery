// Alpine.js data and functions for the delivery app
function deliveryApp() {
    return {
        message: 'Hello World!',
        count: 0,
        deliveries: [],
        loading: false,
        
        async init() {
            await this.loadDeliveries();
        },
        
        updateMessage() {
            this.message = 'Hello from Alpine.js!';
        },
        
        increment() {
            this.count++;
        },
        
        async loadDeliveries() {
            this.loading = true;
            try {
                const response = await fetch('/api/deliveries');
                this.deliveries = await response.json();
            } catch (error) {
                console.error('Error loading deliveries:', error);
            } finally {
                this.loading = false;
            }
        },
        
        async createDelivery() {
            const customerName = prompt('Enter customer name:');
            const address = prompt('Enter delivery address:');
            
            if (customerName && address) {
                try {
                    const response = await fetch('/api/deliveries', {
                        method: 'POST',
                        headers: {
                            'Content-Type': 'application/x-www-form-urlencoded',
                        },
                        body: `customerName=${encodeURIComponent(customerName)}&address=${encodeURIComponent(address)}`
                    });
                    
                    if (response.ok) {
                        await this.loadDeliveries();
                        alert('Delivery created successfully!');
                    }
                } catch (error) {
                    console.error('Error creating delivery:', error);
                    alert('Error creating delivery');
                }
            }
        },
        
        async updateStatus(id, currentStatus) {
            const newStatus = prompt('Enter new status (PENDING, IN_TRANSIT, DELIVERED):', currentStatus);
            
            if (newStatus && newStatus !== currentStatus) {
                try {
                    const response = await fetch(`/api/deliveries/${id}/status?status=${encodeURIComponent(newStatus)}`, {
                        method: 'PUT'
                    });
                    
                    if (response.ok) {
                        await this.loadDeliveries();
                        alert('Status updated successfully!');
                    }
                } catch (error) {
                    console.error('Error updating status:', error);
                    alert('Error updating status');
                }
            }
        },
        
        getStatusClass(status) {
            return `status-${status.toLowerCase().replace(' ', '_')}`;
        }
    }
} 