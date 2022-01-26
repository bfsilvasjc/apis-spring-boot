create database testetinnova;

create table veiculo(id_veiculo int auto_increment primary key not null, 
veiculo varchar(30) not null, marca varchar(30) not null, ano int not null, 
descricao varchar(50) not null, vendido bool not null, created datetime not null,
updated datetime not null);