-- The second approach is to use the plain old Spring JDBC capability,which relies on
-- using the schema.sql file that contains the database table definition and a corresponding
-- data.sql file that contains the data.

INSERT INTO author (id, first_name, last_name) VALUES (1, 'Alex', 'Antonov')
INSERT INTO publisher (id, name) VALUES (1, 'Packt')
INSERT INTO book (isbn, title, author_id, publisher_id) VALUES ('978-1-78528-415-1', 'Spring Boot Recipes', 1, 1)