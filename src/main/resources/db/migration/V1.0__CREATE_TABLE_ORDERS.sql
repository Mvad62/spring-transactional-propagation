CREATE TABLE IF NOT EXISTS orders
(
    id           BIGSERIAL PRIMARY KEY,
    product_name VARCHAR,
    quantity     INT
);