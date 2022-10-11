insert into users(first_name, last_name, pesel)
values ('Jan', 'Kowalski', '90101222457'),
       ('Maciej', 'Zalewski', '87112242456'),
       ('Aneta', 'Korczyńska', '76061536749'),
       ('Wojciech', 'Sokolik', '82010877245');

insert into category(id, name, description)
values (1, 'laptops', 'Small, portable computer');

insert into asset(name, description, serial_number, category_id)
values ('Asus MateBook D', '15" i5, 16GB DDR3, SSD256GB', 'MBP15X0925336', 1);