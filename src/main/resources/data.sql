insert into car_Class (car_Class_Id, car_Class_Name) values (1, 'Klasa miejska');
insert into car_Class (car_Class_Id, car_Class_Name) values (2, 'Klasa kompaktowa');
insert into car_Class (car_Class_Id, car_Class_Name) values (3, 'Klasa luksusowa');

insert into car(car_Id, car_Name, car_Class_Id, people_No, door_No, fuel, consumption, capacity, power, luggage, gearbox, aircondition, picture)
values(1, 'Seat Leon', 2, 5, 4, 'Pb', '6.8l / 100', 1.4, '125 KM', '350 l', 'Manual', 'Tak', 'obrazekSeatLeon');
insert into car(car_Id, car_Name, car_Class_Id, people_No, door_No, fuel, consumption, capacity, power, luggage, gearbox, aircondition, picture)
values(2, 'Toyota Avensis', 3, 5, 4, 'Pb', '6.8l / 100', 1.8, '152 KM', '280 l', 'Manual', 'Tak', 'obrazekToyotaAvensis');
insert into car(car_Id, car_Name, car_Class_Id, people_No, door_No, fuel, consumption, capacity, power, luggage, gearbox, aircondition, picture)
values(3, 'Peugeot 508', 3, 5, 4, 'ON', '6.5l / 100', 2.0, '163 KM', '380 l', 'Automat', 'Tak', 'obrazekPeugeot508');
insert into car(car_Id, car_Name, car_Class_Id, people_No, door_No, fuel, consumption, capacity, power, luggage, gearbox, aircondition, picture)
values(4, 'Toyota Auris', 2, 5, 4, 'Pb', '6.8l / 100', 1.6, '130 KM', '250 l', 'Manual', 'Tak', 'obrazekToyotaAuris');
insert into car(car_Id, car_Name, car_Class_Id, people_No, door_No, fuel, consumption, capacity, power, luggage, gearbox, aircondition, picture)
values(5, 'Fiat Panda', 1, 5, 4, 'Pb', '6.7l / 100', 1.1, '55 KM', '80 l', 'Manual', 'Nie', 'obrazekFiatPanda');
insert into car(car_Id, car_Name, car_Class_Id, people_No, door_No, fuel, consumption, capacity, power, luggage, gearbox, aircondition, picture)
values(6, 'Peugeot 208', 1, 5, 4, 'ON', '5.7l / 100', 1.2, '82 KM', '120 l', 'Manual', 'Tak', 'obrazekPeugeot208');
insert into car(car_Id, car_Name, car_Class_Id, people_No, door_No, fuel, consumption, capacity, power, luggage, gearbox, aircondition, picture)
values(7, 'Renault Clio', 1, 5, 2, 'Pb', '4.9l / 100', 1.2, '85 KM', '200 l', 'Manual', 'Nie', 'obrazekRenault');
insert into car(car_Id, car_Name, car_Class_Id, people_No, door_No, fuel, consumption, capacity, power, luggage, gearbox, aircondition, picture)
values(8, 'BMW 318 GT', 3, 5, 4, 'ON', '5.5l / 100', 2.0, '143 KM', '350 l', 'Automat', 'Tak', 'obrazekBMW318GT');
insert into car(car_Id, car_Name, car_Class_Id, people_No, door_No, fuel, consumption, capacity, power, luggage, gearbox, aircondition, picture)
values(9, 'Hyundai i30', 2, 5, 4, 'Pb', '6.6l / 100', 1.6, '120 KM', '300 l', 'Manual', 'Tak', 'obrazekHyundai30');

insert into Price(price_Id, car_Class_Id, day3, day7, day7more, deposit) values (1, 3, 380, 340, 300, 3000);
insert into Price(price_Id, car_Class_Id, day3, day7, day7more, deposit) values (2, 2, 300, 260, 220, 2000);
insert into Price(price_Id, car_Class_Id, day3, day7, day7more, deposit) values (3, 1, 250, 210, 170, 1500);

insert into car_Rent (car_Rent_Id, car_Id, rent_Date, return_Date) values (1, 5, '2018-06-22', '2018-06-29');
-- insert into car_Rent (car_Rent_Id, car_Id, rent_Date, return_Date) values (1, 8, '2018-06-28',);


