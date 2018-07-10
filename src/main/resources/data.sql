insert into car_Class (car_Class_Id, car_Class_Name) values (1, 'Klasa miejska');
insert into car_Class (car_Class_Id, car_Class_Name) values (2, 'Klasa kompaktowa');
insert into car_Class (car_Class_Id, car_Class_Name) values (3, 'Klasa rodzinna');
insert into car_Class (car_Class_Id, car_Class_Name) values (4, 'Klasa luksusowa');


insert into car(car_Id, car_Name, car_Class_Id, people_No, door_No, fuel, consumption, capacity, power, luggage, gearbox, aircondition, picture)
values(1, 'Seat Leon', 2, 5, 4, 'Pb', '6.8l / 100', 1.4, '125 KM', '350 l', 'Manual', 'Tak', 'seatleon.png');
insert into car(car_Id, car_Name, car_Class_Id, people_No, door_No, fuel, consumption, capacity, power, luggage, gearbox, aircondition, picture)
values(2, 'Toyota Avensis', 4, 5, 4, 'Pb', '6.8l / 100', 1.8, '152 KM', '280 l', 'Manual', 'Tak', 'toyotaavensis.png');
insert into car(car_Id, car_Name, car_Class_Id, people_No, door_No, fuel, consumption, capacity, power, luggage, gearbox, aircondition, picture)
values(3, 'Peugeot 508', 4, 5, 4, 'ON', '6.5l / 100', 2.0, '163 KM', '380 l', 'Automat', 'Tak', 'peugeot508.png');
insert into car(car_Id, car_Name, car_Class_Id, people_No, door_No, fuel, consumption, capacity, power, luggage, gearbox, aircondition, picture)
values(4, 'Toyota Auris', 2, 5, 4, 'Pb', '6.8l / 100', 1.6, '130 KM', '250 l', 'Manual', 'Tak', 'toyotaauris.png');
insert into car(car_Id, car_Name, car_Class_Id, people_No, door_No, fuel, consumption, capacity, power, luggage, gearbox, aircondition, picture)
values(5, 'Fiat Panda', 1, 5, 4, 'Pb', '6.7l / 100', 1.1, '55 KM', '80 l', 'Manual', 'Nie', 'fiatpanda.png');
insert into car(car_Id, car_Name, car_Class_Id, people_No, door_No, fuel, consumption, capacity, power, luggage, gearbox, aircondition, picture)
values(6, 'Peugeot 208', 1, 5, 4, 'ON', '5.7l / 100', 1.2, '82 KM', '120 l', 'Manual', 'Tak', 'peugeot208.png');
insert into car(car_Id, car_Name, car_Class_Id, people_No, door_No, fuel, consumption, capacity, power, luggage, gearbox, aircondition, picture)
values(7, 'Renault Clio', 1, 5, 2, 'Pb', '4.9l / 100', 1.2, '85 KM', '200 l', 'Manual', 'Nie', 'renaultclio.png');
insert into car(car_Id, car_Name, car_Class_Id, people_No, door_No, fuel, consumption, capacity, power, luggage, gearbox, aircondition, picture)
values(8, 'BMW 318 GT', 4, 5, 4, 'ON', '8.5l / 100', 2.5, '243 KM', '350 l', 'Automat', 'Tak', 'bmw318.png');
insert into car(car_Id, car_Name, car_Class_Id, people_No, door_No, fuel, consumption, capacity, power, luggage, gearbox, aircondition, picture)
values(9, 'Hyundai i30', 2, 5, 4, 'Pb', '6.6l / 100', 1.6, '120 KM', '300 l', 'Manual', 'Tak', 'hyundaii30.png');
insert into car(car_Id, car_Name, car_Class_Id, people_No, door_No, fuel, consumption, capacity, power, luggage, gearbox, aircondition, picture)
values(10, 'Mercedes Vito', 3, 9, 4, 'ON', '9.2l / 100', 2.5, '190 KM', '600 l', 'Manual', 'Tak', 'mercedesv.png');
insert into car(car_Id, car_Name, car_Class_Id, people_No, door_No, fuel, consumption, capacity, power, luggage, gearbox, aircondition, picture)
values(11, 'Peugeot Expert', 3, 9, 4, 'ON', '9.6l / 100', 2.0, '150 KM', '600 l', 'Manual', 'Tak', 'peugeotexpert.png');


insert into Price(price_Id, name, car_Class_Id, day3, day7, day7more, deposit) values (4, 'Luksusowa', 4, 450, 420, 400, 3500);
insert into Price(price_Id, name, car_Class_Id, day3, day7, day7more, deposit) values (3, 'Rodzinna', 3, 400, 380, 340, 3000);
insert into Price(price_Id, name, car_Class_Id, day3, day7, day7more, deposit) values (2, 'Kompaktowa', 2, 300, 260, 220, 2000);
insert into Price(price_Id, name, car_Class_Id, day3, day7, day7more, deposit) values (1, 'Miejska',1, 250, 210, 170, 1500);


insert into accessory (accessory_Id, name, price) values (1, 'Uzytkowanie poza granica', 20);
insert into accessory (accessory_Id, name, price) values (2, 'Nawigacja', 10);
insert into accessory (accessory_Id, name, price) values (3, 'Fotelik dla dziecka', 10);
insert into accessory (accessory_Id, name, price) values (4, 'Dodatkowy kierowca', 50);

insert into client (client_Id, name, address, email, phone, dowod, accept_Mail, accept_SMS)
values (10000000,'Jan Kowalski','Warszawska 1/15','jan.kowalski@email.com','123456789','ABC 123456', 'Yes', 'Yes');
insert into client (client_Id, name, address, email, phone, dowod, accept_Mail, accept_SMS)
values (10000001,'Anna Nowak','Wielka 20','anna@email.com','999555111','ABC 445566', 'No', 'No');

insert into car_Rent (car_Rent_Id, car_Id, rent_Date, return_Date, client_Id, abroad, navigation, booster, driver)
values (10000000, 5, '2018-06-22 00:00:00.00', '2018-06-29 00:00:00.00', 10000000, 'No','No','No','No');
insert into car_Rent (car_Rent_Id, car_Id, rent_Date, return_Date, client_Id,abroad, navigation, booster, driver)
values (10000001, 8, '2018-06-28 00:00:00.00', '2018-07-10 00:00:00.00', 10000001, 'Yes', 'Yes', 'Yes', 'Yes');
