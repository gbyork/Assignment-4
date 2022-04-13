drop table Customer

create table Customer (
   CustomerId int not null,
   CustomerName varchar(30),
   PhoneNumber BIGINT,
   UserId varchar(20),
   Password varchar(20),

   primary key(CustomerId)
);
insert into Customer
   (CustomerId, CustomerName, PhoneNumber, UserId, Password)
Values
   (1001, 'Customer One', 4175551212, 'Cust1', 'cust1'),
   (1002, 'Customer Two', 4173126655, 'Cust2', 'cust2'),
   (1003, 'Customer Three', 4176663322, 'Cust3', 'cust3');
