
CREATE TABLE USERS(
  id integer primary key,
  firstName VARCHAR(20),
  secondName VARCHAR(20),
  role VARCHAR(20)
);

CREATE TABLE COMMENT(
  id integer primary key,
  value_date DATE,
  comment varchar(100),
  user_id integer references USERS(id)

);

insert into users  values (1, 'Ivan', 'Ivanov', 'User');
insert into comment values (1, '2020-09-09', 'Ivanov Comment', 1);