CREATE TABLE users 
(
	user_id INTEGER NOT NULL PRIMARY KEY,
	user_name VARCHAR(64) NOT NULL,
	user_password VARCHAR(254) NOT NULL,
	CONSTRAINT users_unique_name UNIQUE(user_id)

);





