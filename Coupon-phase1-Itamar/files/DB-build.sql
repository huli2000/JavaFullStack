-- DB Build for Coupon system --
create schema `Coupons_DB_Itamar`;

-- tables creation --
create table `Company`(
`id` int auto_increment,
`name` varchar(50),
`email` varchar(50),
`password` varchar(10),
primary key (id)
);
drop table company;
insert into company values (0, 'AAA', 'aaa@gmail.com', 'aaaPass');
insert into company values (0, 'bbb', 'bbb@gmail.com', 'bbbPass');
select * from company;


create table `Customer`(
`id` int auto_increment,
`first_name` varchar(50),
`last_name` varchar(50),
`email` varchar(50),
`password` varchar(10),
primary key (id)
);

insert into customer values (0, 'Moshe','David', 'moshe@gmail.com', 'MDPass');
select * from customer;

create table `Coupon`(
`id` int auto_increment,
`company_id` int,
`category` enum('FOOD','ELECTRONICS', 'HOME' , 'CLOTHING', 'CMAPING' , 'VACATION'),
`title` varchar (100),
`description` varchar(100),
`start_date` date,
`end_date` date,
`amount` int,
`price` double,
`image` varchar(50),
primary key (id),
foreign key (company_id) references company(id)
);

insert into `coupon` values (0,1, 'FOOD', 'Burger', 'Yami aymi burger' , '2021-10-20', '2021-11-20', 5, 35.5, 'image-1');
select * from coupon;

-- join table so we know which customer bought which coupon --
create table customer_vs_coupon (
customer_id int,
coupon_id int,
primary key(customer_id, coupon_id),
foreign key(customer_id) references customer(id),
foreign key(coupon_id) references coupon(id)
);