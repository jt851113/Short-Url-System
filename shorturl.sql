-- 創建資料庫
CREATE DATABASE shorturldb;

-- 使用 shorturldb 資料庫
USE shorturldb;

-- 創建 url_db 表格
CREATE TABLE url_db (
                        id INT PRIMARY KEY AUTO_INCREMENT,
                        short_url VARCHAR(6),
                        original_url VARCHAR(255),
                        user_id INT,
                        creation_date DATETIME,
                        expiration_date DATETIME
);