drop table if exists users;
drop table if exists notes;

-- Create the Users table
CREATE TABLE users (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       name_of_user VARCHAR(255) NOT NULL,
                       email VARCHAR(255) NOT NULL
);

-- Create the Notes table
CREATE TABLE notes (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       title VARCHAR(255) NOT NULL,
                       content VARCHAR(255) NOT NULL,
                       user_id BIGINT,
                       FOREIGN KEY (user_id) REFERENCES users(id)
);


-- -- Create the LockerCells table
-- CREATE TABLE locker_cells (
--                               id BIGINT AUTO_INCREMENT PRIMARY KEY,
--                               locker_id BIGINT,
--                               cell_size VARCHAR(255),
--                               is_available BOOLEAN NOT NULL,
--                               FOREIGN KEY (locker_id) REFERENCES lockers(id)
-- );
--
-- -- Create the Parcels table
-- CREATE TABLE parcels (
--                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
--                          locker_id BIGINT,
--                          cell_id BIGINT,
--                          size VARCHAR(255) NOT NULL,
--                          parcel_type VARCHAR(255) NOT NULL,
--                          sender_id BIGINT,
--                          recipient_id BIGINT,
--                          pickup_code VARCHAR(255) UNIQUE,
--                          is_collected BOOLEAN NOT NULL,
--                          FOREIGN KEY (locker_id) REFERENCES lockers(id),
--                          FOREIGN KEY (cell_id) REFERENCES locker_cells(id),
--                          FOREIGN KEY (sender_id) REFERENCES users(id),
--                          FOREIGN KEY (recipient_id) REFERENCES users(id)
-- );