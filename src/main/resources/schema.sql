-- Create deliveries table for Spring Data JDBC demo
CREATE TABLE IF NOT EXISTS deliveries (
    id BIGSERIAL PRIMARY KEY,
    customer_name VARCHAR(255) NOT NULL,
    address TEXT NOT NULL,
    status VARCHAR(50) DEFAULT 'PENDING',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Insert some sample data
INSERT INTO deliveries (customer_name, address, status) VALUES
    ('John Doe', '123 Main St, Anytown, USA', 'PENDING'),
    ('Jane Smith', '456 Oak Ave, Somewhere, USA', 'IN_TRANSIT'),
    ('Bob Johnson', '789 Pine Rd, Elsewhere, USA', 'DELIVERED')
ON CONFLICT DO NOTHING; 