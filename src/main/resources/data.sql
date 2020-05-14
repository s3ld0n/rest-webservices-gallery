-- noinspection SqlNoDataSourceInspectionForFile

INSERT INTO artists(id, first_name, last_name, email, password) VALUES (1, 'Alex', 'Mert', 'am@mail.com', '123');
INSERT INTO artists(id, first_name, last_name, email, password) VALUES (2, 'John', 'Doe', 'jd@mail.com', '123');
INSERT INTO artists(id, first_name, last_name, email, password) VALUES (3, 'Al', 'Lap', 'al@mail.com', '123');

INSERT INTO works(id, artist_id, title, date_created) VALUES (1, 1, 'Snow', '2019-07-13');
INSERT INTO works(id, artist_id, title, date_created) VALUES (2, 1, 'Water', '2019-07-13');
INSERT INTO works(id, artist_id, title, date_created) VALUES (3, 2, 'Forest', '2019-07-13');
INSERT INTO works(id, artist_id, title, date_created) VALUES (4, 3, 'Fighting bugs', '2019-07-13');
INSERT INTO works(id, artist_id, title, date_created) VALUES (5, 3, 'City', '2019-07-13');

