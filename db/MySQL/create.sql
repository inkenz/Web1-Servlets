drop database if exists PromocoesHoteis;
create database PromocoesHoteis;

use PromocoesHoteis;

create table Site(email varchar(256) not null, senha varchar(256) not null, endereco varchar(256) not null, nome varchar(256), telefone varchar(20), primary key (endereco));
create table Usuario(email varchar(256) not null, senha varchar(256) not null, papel varchar(256) not null, primary key(email));
create table Hotel(email varchar(256) not null, senha varchar(256) not null, cnpj varchar(20), nome varchar(256), cidade varchar(256), primary key(cnpj));
create table Promocao(id bigint not null auto_increment, endereco varchar(256) not null, cnpj_hotel varchar(20) not null, preco float, data_ini date, data_fim date, foreign key (endereco) references Site(endereco), foreign key (cnpj_hotel) references Hotel(cnpj), primary key(id)); 

insert into Site (email, senha, endereco, nome, telefone) values ("promocoesloucas@gmail.com", "pr0m0123", "https://promocoesloucasdehoteis.com.br", "Promoções Loucas", "(16)34547289");

insert into Hotel (email, senha, cnpj, nome, cidade) values ("hotelbeiramar@bol.com", "b3ir4m4r", "55.854.538/0001-55", "Hotel Beira Mar", "São Paulo");

insert into Hotel (email, senha, cnpj, nome, cidade) values ("hotel1@hotel.com", "123", "55.854.538/0551-55", "Hotel 1", "São Paulo");
insert into Usuario (email, senha, papel) values ("hotel1", "123", "hotel");

insert into Usuario (email, senha, papel) values ("admin", "admin", "admin");

insert into Promocao (endereco, cnpj_hotel, preco, data_ini, data_fim) values ("https://promocoesloucasdehoteis.com.br", "55.854.538/0001-55", 80.00, '2023-07-01', '2023-09-01');

insert into Site (email, senha, endereco, nome, telefone) values ("sitefogueira@hotmail.com", "123", "https://sitefogueira.com.br", "Fogueira","11992130912");
insert into Usuario (email, senha, papel) values ("fogueira", "123", "site");

insert into Site (email, senha, endereco, nome, telefone) values ("site1@hotmail.com", "123", "https://site1.com.br", "Site 1","1199213214");
insert into Usuario (email, senha, papel) values ("site1", "123", "site");

insert into Site (email, senha, endereco, nome, telefone) values ("site2@hotmail.com", "123", "https://site2.com.br", "Site 2","1199213214");
insert into Usuario (email, senha, papel) values ("site2", "123", "site");
insert into Site (email, senha, endereco, nome, telefone) values ("site3@hotmail.com", "123", "https://site3.com.br", "Site 3","1199213214");
insert into Usuario (email, senha, papel) values ("site3", "123", "site");
