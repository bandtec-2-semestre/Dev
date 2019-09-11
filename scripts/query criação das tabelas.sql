create table client (
ID int primary key identity(1,1),
name varchar(40),
compName varchar(30),
cnpj int,
email varchar(40),
phone int,
pswd int
);

create table Device_type (
Id int identity,
name varchar(30),
model varchar(30)
);

create table Device_Status (
ID int identity,
description varchar(20),
);

create table system (
ID int identity,
name varchar(30),
FK_client int foreign key references client(ID)
);

create table device (
ID int identity,
name varchar(30),
description varchar(40),
FK_type int foreign key references Device_type(id),
FK_system int foreign key references system(id),
FK_status int foreign key references Device_Status(id)
);

create table device_log (
ID int identity,
description varchar(30),
date_time datetime,
FK_device int foreign key references device(id),
N_error varchar(30)
);

create table system_log (
ID int identity,
value int,
components varchar(30),
date_time datetime,
FK_system int foreign key references system(id)
);

create table system_components (
Id int identity,
name varchar(30),
description varchar(30),
size int,
FK_system_log int foreign key references system_log(id)
);
