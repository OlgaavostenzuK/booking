create table hibernate_sequence (next_val bigint) engine=InnoDB;
insert into hibernate_sequence values ( 1 );
insert into hibernate_sequence values ( 1 );
insert into hibernate_sequence values ( 1 );

create table reserve (idreserve integer not null, date date, idsubject integer, iduser integer, primary key (idreserve)) engine=InnoDB;
create table subject (idsubject integer not null, address varchar(255), area integer, filename varchar(255), info varchar(255), media varchar(255), price integer, region varchar(255), subject_name varchar(255), primary key (idsubject)) engine=InnoDB;
create table user_role (iduser integer not null, roles varchar(255)) engine=InnoDB;
create table usr (iduser integer not null, password varchar(255) not null, username varchar(255) not null, primary key (iduser)) engine=InnoDB;

alter table reserve add constraint subject_reserve_fk foreign key (idsubject) references subject (idsubject);
alter table reserve add constraint user_reserve_fk foreign key (iduser) references usr (iduser);
alter table user_role add constraint user_ref_roles_fk foreign key (iduser) references usr (iduser);