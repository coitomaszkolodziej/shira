CREATE TABLE roles(
	role_id INTEGER NOT NULL PRIMARY KEY,
	role_name VARCHAR(64) NOT NULL,
	CONSTRAINT roles_unique_name UNIQUE(role_name)
);