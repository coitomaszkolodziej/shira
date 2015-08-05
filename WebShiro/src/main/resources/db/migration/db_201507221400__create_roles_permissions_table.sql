CREATE TABLE roles_permissions 
(
	role_permissions_id SERIAL PRIMARY KEY, 
	role_id integer NOT NULL REFERENCES roles (role_id),
	permission_id  integer NOT NULL REFERENCES permissions (permission_id )	
)
