-- use classicmodels;
-- CREATE VIEW customer_views AS
-- SELECT customerNumber, customerName, phone
-- FROM  customers;
select * from customer_views;
CREATE OR REPLACE VIEW customer_views AS
-- Cập nhật view customer_views: 
SELECT customerNumber, customerName, contactFirstName, contactLastName, phone
FROM customers
WHERE city = 'Nantes';
-- Xoá view
DROP VIEW customer_views; 