
CREATE TABLE permissions
(
  permission_id integer NOT NULL,
  permission_name character varying(64) NOT NULL,
  role_id integer NOT NULL,
  CONSTRAINT pk_permissions PRIMARY KEY (permission_id),
  CONSTRAINT fk_permissions_role_id FOREIGN KEY (role_id)
      REFERENCES roles (role_id) MATCH SIMPLE
      ON UPDATE CASCADE ON DELETE CASCADE,
  CONSTRAINT permissions_unique_name UNIQUE (permission_name)
);

CREATE INDEX idx_permissions
  ON permissions
  USING btree
  (role_id);
