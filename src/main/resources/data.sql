DROP TABLE  IF EXISTS Employee;

CREATE TABLE Employee(
    id INT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    designation VARCHAR(50) NOT NULL
);

insert into Employee (id,name,designation) values(1,'Jane','Software Engineer');
insert into Employee (id,name,designation) values(2,'Etim','Mobile Engineer');
insert into Employee (id,name,designation) values(3,'Nkanor','Designer');
insert into Employee (id,name,designation) values(4,'Okon','UI/UX');