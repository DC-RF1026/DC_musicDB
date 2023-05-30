CREATE TABLE music(
id INT PRIMARY KEY AUTOINCREMENT,
song VARCHAR(255) NOT NULL,
artist VARCHAR(255) NOT NULL,
acosticness DECIMAL,
danceability DECIMAL,
energy DECIMAL,
instrumentalness DECIMAL,
liveness DECIMAL,
loudness DECIMAL,
tempo DECIMAL,
link VARCHAR(255),
genre VARCHAR(255));
