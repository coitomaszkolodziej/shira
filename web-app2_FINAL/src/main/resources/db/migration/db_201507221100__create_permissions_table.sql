
CREATE TABLE permissions
(
	permission_id integer NOT NULL PRIMARY KEY,
	permission_name character varying(64) NOT NULL,
	CONSTRAINT permissions_unique_name UNIQUE (permission_name)
);
