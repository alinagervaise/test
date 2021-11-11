
drop table costumer if exists;
create table costumer (
id int auto_increment primary key,
name varchar(100) not  null,
address varchar (150) not null,
zip_code varchar(5) not null,
city varchar not null,
country varchar not null,
constraint unique_destinataire unique (name, address, zip_code, city, country)
);
drop table purchase if exists;
create table purchase (id int auto_increment primary key,
costumer_id int not null,
delivery_date datetime not null,
quantity int not null,
price decimal not null,
foreign key(costumer_id) references costumer(id)
);
