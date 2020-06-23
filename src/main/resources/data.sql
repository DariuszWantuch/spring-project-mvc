insert into user_role(role, description) VALUES ("ROLE_USER", "Rola dla klienta");
insert into user_role(role, description) VALUES ("ROLE_ADMIN", "Rola dla pracownika");

INSERT INTO user(email,password,first_name,last_name)
VALUES ('admin@admin.pl','{bcrypt}$2a$10$6AogvNg2PAZuK7S3M/kT8OZQH13cp/lugoYuTcyjHkb4yNRFTvOO6','Dariusz','Wantuch');

INSERT INTO user(email,password,first_name,last_name)
VALUES ('client@client.pl','{bcrypt}$2a$10$ndJy7igNEq6VULLtgOEhfuu8obxhEsKYOHsWpoLnQs0Nk8IyMvOqm','Client','Test');

INSERT INTO user_roles(user_id,roles_id)
VALUES (1,2);

INSERT INTO user_roles(user_id,roles_id)
VALUES (2,1);

INSERT INTO type_of_equipment(name)
VALUES ('TV');

INSERT INTO type_of_equipment(name)
VALUES ('Pralka');

INSERT INTO type_of_equipment(name)
VALUES ('Lodówka');

INSERT INTO type_of_equipment(name)
VALUES ('Komputer');

INSERT INTO type_of_equipment(name)
VALUES ('Mikrofalówka');

INSERT INTO repair_request(date,des)
VALUES ('2020-07-20','Zepsuta lodówka');

INSERT INTO repair_request(date,des)
VALUES ('2020-07-12','Dymi się z telewizora');

INSERT INTO repair_request_type_of_equipments(repair_request_id,type_of_equipments_id)
VALUES (1,3);

INSERT INTO repair_request_type_of_equipments(repair_request_id,type_of_equipments_id)
VALUES (2,1);

INSERT INTO user_repair_requests(user_id,repair_requests_id)
VALUES (2,1);

INSERT INTO user_repair_requests(user_id,repair_requests_id)
VALUES (2,2);


