DROP DATABASE IF EXISTS library_db;
CREATE DATABASE library_db;
USE library_db;


CREATE TABLE library (
                         library_id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
                         name VARCHAR(50) NOT NULL,
                         address VARCHAR(200),
                         phone VARCHAR(100)
);


CREATE TABLE book (
                      book_id INTEGER AUTO_INCREMENT PRIMARY KEY,
                      title VARCHAR(100) NOT NULL,
                      author VARCHAR(100) NOT NULL,
                      genre VARCHAR(100),
                      published_year YEAR,
                      available_copies INTEGER NOT NULL,
                      library_id INTEGER,
                      FOREIGN KEY (library_id) REFERENCES library (library_id)
);


CREATE TABLE patron (
                        patron_id INTEGER AUTO_INCREMENT PRIMARY KEY,
                        name VARCHAR(100) NOT NULL,
                        email VARCHAR(100) UNIQUE,
                        phone VARCHAR(15)
);


CREATE TABLE transaction (
                             transaction_id INTEGER AUTO_INCREMENT PRIMARY KEY,
                             book_id INTEGER,
                             patron_id INTEGER,
                             borrow_date DATE,
                             return_date DATE NULL,
                             FOREIGN KEY (book_id) REFERENCES book (book_id),
                             FOREIGN KEY (patron_id) REFERENCES patron (patron_id)
);


INSERT INTO library (name, address, phone)
VALUES ('Central Library', '123 Main St, Springfield', '555-123-4567'),
       ('East Branch', '456 Elm St, Springfield', '555-987-6543');


INSERT INTO book (title, author, genre, published_year, available_copies, library_id)
VALUES ('To Kill a Mockingbird', 'Harper Lee', 'Fiction', 2011, 5, 1),
       ('1984', 'George Orwell', 'Dystopian', 2021, 3, 1),
       ('The Great Gatsby', 'F. Scott Fitzgerald', 'Fiction', 2009, 4, 2),
       ('Moby Dick', 'Herman Melville', 'Adventure', 2017, 2, 2);

INSERT INTO patron (name, email, phone)
VALUES ('John Doe', 'johndoe@example.com', '555-000-1234'),
       ('Jane Smith', 'janesmith@example.com', '555-111-5678'),
       ('Sam Brown', 'sambrown@example.com', '555-222-3456');

INSERT INTO transaction (book_id, patron_id, borrow_date, return_date)
VALUES (1, 1, '2024-12-01', NULL),         -- John Doe borrowed "To Kill a Mockingbird"
       (2, 2, '2024-11-25', '2024-12-01'), -- Jane Smith borrowed and returned "1984"
       (3, 3, '2024-11-30', NULL);         -- Sam Brown borrowed "The Great Gatsby"

