INSERT INTO users(first_name, last_name, email) VALUES('Isela', 'Pimentel', 'iselita@gmail.com');
INSERT INTO users(first_name, last_name, email) VALUES('Lidia', 'Vélez', 'lidia@gmail.com');
INSERT INTO users(first_name, last_name, email) VALUES('Belén', 'Vélez', 'belen@gmail.com');
INSERT INTO users(first_name, last_name, email) VALUES('Betania', 'Cobeñas', 'betania@gmail.com');

INSERT INTO customers(name, phone) VALUES('Martín', '854785969');
INSERT INTO customers(name, phone) VALUES('Gahella', '111425418');

INSERT INTO invoices(customer_id, number, total, create_at) VALUES(1, 'F01-001', 250.0, '2023-05-05');
INSERT INTO invoices(customer_id, number, total, create_at) VALUES(1, 'F01-002', 360.0, '2023-05-06');
INSERT INTO invoices(customer_id, number, total, create_at) VALUES(1, 'F01-003', 750.0, '2023-05-07');
INSERT INTO invoices(customer_id, number, total, create_at) VALUES(2, 'F01-003', 120.0, '2023-05-07');
INSERT INTO invoices(customer_id, number, total, create_at) VALUES(2, 'F01-003', 190.0, '2023-05-07');

INSERT INTO addresses(customer_id, street, country) VALUES(1, 'Las Palmeras', 'Perú');
INSERT INTO addresses(customer_id, street, country) VALUES(2, 'Las Ponceanas', 'Perú');