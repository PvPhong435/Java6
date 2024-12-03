create database J6Security;
go

use J6Security;
go

create table accounts(
	username varchar(20) primary key,
	password nvarchar(100),
	fullname nvarchar(50),
	email varchar(50),
	img varchar(50)
);
go

create table [roles](
	id varchar(10) primary key,
	name nvarchar(50)
);
go

create table authorities(
	id int primary key identity,
	username varchar(20),
	roleid varchar(10)
);
go

alter table authorities
add constraint FK_Authority_Account foreign key (username)
references accounts(username);
go

alter table authorities
add constraint FK_Authority_Role foreign key (roleid)
references [roles](id);

insert into [roles] values
('ADMIN', 'Administrators'),
('USER', 'Users'),
('GUEST', 'Guests')

insert into accounts values
('user1', '123', N'Nguyễn Văn User', 'user1@gmail.com', null),
('user2', '123', N'Trần Thị User', 'user2@gmail.com', null),
('user3', '123', N'Trần Văn User', 'user3@gmail.com', null),
('user4', '123', N'Đoàn Thị User', 'user4@gmail.com', null)

insert into authorities(username, roleid) values
('user1', 'GUEST'),
('user2', 'USER'),
('user3', 'ADMIN')