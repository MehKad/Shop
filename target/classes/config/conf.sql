-- Create the shop database
CREATE DATABASE IF NOT EXISTS SHOP;

-- Switch to the shop database
USE SHOP;

-- Create the users table
CREATE TABLE IF NOT EXISTS USERS (
   USERNAME VARCHAR(30) PRIMARY KEY,
   PASSWORD VARCHAR(30)
);

-- Insert dummy data into the users table
INSERT INTO USERS (
   USERNAME,
   PASSWORD
) VALUES (
   'user1',
   'password1'
),
(
   'user2',
   'password2'
),
(
   'user3',
   'password3'
);

-- Create the items table
CREATE TABLE IF NOT EXISTS ITEMS (
   NAME VARCHAR(30),
   DESCRIPTION VARCHAR(100),
   PRICE DECIMAL(10, 2)
);

-- Insert dummy data into the items table
INSERT INTO ITEMS (
   NAME,
   DESCRIPTION,
   PRICE
) VALUES (
   'Laptop',
   'High-end laptop',
   1500.00
),
(
   'Headphones',
   'Wireless headphones',
   100.00
),
(
   'Smartphone',
   'Latest smartphone model',
   800.00
),
(
   'Tablet',
   'Lightweight tablet',
   500.00
),
(
   'Smartwatch',
   'Fitness smartwatch',
   200.00
),
(
   'Bluetooth Speaker',
   'Portable speaker',
   80.00
),
(
   'Gaming Console',
   'Next-gen gaming console',
   400.00
),
(
   '4K TV',
   'Ultra HD television',
   1200.00
),
(
   'Camera',
   'Digital camera with zoom lens',
   600.00
),
(
   'Wireless Mouse',
   'Ergonomic mouse',
   30.00
);