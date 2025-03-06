-- check if the restaurant table exist and if exist drop it
DROP TABLE IF EXISTS transaction_log;
DROP TABLE IF EXISTS menus cascade;
DROP TABLE IF EXISTS restaurant;
DROP TABLE IF EXISTS locations;
DROP TABLE IF EXISTS owners;


CREATE TABLE locations (
                           id SERIAL PRIMARY KEY,
                           address VARCHAR(255),
                           city VARCHAR(100),
                           province VARCHAR(100),
                           post_code VARCHAR(20),
                           country VARCHAR(100),
                           created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                           updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE users (
                        id SERIAL PRIMARY KEY,
                        username VARCHAR(100) UNIQUE NOT NULL,
                        password VARCHAR(255) NOT NULL,
                        role VARCHAR(50),
                        created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                        updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX idx_user_username ON users(username);


CREATE TABLE restaurant (
                            id SERIAL PRIMARY KEY,
                            restaurant_name VARCHAR(255) NOT NULL,
                            location_id INT REFERENCES locations(id) ON DELETE CASCADE,
                            user_id INT REFERENCES users(id) ON DELETE CASCADE,
                            imageUrl VARCHAR(255),
                            selectedAmount INT DEFAULT 0,
                            created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                            updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX idx_restaurants_name ON restaurant(restaurant_name);
CREATE INDEX idx_restaurants_location ON restaurant(location_id);

CREATE TABLE menus (
                       id SERIAL PRIMARY KEY,
                       menu_name VARCHAR(255) NOT NULL,
                       restaurant_id INT REFERENCES restaurant(id) ON DELETE CASCADE,
                       imageUrl VARCHAR(255),
                       ai_generated BOOLEAN DEFAULT FALSE,
                       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                       updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX idx_menu_name ON menus(menu_name);



CREATE TABLE transaction_log (
                                 id SERIAL PRIMARY KEY,
                                 menu_id INT REFERENCES menus(id) ON DELETE CASCADE,
                                 response TEXT,
                                 created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);



-- Create triggers to update the updated_at column
CREATE OR REPLACE FUNCTION update_updated_at_column()
RETURNS TRIGGER AS $$
BEGIN
    NEW.updated_at = NOW();
RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER update_locations_updated_at
    BEFORE UPDATE ON locations
    FOR EACH ROW
    EXECUTE FUNCTION update_updated_at_column();

CREATE TRIGGER update_user_updated_at
    BEFORE UPDATE ON users
    FOR EACH ROW
    EXECUTE FUNCTION update_updated_at_column();

CREATE TRIGGER update_menus_updated_at
    BEFORE UPDATE ON menus
    FOR EACH ROW
    EXECUTE FUNCTION update_updated_at_column();

CREATE TRIGGER update_restaurants_updated_at
    BEFORE UPDATE ON restaurant
    FOR EACH ROW
    EXECUTE FUNCTION update_updated_at_column();
