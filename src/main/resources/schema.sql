create table if not exists Material (
  id varchar(4) not null,
  name varchar(25) not null,
  type varchar(10) not null,
  price integer not null
);

create table if not exists Building (
  id identity,
  name varchar(50) not null,
  calculateAt timestamp not null,
  square integer not null
);

create table if not exists Building_Materials (
  building integer not null,
  material varchar(4) not null
);

alter table Building_Materials
    add foreign key (building) references Building(id);
alter table Building_Materials
    add foreign key (material) references Material(id);

create table if not exists Building_Order (
	id identity,
	deliveryName varchar(50) not null,
	deliveryStreet varchar(50) not null,
	deliveryCity varchar(50) not null,
  dateOrder timestamp not null
);

create table if not exists Building_Order_Buildings (
	buildingOrder bigint not null,
	building bigint not null
);

alter table Building_Order_Buildings
    add foreign key (buildingOrder) references Building_Order(id);
alter table Building_Order_Buildings
    add foreign key (building) references Building(id);