drop table if exists customers;
drop table if exists loans;

create table `customers` (
  `id` bigint auto_increment primary key,
  `name` varchar(100) not null,
  `email` varchar(100) not null,
  `mobile_number` varchar(20) not null,
  `create_dt` date default curdate()
);

create table `loans` (
  `loan_number` bigint auto_increment primary key,
  `customer_id` bigint not null,
  `start_dt` date not null default curdate(),
  `type` varchar(100) not null,
  `total_amount` int not null,
  `paid_amount` int not null,
  `outstanding_amount` int not null,
  `create_dt` date default curdate()
);
