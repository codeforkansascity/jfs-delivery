-- Setup script for local PostgreSQL database
-- Run this as the postgres user or a user with database creation privileges

-- Create the database (run this first)
CREATE DATABASE delivery_db;

-- Connect to the delivery_db database, then run these commands:

-- Create the deliveries table
CREATE TABLE IF NOT EXISTS deliveries (
    id BIGSERIAL PRIMARY KEY,
    customer_name VARCHAR(255) NOT NULL,
    address TEXT NOT NULL,
    status VARCHAR(50) DEFAULT 'PENDING',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Insert sample data
INSERT INTO deliveries (customer_name, address, status) VALUES
    ('John Doe', '123 Main St, Anytown, USA', 'PENDING'),
    ('Jane Smith', '456 Oak Ave, Somewhere, USA', 'IN_TRANSIT'),
    ('Bob Johnson', '789 Pine Rd, Elsewhere, USA', 'DELIVERED')
ON CONFLICT DO NOTHING;

-- Verify the table was created
SELECT * FROM deliveries; 