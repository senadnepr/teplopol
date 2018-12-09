delete from Building_Order_Buildings;
delete from Building_Materials;
delete from Building;
delete from Building_Order;

delete from Material;

insert into Material (id, name, type, price)
                values ('PP', 'Penopolistirol', 'POLIIZOL', 50);
insert into Material (id, name, type, price)
                values ('POL', 'Poliizol', 'POLIIZOL', 20);
insert into Material (id, name, type, price)
                values ('NP', 'No poliisol', 'POLIIZOL', 0);
insert into Material (id, name, type, price)
                values ('MTD', 'OJ Microline MTD-1991', 'THERMOSTAT', 1700);
insert into Material (id, name, type, price)
                values ('OTN', 'OJ Microline OTN-1991', 'THERMOSTAT', 1600);
insert into Material (id, name, type, price)
                values ('OCD5', 'OJ Microline OCD5-1999', 'THERMOSTAT', 3600);
insert into Material (id, name, type, price)
                values ('300', 'Nexans TXLP 1/300 Wt', 'CABLE', 1500);
insert into Material (id, name, type, price)
                values ('400', 'Nexans TXLP 1/400 Wt', 'CABLE', 1800);
insert into Material (id, name, type, price)
                values ('500', 'Nexans TXLP 1/500 Wt', 'CABLE', 2100);
insert into Material (id, name, type, price)
                values ('600', 'Nexans TXLP 1/600 Wt', 'CABLE', 2500);