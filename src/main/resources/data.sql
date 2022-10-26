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