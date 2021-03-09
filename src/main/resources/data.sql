
INSERT IGNORE INTO roles(name) VALUES('ROLE_USER');
INSERT IGNORE INTO roles(name) VALUES('ROLE_ADMIN');


INSERT IGNORE INTO users(id, email, name, password, username) VALUES(1, 'coradael@gmail.com','David Coronel', '$2a$10$5Ve/ua2fvvRjPm37lZjATOXi98H0Sat17Q3NTsgAMpKoGFjcZxUq2','David' );

INSERT IGNORE INTO user_roles(user_id, role_id) VALUES(1,1);

INSERT IGNORE INTO speler (id, achternaam, name, nummer, positie) VALUES (1,'Coronel','David Coronel',10, 'Centrale verdedigende middenvelder');
INSERT IGNORE INTO speler (id, achternaam, name, nummer, positie) VALUES (2,'Coronel','Job Coronel',12, 'Rechter middenvelder');
INSERT IGNORE INTO speler (id, achternaam, name, nummer, positie) VALUES (3,'Coronel','Obed Coronel',15, 'Linker middenvelder');
INSERT IGNORE INTO speler (id, achternaam, name, nummer, positie) VALUES (4,'Coronel','Daniel Coronel',17, 'Spits');


--user = David
--paswoord= 123456