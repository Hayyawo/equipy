insert into users(first_name, last_name, pesel)
values ('Jan', 'Kowalski', '90101222457'),
       ('Maciej', 'Zalewski', '87112242456'),
       ('Aneta', 'Korczyńska', '76061536749'),
       ('Wojciech', 'Sokolik', '82010877245');

insert into category(name, description)
values ('laptops', 'Small, portable computer');

insert into asset(name, description, serial_number, category_id)
values ('Asus MateBook D', '15" i5, 16GB DDR3, SSD256GB', 'MBP15X0925336', 1),
       ('dsfg MateBook D', '15" i5, 16GB DDR3, SSD256GB', '3gbgrfs', 1);
insert into assignment(start_time, end_time, asset_id, users_id)
values ('2017-10-08 15:00:00', '2018-10-08 15:00:00', 1, 1),
       ('2018-10-09 12:00:00', null, 2, 2),
       ('2018-10-10 16:00:00', null, 2, 3);

INSERT INTO
    security_entity (first_name, last_name, email, password)
VALUES
    -- superadmin@example.com / hard
    ('Jan', 'Kowalski', 'superadmin@example.com', '{bcrypt}$2a$10$Ruu5GtmSVkfLeuGfz/wHUuzflCcMbwJHSBo/.Wui0EM0KIM52Gs2S'),
    -- john@example.com / dog.8
    ('John', 'Abacki', 'john@example.com', '{MD5}{AlZCLSQMMNLBS5mEO0kSem9V3mxplC6cTjWy9Kj/Gxs=}d9007147eb3a5f727b2665d647d36e35'),
    -- java_lover@example.com / javaiscool
    ('Marek', 'Zalewski', 'java_lover@example.com', '{argon2}$argon2id$v=19$m=4096,t=3,p=1$YBBBwx+kfrNgczYDcLlWYA$LEPgdtfskoobyFtUWTMejaE5SBRyieHYbiE5ZmFKE7I');

INSERT INTO
    user_role (name, description)
VALUES
    ('ADMIN', 'Has permission to everything'),
    ('USER', 'Only reading');

INSERT INTO
    user_roles (security_entity_id, role_id)
VALUES
    (1, 1),
    (2, 2),
    (3, 2);