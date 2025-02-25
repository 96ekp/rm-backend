-- create restaurant table
CREATE TABLE restaurants(
    id SERIAL PRIMARY KEY,
    restaurant_name VARCHAR(50) NOT NULL UNIQUE ,
    selected_amount INT NOT NULL DEFAULT 0
);

--  index
CREATE INDEX idx_restaurant_name ON restaurants(restaurant_name);
