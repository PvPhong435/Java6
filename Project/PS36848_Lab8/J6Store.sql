use J6Store;
go

create table product(
	id varchar(10) primary key,
	name nvarchar(100),
	price float,
	img varchar(500),
	createat datetime,
	available bit,
	categoryid varchar(10)
);
go

create table category(
	id varchar(10) primary key,
	name nvarchar(100)
);
go

create table account(
	username varchar(50) primary key,
	password nvarchar(100),
	fullname nvarchar(100),
	email varchar(100),
	img varchar(200)
);
go

create table [role](
	id varchar(10) primary key,
	name nvarchar(100)
);
go

create table authority(
	id int primary key identity,
	username varchar(50),
	roleid varchar(10)
);
go

create table [order](
	id int primary key identity,
	createDate datetime,
	address varchar(100),
	username varchar(50)
);
go

create table orderdetail(
	id int primary key identity,
	price float,
	quantity int,
	orderid int,
	productid varchar(10)
);
go

alter table product
add constraint FK_Product_Category foreign key (categoryid)
references category(id);
go

alter table [order]
add constraint FK_Order_Account foreign key (username)
references account(username);
go

alter table orderdetail
add constraint FK_OrderDetail_Order foreign key (orderid)
references [order](id);
go

alter table orderdetail
add constraint FK_OrderDetail_Product foreign key (productid)
references product(id);
go

alter table authority
add constraint FK_Authority_Account foreign key (username)
references account(username);
go

alter table authority
add constraint FK_Authority_Role foreign key (roleid)
references [role](id);

insert into category values
('phone', 'Phone'),
('laptop', 'Laptop'),
('tablet', 'Tablet');

insert into product(id, name, price, img, available, createat, categoryid) values
('phone1', 'iPhone 16 Pro Max 256GB', 34190000, 'iphone-16-pro-max.webp', 1, '2024-11-18 8:58:32', 'phone'),
('phone2', 'iPhone 16 Pro Max 512GB', 40990000, 'iphone-16-pro-max_1.webp', 1, '2024-11-18 9:02:07', 'phone'),
('phone3', 'iPhone 15 Pro Max 256GB', 29990000, 'iphone-15-pro-max.webp', 1, '2024-11-18 9:04:15', 'phone'),
('phone4', 'iPhone 15 128GB', 19690000, 'iphone-15.webp', 1, '2024-11-18 9:08:37', 'phone'),
('phone5', 'iPhone 14 Pro Max 256GB', 27990000, 'iphone-14-pro-max.webp', 1, '2024-11-18 9:08:51', 'phone'),
('phone6', 'Samsung Galaxy S24 Ultra 12GB 256GB', 27990000, 'galaxy-s24-ultra.webp', 1, '2024-11-18 9:10:01', 'phone'),
('phone7', 'Samsung Galaxy S23 Ultra 12GB 512GB', 23490000, 'galaxy-s23-ultra.webp', 1, '2024-11-18 9:11:08', 'phone'),
('phone8', 'Samsung Galaxy Z Fold6 12GB 256GB', 41990000, 'galaxy-z-fold6.webp', 1, '2024-11-18 9:12:10', 'phone'),
('phone9', 'Samsung Galaxy Z Flip6 12GB 256GB', 26990000, 'galaxy-z-flip6.webp', 1, '2024-11-18 9:13:24', 'phone'),
('phone10', 'Xiaomi 14T Pro 12GB 512GB', 17990000, 'xiaomi-14t-pro.webp', 1, '2024-11-18 9:15:32', 'phone'),
('phone11', 'Xiaomi 14T 12GB 512GB', 13990000, 'xiaomi-14t.webp', 1, '2024-11-18 9:16:12', 'phone'),
('phone12', 'Xiaomi Redmi Note 13 Pro Plus 5G 8GB 256GB', 9190000, 'xiaomi-note-13-pro-plus-5g.webp', 1, '2024-11-18 9:17:06', 'phone'),
('phone13', 'Xiaomi Redmi Note 13 6GB 128GB', 4290000, 'xiaomi-note-13.webp', 1, '2024-11-18 9:17:52', 'phone'),
('laptop1', 'Laptop Acer Gaming Aspire 5 A515-58GM-53PZ', 15490000, 'acer-aspire-5.webp', 1, '2024-11-18 9:20:18', 'laptop'),
('laptop2', 'Laptop Gaming Acer Nitro 5 Tiger AN515 58 52SP', 17990000, 'acer-nitro-5-tiger.webp', 1, '2024-11-18 9:22:38', 'laptop'),
('laptop3', 'Laptop Lenovo LOQ 15IAX9 83GS001RVN', 20990000, 'lenovo-loq.webp', 1, '2024-11-18 9:23:11', 'laptop'),
('laptop4', 'Apple MacBook Air M2 2022 8GB 256GB', 22990000, 'macbook-air-m2-2022.webp', 1, '2024-11-18 9:24:09', 'laptop'),
('laptop5', 'Laptop ASUS Vivobook 15 X1504ZA-NJ517W', 14290000, 'asus-vivobook-15.webp', 1, '2024-11-18 9:25:25', 'laptop'),
('laptop6', 'Laptop Lenovo IdeaPad Slim 5 14Q8X9 83HL000KVN', 23490000, 'lenovo-ideapad-slim-5.webp', 1, '2024-11-18 9:25:58', 'laptop'),
('laptop7', 'Laptop ASUS Expertbook B1402CBA-NK2669W', 12990000, 'asus-expertbook.webp', 1, '2024-11-18 9:27:47', 'laptop');

insert into [role] values
('DIRE', 'Director'),
('STAFF', 'Staff'),
('ADMIN', 'Admin'),
('USER', 'User')

insert into account values
('tin', '123', 'Tin', 'tin@gmail.com', null),
('trongtin', '123', 'Trong Tin', 'trongtin@gmail.com', null)

insert into authority(username, roleid) values
('tin', 'USER'),
('trongtin', 'ADMIN'),
('trongtin', 'DIRE'),
('trongtin', 'STAFF')