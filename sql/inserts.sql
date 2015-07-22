INSERT INTO users VALUES( 1, 'radek', 'radek')
INSERT INTO users VALUES( 2, 'marek', 'marek') 
INSERT INTO users VALUES( 3, 'lukasz', 'lukasz')
INSERT INTO users VALUES( 4, 'malo_wazny', 'malo_wazny')

INSERT INTO roles VALUES( 1, 'super_user', 1)
INSERT INTO roles VALUES( 2, 'dodawacz', 2)
INSERT INTO roles VALUES( 3, 'mnoznik', 2)
INSERT INTO roles VALUES(4, 'stowkacz', 3)
INSERT INTO roles VALUES(5, 'dodawacz_2_3', 3)
INSERT INTO roles VALUES(6, 'nikt', 4)

INSERT INTO permissions VALUES(1, 'dodawanie', 1)
INSERT INTO permissions VALUES(2, 'odejmowanie', 1)
INSERT INTO permissions VALUES(3, 'mnozenie', 1)
INSERT INTO permissions VALUES(4, 'dodawanie', 1)

INSERT INTO permissions VALUES(5, 'dodawanie', 2)
INSERT INTO permissions VALUES(6, 'mnozenie', 3)
INSERT INTO permissions VALUES(7, 'stowka', 4)
INSERT INTO permissions VALUES(8, 'dodawanie_2_3', 5)


