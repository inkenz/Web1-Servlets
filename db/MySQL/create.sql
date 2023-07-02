drop database if exists PromocoesHoteis;
create database PromocoesHoteis;

use PromocoesHoteis;

create table Site(email varchar(256) not null, senha varchar(256) not null, endereco varchar(256) not null, nome varchar(256), telefone varchar(20), primary key (endereco));
create table Usuario(email varchar(256) not null, senha varchar(256) not null, papel varchar(256) not null, primary key(email));
create table Hotel(email varchar(256) not null, senha varchar(256) not null, cnpj varchar(20), nome varchar(256), cidade varchar(256), primary key(cnpj));
create table Promocao(id bigint not null auto_increment, endereco varchar(256) not null, cnpj_hotel varchar(20) not null, preco float, data_ini date, data_fim date, foreign key (endereco) references Site(endereco), foreign key (cnpj_hotel) references Hotel(cnpj), primary key(id)); 

-- Criação de Sites
insert into Site (email, senha, endereco, nome, telefone) values ("promocoesloucas@gmail.com", "pr0m0123", "https://promocoesloucasdehoteis.com.br", "Promoções Loucas", "(16)34547289");
INSERT INTO Usuario(email, senha, papel) VALUES ("promocoesloucas@gmail.com", "pr0m0123", "site");

insert into Site (email, senha, endereco, nome, telefone) values ("sitefogueira@hotmail.com", "123", "https://sitefogueira.com.br", "Fogueira","11992130912");
INSERT INTO Usuario(email, senha, papel) VALUES ("sitefogueira@hotmail.com", "123", "site");

insert into Site (email, senha, endereco, nome, telefone) values ("site1@hotmail.com", "123", "https://site1.com.br", "Site 1","1199213214");
INSERT INTO Usuario(email, senha, papel) VALUES ("site1@hotmail.com", "123", "site");

insert into Site (email, senha, endereco, nome, telefone) values ("site2@hotmail.com", "123", "https://site2.com.br", "Site 2","1199213214");
INSERT INTO Usuario(email, senha, papel) VALUES ("site2@hotmail.com", "123", "site");

insert into Site (email, senha, endereco, nome, telefone) values ("site3@hotmail.com", "123", "https://site3.com.br", "Site 3","1199213214");
INSERT INTO Usuario(email, senha, papel) VALUES ("site3@hotmail.com", "123", "site");


-- Criação de Hotéis
insert into Hotel (email, senha, cnpj, nome, cidade) values ("hotelbeiramar@bol.com", "b3ir4m4r", "55.854.538/0001-55", "Hotel Beira Mar", "São Paulo");
insert into Usuario(email, senha, papel) values ("hotelbeiramar@bol.com", "b3ir4m4r", "hotel");

insert into Hotel (email, senha, cnpj, nome, cidade) values ("hotel1@hotel.com", "123", "55.854.538/0551-65", "Hotel 1", "São Paulo");
insert into Usuario(email, senha, papel) values ("hotel1@hotel.com", "123", "hotel");

insert into Hotel (email, senha, cnpj, nome, cidade) values ("cabanadapesca@uol.com.br", "seniaseniaumdoistres", "55.854.538/0551-55", "Cabana da Pesca", "São Joaquim");
INSERT INTO Usuario(email, senha, papel) VALUES ("cabanadapesca@uol.com.br", "seniaseniaumdoistres", "hotel");

INSERT INTO Hotel (email, senha, cnpj, nome, cidade) VALUES ("solnascente@example.com", "senha1", "11.111.111/0001-11", "Hotel Sol Nascente", "Rio de Janeiro");
INSERT INTO Usuario(email, senha, papel) VALUES ("solnascente@example.com", "senha1", "hotel");

INSERT INTO Hotel (email, senha, cnpj, nome, cidade) VALUES ("estreladourada@example.com", "senha2", "22.222.222/0001-22", "Hotel Estrela Dourada", "São Paulo");
INSERT INTO Usuario(email, senha, papel) VALUES ("estreladourada@example.com", "senha2", "hotel");

INSERT INTO Hotel (email, senha, cnpj, nome, cidade) VALUES ("paraisotropical@example.com", "senha3", "33.333.333/0001-33", "Hotel Paraíso Tropical", "Belo Horizonte");
INSERT INTO Usuario(email, senha, papel) VALUES ("paraisotropical@example.com", "senha3", "hotel");

