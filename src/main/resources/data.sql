INSERT INTO users (username, password)
VALUES ('user1', 'password1'),
       ('user2', 'password2'),
       ('user3', 'password3');

INSERT INTO authorities (authority_name)
VALUES ('ROLE_ADMIN'),
       ('ROLE_USER'),
       ('ROLE_MANAGER');

INSERT INTO user_authority (user_id, authority_id)
VALUES (1, 1), -- user1 has ROLE_ADMIN
       (1, 2), -- user1 also has ROLE_USER
       (2, 2), -- user2 has ROLE_USER
       (3, 3); -- user3 has ROLE_MANAGER