CREATE TABLE IF NOT EXISTS url_db(
    id INT PRIMARY KEY AUTO_INCREMENT,
    short_url VARCHAR(6),
    original_url VARCHAR(255),
    user_id INT,
    creation_time DATE,
    expiration_time DATE
);