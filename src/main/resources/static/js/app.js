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