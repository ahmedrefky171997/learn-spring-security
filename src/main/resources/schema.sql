CREATE TABLE users
(
    id       INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE authorities
(
    id             INT PRIMARY KEY AUTO_INCREMENT,
    authority_name VARCHAR(255) NOT NULL
);

CREATE TABLE user_authority
(
    user_id      INT NOT NULL,
    authority_id INT NOT NULL,
    PRIMARY KEY (user_id, authority_id),
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (authority_id) REFERENCES authorities (id)
);