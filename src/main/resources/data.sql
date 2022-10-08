insert into user(id, first_name, last_name, pesel)
values (1, 'Jan', 'Kowalski', '90101222457'),
       (2, 'Maciej', 'Zalewski', '87112242456'),
       (3, 'Aneta', 'Korczyńska', '76061536749'),
       (4, 'Wojciech', 'Sokolik', '82010877245');

insert into category(id, name, description)
values (1, 'laptops', 'Small, portable computer');

insert into asset(id, name, description, serial_number, category_id)
values (1, 'Asus MateBook D', '15" i5, 16GB DDR3, SSD256GB', 'MBP15X0925336', 1);