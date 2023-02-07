use travel_search;

insert into land_trip values ('1', 'Europe Popular Capitals', 3, 'Hotel Best Madrid 3*', 'Hotel Worst Paris 4*');
insert into land_trip values ('2', 'Europe laying out cities' , 3, 'Hotel Best Madrid 3*', 'Hotel Worst Berlin 4*');
insert into citi values ('1', 'Madrid', 1, 0);
insert into citi values ('2', 'Paris', 1, 0);
insert into citi values ('3', 'Londres', 1, 0);
insert into citi values ('4', 'Berlin', 2, 0);
insert into citi values ('5', 'Madrid', 2, 0);

insert into air_trip values ('1', 'Infinite Egipt', 4, 'Madrid', '09-00', 'El Cairo', '10-00');
insert into air_trip values ('2', 'Incredible China' , 10, 'Madrid', '09-00', 'Beijing', '10-00');

insert into citi values ('6', 'Madrid', 0, 1);
insert into citi values ('7', 'Luxor', 0, 1);
insert into citi values ('8', 'El Cairo', 0, 1);

insert into citi values ('9', 'Madrid', 0, 2);
insert into citi values ('10', 'Canton', 0, 2);
insert into citi values ('11', 'Beijing', 0, 2);