insert into person (id, name) values (1, 'Mel Gibson');
insert into person (id, name) values (2, 'Clint Eastwood');
insert into person (id, name) values (3, 'Sophie Marceau');
insert into person (id, name) values (4, 'Gene Hackman');
insert into person (id, name) values (5, 'Ryan Gosling');
insert into person (id, name) values (6, 'Denis Villeneuve');
 insert into plot (id, description) values (1,'Epic film about...');
insert into plot (id, description) values (2,'A former killer..');
insert into plot (id, description) values (3,'Remake of the classic...');
insert into movie (id, title, year, director_id, plot_id) values (1, 'Braveheart', 1995, 1,1);
insert into movie (id, title, year, director_id, plot_id) values (2, 'Unforgiven', 1992, 2,2);
insert into movie (id, title, year, director_id, plot_id) values (3, 'Blade Runner 2049', 2017, 6,3);
insert into movie_actor (movie_id, person_id) values (1,1);
insert into movie_actor (movie_id, person_id) values (1,3);
insert into movie_actor (movie_id, person_id) values (2,2);
insert into movie_actor (movie_id, person_id) values (2,4);
insert into movie_actor (movie_id, person_id) values (3,5);



