drop table if exists customers;
drop table if exists cards;

create table `customers` (
  `id` bigint auto_increment primary key,
  `name` varchar(100) not null,
  `email` varchar(100) not null,
  `mobile_number` varchar(20) not null,
  `create_dt` date default curdate()
);

create table `cards` (
  `id` bigint auto_increment primary key,
  `customer_id` bigint not null,
  `number` varchar(100) not null,
  `type` varchar(100) not null,
  `limit_amount` int not null,
  `used_amount` int not null,
  `available_amount` int not null,
  `create_dt` date default curdate()
);
