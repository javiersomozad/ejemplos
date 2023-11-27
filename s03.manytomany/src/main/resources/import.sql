insert into newspaper values (1, 'Wall Street Journal');
insert into newspaper values (2, 'El Caso');
insert into newspaper values (3, 'Frankfurter Allgemeine Zeitung');

insert into subscriptor values (1, 'Juan','c/ Mayor 3');
insert into subscriptor values (2, 'Homer','Evergreen Terrace 642');
insert into subscriptor values (3, 'Merkel','Uber Strasse 42');

insert into newspaper_subscriptor  (newspaper_id, subscriptor_id) values (1,1);
insert into newspaper_subscriptor (newspaper_id, subscriptor_id) values (1,2);
insert into newspaper_subscriptor (newspaper_id, subscriptor_id) values (1,3);
insert into newspaper_subscriptor (newspaper_id, subscriptor_id) values (2,2);
insert into newspaper_subscriptor (newspaper_id, subscriptor_id) values (2,3);
insert into newspaper_subscriptor (newspaper_id, subscriptor_id) values (3,1);
