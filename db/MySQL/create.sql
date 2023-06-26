drop database if exists PromocoesHoteis;
create database PromocoesHoteis;

use PromocoesHoteis;

create table Site(email varchar(256) not null, senha varchar(256) not null, endereco varchar(256) not null, nome varchar(256), telefone varchar(20), primary key (endereco));
create table Usuario(email varchar(256) not null, senha varchar(256) not null, primary key(email));
create table Hotel(email varchar(256) not null, senha varchar(256) not null, cnpj varchar(20), nome varchar(256), cidade varchar(256), primary key(cnpj));
create table Promocao(id bigint not null auto_increment, endereco varchar(256) not null, cnpj_hotel varchar(20) not null, preco float, data_ini date, data_fin date, foreign key (endereco) references Site(endereco), foreign key (cnpj_hotel) references Hotel(cnpj), primary key(id)); 

insert into Site (email, senha, endereco, nome, telefone) values ("promocoesloucas@gmail.com", "pr0m0123", "https://promocoesloucasdehoteis.com.br", "Promoções Loucas", "(16)34547289");

insert into Hotel (email, senha, cnpj, nome, cidade) values ("hotelbeiramar@bol.com", "b3ir4m4r", "55.854.538/0001-55", "Hotel Beira Mar", "São Paulo");

insert into Usuario (email, senha) values ("admin", "admin");

insert into Promocao (endereco, cnpj_hotel, preco, data_ini, data_fin) values ("https://promocoesloucasdehoteis.com.br", "55.854.538/0001-55", 80.00, '2023-07-01', '2023-09-01');