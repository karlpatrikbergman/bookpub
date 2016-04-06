-- The first way relies on using Hibernate to automatically create the table structure
-- by inferring it from our defined @Entityobjects and using the import.sql file to
-- populate the data.

-- The import.sql file is also expected to reside in the root of the classpath by Hibernate.
-- This is used to execute the declared SQL statements on the application startup.
-- While any valid SQL statement can go in the file, it is recommended that you put the data
-- importing statements such as INSERT or UPDATE and stay clear of table structure mutations,
-- as the schema definition is already taken care of by Hibernate.

-- INSERT INTO author (id, first_name, last_name) VALUES (1, 'Alex', 'Antonov')
-- INSERT INTO publisher (id, name) VALUES (1, 'Packt')
-- INSERT INTO book (isbn, title, author_id, publisher_id) VALUES ('978-1-78528-415-1', 'Spring Boot Recipes', 1, 1)