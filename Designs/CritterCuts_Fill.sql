




use critter_cuts;

insert into user values (1, 1, null, true, "pass123",  "ROLE_USER", "John");
insert into user values (2, null, 1, true, "pass123",  "ROLE_ADMIN", "Jane");
insert into user values (3, 2, null, true, "pass123",  "ROLE_USER", "Ted");
insert into user values (4, null, 2, true, "pass123",  "ROLE_USER", "Kiley");

insert into customer values (1, "customer@gmail.com", "John Doe", 1235556789, "1999-01-01", "pass123",  1, "John", 1);
insert into customer values (2, "customer4@gmail.com", "Ted Binkley", 1235578977, "1994-01-01", "pass123",  2, "Ted", 2);

insert into pet_info values (1, 1, 5, "Shiba", true, "Spot", "Dog", 1);
insert into pet_info values (2, 2, 6, "Green", true, "Jeb", "Lizard", 2);
insert into pet_info values (3, 1, 3, "SHort-Hair", true, "Ko", "Cat", 1);
insert into pet_info values (4, 2, 2, "Green", true, "George", "Dog", 2);

insert into employee values (1, "1999-01-01", "Jane Doe",  50000, "Dogs", 2, 2);
insert into employee values (2, "1945-01-01", "Kiley Jane",  50000, "Juggling", 4, 4);

insert into appointment values (1, "Jane Doe", "2022-01-01", 100.99, "Routine Groom", "12:00:00", 1, 1);

insert into appointment values (2, "Kiley Jane", "2022-02-02", 199.99, "Premium Groom", "20:00:00", 2, 2);

insert into appointment values (3, "Jane Doe", "2022-01-05", 160.99, "Routine Brush", "12:00:00", 1, 3);

insert into appointment values (4, "Kiley Jane", "2022-03-02", 199.99, "Premium Brush", "20:00:00", 2, 4);


select * from critter_cuts.appointment;