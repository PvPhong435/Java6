CREATE DATABASE J6Store

GO

CREATE TABLE Roles
(
	Id	VARCHAR(50),
	Name NVARCHAR(50),
	Primary Key(id)
);

GO

CREATE TABLE Categories
(
	Id varchar(50),
	Name NVARCHAR(50),
	Primary Key(id)
);

GO

CREATE TABLE Products
(
	Id varchar(50),
	Name NVARCHAR(50),
	Image VARCHAR(50),
	Price FLOAT,
	CreateDate DATE,
	Available bit,
	CategoryId VARCHAR(50),
	PRIMARY KEY(Id),
	FOREIGN KEY(CategoryId) REFERENCES Categories(Id)
);

GO

CREATE TABLE Accounts
(
	Username VARCHAR(50),
	Password VARCHAR(50),
	Fullname NVARCHAR(50),
	Email VARCHAR(50),
	Photo VARCHAR(50),
	PRIMARY KEY(Username),
	
);

GO

CREATE TABLE Authorities
(
	Id VARCHAR(50),
	Username VARCHAR(50),
	RoleId VARCHAR(50),
	PRIMARY KEY(Id),
	FOREIGN KEY(RoleId) REFERENCES Roles(Id),
	FOREIGN KEY(Username) REFERENCES Accounts(Username)
);

GO

CREATE TABLE Orders
(
	Id VARCHAR(50),
	Username VARCHAR(50),
	CreateDate DATE,
	Address NVARCHAR(100),
	PRIMARY KEY(Id),
	FOREIGN KEY(Username) REFERENCES Accounts(Username)
);

GO

CREATE TABLE OrderDetails
(
	Id VARCHAR(50),
	OrderId varchar(50),
	ProductId VARCHAR(50),
	Price FLOAT,
	Quantity int,
	PRIMARY KEY(Id),
	FOREIGN KEY(OrderId) REFERENCES Orders(Id),
	FOREIGN KEY(ProductId) REFERENCES Products(Id)
);

GO

-- Bảng Roles
INSERT INTO Roles (Id, Name) VALUES 
('R01', N'Admin'),
('R02', N'User');

GO
-- Bảng Categories
INSERT INTO Categories (Id, Name) VALUES 
('C01', N'Smartphone'),
('C02', N'Tablet'),
('C03', N'Accessories');

GO
-- Bảng Products
INSERT INTO Products (Id, Name, Price, CreateDate, Available, CategoryId) VALUES 
('P01', N'iPhone 14', 999.99, '2024-11-01', 1, 'C01'),
('P02', N'Samsung Galaxy S22', 849.99, '2024-10-20', 1, 'C01'),
('P03', N'iPad Air', 599.99, '2024-09-15', 1, 'C02'),
('P04', N'Oppo Reno6', 499.99, '2024-08-10', 1, 'C01'),
('P05', N'Xiaomi Mi 11', 699.99, '2024-07-05', 1, 'C01'),
('P06', N'Samsung Galaxy Tab S7', 749.99, '2024-06-01', 1, 'C02'),
('P07', N'iPhone 13', 899.99, '2024-05-20', 1, 'C01'),
('P08', N'Vivo V23', 429.99, '2024-04-15', 1, 'C01'),
('P09', N'AirPods Pro', 199.99, '2024-03-10', 1, 'C03'),
('P10', N'Samsung Galaxy Buds2', 149.99, '2024-02-05', 1, 'C03');

GO
-- Bảng Accounts
INSERT INTO Accounts (Username, Password, Fullname, Email, Photo) VALUES 
('admin', 'admin123', N'Phạm Văn Phong', 'phong@example.com', ''),
('user01', 'user123', N'Nguyễn Văn A', 'user01@example.com', ''),
('user02', 'user123', N'Lê Thị B', 'user02@example.com', ''),
('user03', 'user123', N'Trần Văn C', 'user03@example.com', ''),
('user04', 'user123', N'Hoàng Minh D', 'user04@example.com', ''),
('user05', 'user123', N'Phạm Thu E', 'user05@example.com', ''),
('user06', 'user123', N'Nguyễn Văn F', 'user06@example.com', ''),
('user07', 'user123', N'Trần Quốc G', 'user07@example.com', ''),
('user08', 'user123', N'Lê Văn H', 'user08@example.com', ''),
('user09', 'user123', N'Nguyễn Thị I', 'user09@example.com', '');

GO
-- Bảng Authorities
INSERT INTO Authorities (Id, Username, RoleId) VALUES 
('A01', 'admin', 'R01'),
('A02', 'user01', 'R02'),
('A03', 'user02', 'R02'),
('A04', 'user03', 'R02'),
('A05', 'user04', 'R02'),
('A06', 'user05', 'R02'),
('A07', 'user06', 'R02'),
('A08', 'user07', 'R02'),
('A09', 'user08', 'R02'),
('A10', 'user09', 'R02');

GO
-- Bảng Orders
INSERT INTO Orders (Id, Username, CreateDate, Address) VALUES 
('O01', 'user01', '2024-11-12', N'123 Đường ABC, Bình Dương'),
('O02', 'user02', '2024-11-13', N'456 Đường XYZ, Bình Dương'),
('O03', 'user03', '2024-11-14', N'789 Đường DEF, TP. HCM'),
('O04', 'user04', '2024-11-15', N'012 Đường GHI, Hà Nội'),
('O05', 'user05', '2024-11-16', N'345 Đường JKL, Đà Nẵng'),
('O06', 'user06', '2024-11-17', N'678 Đường MNO, Bình Dương'),
('O07', 'user07', '2024-11-18', N'901 Đường PQR, TP. HCM'),
('O08', 'user08', '2024-11-19', N'234 Đường STU, Hà Nội'),
('O09', 'user09', '2024-11-20', N'567 Đường VWX, Đà Nẵng'),
('O10', 'user01', '2024-11-21', N'890 Đường YZ, Bình Dương');

GO
-- Bảng OrderDetails
INSERT INTO OrderDetails (Id, OrderId, ProductId, Price, Quantity) VALUES 
('OD01', 'O01', 'P01', 999.99, 1),
('OD02', 'O02', 'P02', 849.99, 2),
('OD03', 'O03', 'P03', 599.99, 1),
('OD04', 'O04', 'P04', 499.99, 3),
('OD05', 'O05', 'P05', 699.99, 1),
('OD06', 'O06', 'P06', 749.99, 2),
('OD07', 'O07', 'P07', 899.99, 1),
('OD08', 'O08', 'P08', 429.99, 2),
('OD09', 'O09', 'P09', 199.99, 3),
('OD10', 'O10', 'P10', 149.99, 1);
