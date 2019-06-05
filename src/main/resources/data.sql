insert into user_data (id, username, password, email)
values (1, 'jkowalski', '$2a$10$3ryV8IMl.ybbBZbFVrdl9OjVsVNruNZHNxqpo8GNC9L549P.e3HfC', 'jkowal@mail.com');

insert into user_roles (user_id, roles) values (1, 'ROLE_USER');

insert into car (id, brand, Vin_number, car_type, year_of_production, next_service, mileage, oil_type, amount_of_doors, engine_type, horse_power, user_id)
values (1, 'Audi 80', 'WAUFC08A5LA012462', 'SEDAN', 1990, '2020-10-26', 400000, '10W-40', 4, 'DIESEL', 90, 1);

insert into car (id, brand, Vin_number, car_type, year_of_production, next_service, mileage, oil_type, amount_of_doors, engine_type, horse_power, user_id)
values (2, 'BMW', 'WBAEB51008CV35249', 'COUPE', 2008, '2020-10-10', 150000, '5W-30', 3, 'PETROL', 150, 1);
