CREATE TABLE users 
(
user_id INTEGER NOT NULL,
login_name VARCHAR(64) NOT NULL,
user_password VARCHAR(254 ) NOT NULL,
CONSTRAINT pk_users PRIMARY KEY(user_id),
CONSTRAINT users_unique_name UNIQUE(user_id)

);





