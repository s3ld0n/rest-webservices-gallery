-- noinspection SqlNoDataSourceInspectionForFile

INSERT INTO artists(id, first_name, last_name, email, password) VALUES (1, 'Alex', 'Mert', 'am@mail.com', '123');
INSERT INTO artists(id, first_name, last_name, email, password) VALUES (2, 'John', 'Doe', 'jd@mail.com', '123');
INSERT INTO artists(id, first_name, last_name, email, password) VALUES (3, 'Al', 'Lap', 'al@mail.com', '123');

INSERT INTO works(id, title, date_created) VALUES (1, 'Snow', '2019-07-13');
INSERT INTO works(id, title, date_created) VALUES (2, 'Water', '2019-07-13');
INSERT INTO works(id, title, date_created) VALUES (3, 'Forest', '2019-07-13');
INSERT INTO works(id, title, date_created) VALUES (4, 'Fighting bugs', '2019-07-13');
INSERT INTO works(id, title, date_created) VALUES (5, 'City', '2019-07-13');

INSERT INTO roles(id, name) VALUES (1, 'ADMIN');
INSERT INTO roles(id, name) VALUES (2, 'USER');

INSERT INTO users(id, username, password) VALUES (1, 'admin', 'admin');
INSERT INTO users(id, username, password) VALUES (2, 'user', 'user');

INSERT INTO users_roles(user_id, role_id) VALUES (1,1);
INSERT INTO users_roles(user_id, role_id) VALUES (1,2);
INSERT INTO users_roles(user_id, role_id) VALUES (2,2);