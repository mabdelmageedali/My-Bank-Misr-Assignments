use ecommerce_db;

insert into users (username, email, password_hash, first_name, last_name, is_admin) values
('admin_ahmed', 'ahmed.admin@example.com', '$2a$10$xJwL5v5Jz5U5Jz5U5Jz5UOe5U5Jz5U5Jz5U5Jz5U5Jz5U5Jz5U5Jz5U', 'Ahmed', 'El-Masry', true),
('shopper_amira', 'amira.shopper@example.com', '$2a$10$xJwL5v5Jz5U5Jz5U5Jz5UOe5U5Jz5U5Jz5U5Jz5U5Jz5U5Jz5U5Jz5U', 'Amira', 'Fouad', false),
('shopper_mohamed', 'mohamed.shopper@example.com', '$2a$10$xJwL5v5Jz5U5Jz5U5Jz5UOe5U5Jz5U5Jz5U5Jz5U5Jz5U5Jz5U5Jz5U', 'Mohamed', 'Ramadan', false);

insert into categories (name, description) values
('Electronics', 'Modern gadgets and devices'),
('Clothing', 'Traditional and modern Egyptian apparel'),
('Handicrafts', 'Authentic Egyptian handmade products');

insert into products (name, description, price, stock_quantity, category_id) values
('NilePhone Pro', 'Premium smartphone with Arabic support', 4500.00, 30, 1),
('Sphinx Wireless Earbuds', 'Noise-cancelling earbuds with pyramid design', 750.00, 50, 1),
('Galabeya (White)', 'Traditional Egyptian cotton garment', 350.00, 100, 2),
('Pharaoh Cotton T-Shirt', 'Premium cotton shirt with hieroglyphic design', 150.00, 200, 2),
('Cleopatra Smart Watch', 'Fitness tracker with ancient Egyptian motifs', 1200.00, 40, 1),
('Handmade Papyrus Art', 'Authentic Egyptian papyrus painting', 250.00, 30, 3),
('Silver Cartouche Pendant', 'Personalized hieroglyphic jewelry', 500.00, 25, 3);

insert into promotions (code, description, discount_percent, start_date, end_date) values
('SHAM20', 'Sham El-Nessim holiday 20% off', 20.00, '2023-04-17 00:00:00', '2023-04-20 23:59:59'),
('RAMADAN25', 'Ramadan Kareem 25% discount', 25.00, '2023-03-22 00:00:00', '2023-04-21 23:59:59');

insert into orders (user_id, total_amount, status, promotion_id) values
(2, 5100.00, 'delivered', 1),
(3, 850.00, 'processing', null);

insert into order_items (order_id, product_id, quantity, unit_price) values
(1, 1, 1, 4500.00),
(1, 5, 1, 1200.00),
(2, 3, 2, 350.00),
(2, 7, 1, 500.00);

insert into saved_carts (user_id, cart_data) values
(2, '{"items": [{"productId": 2, "quantity": 1}, {"productId": 4, "quantity": 2}], "total": 1050.00}'),
(3, '{"items": [{"productId": 6, "quantity": 3}], "total": 750.00}');