CREATE TABLE roles(
role_id INTEGER NOT NULL,
role_name VARCHAR(64) NOT NULL,
user_id INTEGER NOT NULL,
CONSTRAINT pk_roles PRIMARY KEY( role_id),
CONSTRAINT roles_unique_name UNIQUE( role_name)
);

CREATE INDEX idx_roles ON roles(user_id);

ALTER TABLE roles ADD CONSTRAINT 
fk_roles_user_id FOREIGN KEY (user_id)
REFERENCES users(user_id) ON DELETE CASCADE ON UPDATE CASCADE;
