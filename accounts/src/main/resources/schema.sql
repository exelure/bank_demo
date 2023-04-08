drop table if exists customers;
drop table if exists accounts;

create table `customers` (
  `id` bigint auto_increment primary key,
  `name` varchar(100) not null,
  `email` varchar(100) not null,
  `mobile_number` varchar(20) not null,
  `create_dt` date default curdate()
);

create table `accounts` (
  `account_number` bigint auto_increment primary key,
  `customer_id` bigint not null,
  `type` varchar(100) not null,
  `branch_address` varchar(200) not null,
  `create_dt` date default curdate()
);