INSERT INTO Hotel (email, senha, cnpj, nome, cidade) VALUES ("centralplaza@example.com", "senha4", "44.444.444/0001-44", "Hotel Central Plaza", "Brasília");
INSERT INTO Usuario(email, senha, papel) VALUES ("centralplaza@example.com", "senha4", "hotel");

INSERT INTO Hotel (email, senha, cnpj, nome, cidade) VALUES ("marazul@example.com", "senha5", "55.555.555/0001-55", "Hotel Mar Azul", "Salvador");
INSERT INTO Usuario(email, senha, papel) VALUES ("marazul@example.com", "senha5", "hotel");

INSERT INTO Hotel (email, senha, cnpj, nome, cidade) VALUES ("montanhaverde@example.com", "senha6", "66.666.666/0001-66", "Hotel Montanha Verde", "Curitiba");
INSERT INTO Usuario(email, senha, papel) VALUES ("montanhaverde@example.com", "senha6", "hotel");

INSERT INTO Hotel (email, senha, cnpj, nome, cidade) VALUES ("primavera@example.com", "senha7", "77.777.777/0001-77", "Hotel Primavera", "Porto Alegre");
INSERT INTO Usuario(email, senha, papel) VALUES ("primavera@example.com", "senha7", "hotel");

INSERT INTO Hotel (email, senha, cnpj, nome, cidade) VALUES ("valeencantado@example.com", "senha8", "88.888.888/0001-88", "Hotel Vale Encantado", "Florianópolis");
INSERT INTO Usuario(email, senha, papel) VALUES ("valeencantado@example.com", "senha8", "hotel");

INSERT INTO Hotel (email, senha, cnpj, nome, cidade) VALUES ("lagoaazul@example.com", "senha9", "99.999.999/0001-99", "Hotel Lagoa Azul", "Fortaleza");
INSERT INTO Usuario(email, senha, papel) VALUES ("lagoaazul@example.com", "senha9", "hotel");

INSERT INTO Hotel (email, senha, cnpj, nome, cidade) VALUES ("luacheia@example.com", "senha10", "10.101.010/0001-10", "Hotel Lua Cheia", "Natal");
INSERT INTO Usuario(email, senha, papel) VALUES ("luacheia@example.com", "senha10", "hotel");

INSERT INTO Hotel (email, senha, cnpj, nome, cidade) VALUES ("estreladomar@example.com", "senha11", "11.121.212/0001-11", "Hotel Estrela do Mar", "Recife");
INSERT INTO Usuario(email, senha, papel) VALUES ("estreladomar@example.com", "senha11", "hotel");

INSERT INTO Hotel (email, senha, cnpj, nome, cidade) VALUES ("serrabranca@example.com", "senha12", "12.131.313/0001-12", "Hotel Serra Branca", "Gramado");
INSERT INTO Usuario(email, senha, papel) VALUES ("serrabranca@example.com", "senha12", "hotel");

INSERT INTO Hotel (email, senha, cnpj, nome, cidade) VALUES ("jardimflores@example.com", "senha13", "13.141.414/0001-13", "Hotel Jardim das Flores", "Curitiba");
INSERT INTO Usuario(email, senha, papel) VALUES ("jardimflores@example.com", "senha13", "hotel");

INSERT INTO Hotel (email, senha, cnpj, nome, cidade) VALUES ("praiaserena@example.com", "senha14", "14.151.515/0001-14", "Hotel Praia Serena", "Florianópolis");
INSERT INTO Usuario(email, senha, papel) VALUES ("praiaserena@example.com", "senha14", "hotel");

INSERT INTO Hotel (email, senha, cnpj, nome, cidade) VALUES ("vilamistica@example.com", "senha15", "15.161.616/0001-15", "Hotel Vila Mística", "Porto Seguro");
INSERT INTO Usuario(email, senha, papel) VALUES ("vilamistica@example.com", "senha15", "hotel");



-- Criação de Usuários
insert into Usuario (email, senha, papel) values ("admin", "admin", "admin");


-- Criação de Promoções
insert into Promocao (endereco, cnpj_hotel, preco, data_ini, data_fim) values ("https://promocoesloucasdehoteis.com.br", "55.854.538/0001-55", 80.00, '2023-07-01', '2023-09-01');




