DROP TABLE IF EXISTS customers;

CREATE TABLE customers (
                           id BIGINT PRIMARY KEY,
                           name VARCHAR(100) NOT NULL,
                           status VARCHAR(20) NOT NULL,
                           balance DECIMAL(12, 2) NOT NULL
);