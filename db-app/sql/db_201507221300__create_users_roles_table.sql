CREATE TABLE users_roles 
(
	users_roles_id SERIAL PRIMARY KEY, 
	user_id integer NOT NULL REFERENCES users (user_id),
	role_id integer NOT NULL REFERENCES roles (role_id)	
)
