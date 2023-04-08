
insert into `customers` (`name`,`email`,`mobile_number`,`create_dt`)
  values ('Denis Nesterov', 'https://github.com/exelure', '1234567890', curdate());

insert into `accounts` (`customer_id`,`type`,`branch_address`,`create_dt`)
  values (1, 'Savings', '20 Bond St, Sydney NSW 2000, Australia', curdate());

