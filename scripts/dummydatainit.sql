-- use only if you need to restart the database
-- drop database if exists critter_cuts;
-- create database critter_cuts;


-- select * from critter_cuts.appointment;

-- use after project start
use critter_cuts;
insert into user values (1, true, "password", "username");
insert into customer values (1, "customer@gmail.com", "John Doe", 1235556789, "1999-01-01", "password", "ROLE_USER", "username", 1);
insert into pet_info values (1, 5, "Shiba", true, "Spot", "Dog", 1, 1);
insert into user values (2, true, "pass", "user");
insert into employee values (1, "1999-01-01", "Jane Doe", "ROLE_ADMIN", 50000, "Dogs", 2);
insert into appointment values (1, "Jane Doe", "2022-01-01", 100.99, "Routine Groom", "12:00:00", 1, 1, 1);

select * from critter_cuts.appointment;