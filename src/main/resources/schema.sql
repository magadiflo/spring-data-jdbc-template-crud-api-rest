DROP TABLE IF EXISTS users;

CREATE TABLE users(
    id BIGINT(20) AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    CONSTRAINT uk_email UNIQUE(email)
);

DROP TABLE IF EXISTS addresses;
DROP TABLE IF EXISTS invoices;
DROP TABLE IF EXISTS customers;

CREATE TABLE customers(
    id BIGINT(20) AUTO_INCREMENT,
    name VARCHAR(200) NOT NULL,
    phone VARCHAR(20) NULL,
    PRIMARY KEY (id)
);

CREATE TABLE invoices(
    id BIGINT(20) AUTO_INCREMENT,
    customer_id BIGINT(20) NOT NULL,
    number VARCHAR(20) NOT NULL,
    total DOUBLE DEFAULT 0,
    create_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY(id),
    CONSTRAINT fk_customers_invoices FOREIGN KEY(customer_id) REFERENCES customers(id)
);

CREATE TABLE addresses(
    id BIGINT(20) AUTO_INCREMENT PRIMARY KEY,
    customer_id BIGINT(20) NOT NULL,
    street VARCHAR(100) NOT NULL,
    country VARCHAR(45) NOT NULL,
    CONSTRAINT fk_customers_addresses FOREIGN KEY(customer_id) REFERENCES customers(id),
    CONSTRAINT uk_fk_customer_id UNIQUE(customer_id)
);