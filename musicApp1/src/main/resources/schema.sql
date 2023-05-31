CREATE TABLE music(
id INT auto_increment primary key,
song VARCHAR(255) NOT NULL,
artist VARCHAR(255) NOT NULL,
genre VARCHAR(255),
url VARCHAR(255),
likes INT DEFAULT 1
);