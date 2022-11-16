--drop table cart_item;
--drop table customer;
--drop table menu_item;

create table customer(
	customer_id serial primary key,
	customer_name varchar(255) not null,
	balance numeric check (balance > 0),
	password varchar(32) not null
);

create table menu_item(
	menu_item_id serial primary key,
	item_name varchar(255) not null unique,
	price numeric not null check (price > 0)
);

create table cart_item(
	cart_item_id serial primary key,
	item int not null,
	owned_by int not null, 
	foreign key (item) references menu_item(menu_item_id),
	foreign key (owned_by) references customer(customer_id)
);


insert into customer (customer_id, customer_name, balance,password) values (8, 'tim', 4.50, 'superPass');
insert into customer (customer_name, balance, password) values ('joe', 7.00, 'password');
insert into customer  values (default, 'kate', 2.00, 'pass123');
insert into customer  values (default, 'charlie', 21.00, 'pass123!');

insert into menu_item (menu_item_id, item_name, price) values (1, 'espresso', 2.50);
insert into menu_item (menu_item_id, item_name, price) values (2, 'cappucino', 4.50);

insert into cart_item (cart_item_id, item, owned_by) values (1, 1, 3);
insert into cart_item (cart_item_id, item, owned_by) values (2, 2, 3);
insert into cart_item (cart_item_id, item, owned_by) values (3, 1, 2);

-- * means all columns
select * from customer;
select * from cart_item;
select * from menu_item;

select * from customer inner join cart_item on customer.customer_id = cart_item.owned_by;


update menu_item set price = 3.5 where item_name = 'espresso';
select * from menu_item;
--delete from menu_item where item_name = 'cappucino';
delete from cart_item where cart_item_id = 3;
--i cant delete a value that is currently being referred to by another table because this would break referential integrity.
select * from cart_item;
--we've now completed all CRUD operations!

/*
multiplicity - relations between numbers of items
one-to-many - one customer has many cart items - 90% of all the multiplicity relationships
many-to-many - many type of coffee could be owned by many customers - this is managed by a intermediary table with two foreign keys - 
sometimes referred to as a junction table - eg a single customer might have many cart items, but a single type of coffee may belong to many carts
one-to-one - one customer may have one rewards account
normalization is the process of eliminating redundant data by splitting data into multiple tables while still maintaining all relationships.
the ideal, which is called 3rd normal form: we want to have a single primary key, and we want all values in a table to be directly (not transitively)
related to that primary key.
*/