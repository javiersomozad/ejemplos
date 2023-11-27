insert into user (id, username, password, email, enabled) values (1,'falken','$2a$10$zR7z8/ZnCP79p9NNgoRojOnNiyIcT/HfSLMqAhGmBGsuQB9iOhzqa','falken@mit.edu', true);
insert into user (id, username, password, email, enabled) values (2,'john_doe','$2a$10$zR7z8/ZnCP79p9NNgoRojOnNiyIcT/HfSLMqAhGmBGsuQB9iOhzqa','jdoe@ge.us', true);
insert into user (id, username, password, email, enabled) values (3,'nobody','$2a$10$zR7z8/ZnCP79p9NNgoRojOnNiyIcT/HfSLMqAhGmBGsuQB9iOhzqa','no@no.org', true);
insert into role (id, role) values (1,'ANONYMOUS');
insert into role (id, role) values (2, 'USER');
insert into role (id, role) values (3, 'ADMIN');

--insert into user_role (user_id , role_id ) values (1,2);
insert into user_role (user_id , role_id ) values (1,3);
insert into user_role (user_id , role_id ) values (2,2);
insert into user_role (user_id , role_id ) values (3,2)
