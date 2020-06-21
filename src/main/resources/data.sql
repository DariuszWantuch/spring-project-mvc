insert into user_role(role, description) VALUES ("ROLE_USER", "Rola dla klienta");
insert into user_role(role, description) VALUES ("ROLE_ADMIN", "Rola dla pracownika");

INSERT INTO users(email,password,first_name,last_name)
VALUES ('admin@admin.pl','{bcrypt}$2a$10$6AogvNg2PAZuK7S3M/kT8OZQH13cp/lugoYuTcyjHkb4yNRFTvOO6','Dariusz','Wantuch');

INSERT INTO users(email,password,first_name,last_name)
VALUES ('client@client.pl','{bcrypt}$2a$10$ndJy7igNEq6VULLtgOEhfuu8obxhEsKYOHsWpoLnQs0Nk8IyMvOqm','Client','Test');

INSERT INTO users_roles(user_id_user,roles_id)
VALUES (1,2);

INSERT INTO users_roles(user_id_user,roles_id)
VALUES (2,1);

INSERT INTO equipment(name)
VALUES ('TV');

INSERT INTO equipment(name)
VALUES ('Pralka');

INSERT INTO equipment(name)
VALUES ('Lodówka');

INSERT INTO equipment(name)
VALUES ('Komputer');

INSERT INTO equipment(name)
VALUES ('Mikrofalówka');
