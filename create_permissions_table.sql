CREATE TABLE permissions(
permission_id INTEGER NOT NULL,
permission_name VARCHAR(64) NOT NULL,
role_id INTEGER NOT NULL,
CONSTRAINT pk_permissions PRIMARY_KEY(permission_id),
CONSTRAINT permissions_unique_name
);

ALTER TABLE permissions ADD CONSTRAINT 
( 
fk_permissions_role_id FOREIGN_KEY roles(role_id) 
REFERENCES roles(role_id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE INDEX idx_permissions ON permissions(role_id);

