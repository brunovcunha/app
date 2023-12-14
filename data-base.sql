-- SQLBook: Code
-- Active: 1700922240653@@127.0.0.1@3306@thegame

create database thegame;
use thegame;


create table login(
login varchar(50) PRIMARY KEY,
senha varchar(50)
);

create table jogador(
cod_jogador int primary key auto_increment,
nickname varchar(50),
sexo varchar(1),
email varchar(50),
data_nasc date,
pontuacao int, 
moedas int);

create table poder(
cod_poder int primary key,
habilidade varchar(50));

create table adquire_poder(
cod_aquisicao int primary key,
cod_jogador int,
cod_poder int,
dt_hora_aquisicao datetime,
foreign key(cod_jogador) references jogador (cod_jogador),
foreign key(cod_poder) references poder (cod_poder));

create table cenario(
cod_cenario int primary key,
caracteristicas varchar(50),
qtde_min_pontos int );

create table partida(
cod_partida int primary key auto_increment,
data_hora_inicio datetime,
data_hora_termino datetime,
pontos_obtidos int,
cod_jogador int,
cod_cenario int,
foreign key(cod_jogador) references jogador (cod_jogador),
foreign key(cod_cenario) references cenario (cod_cenario));

-- SQLBook: Code
-- Active: 1700597535888@@127.0.0.1@3306@thegame

create database thegame;
use thegame;


create table login(
login varchar(50) PRIMARY KEY,
senha varchar(50)
);

create table jogador(
cod_jogador int primary key auto_increment,
nome varchar(50),
nickname varchar(50),
sexo char(1),
email varchar(50),
dt_nasc date,
pontuacao int, 
moedas int);

create table poder(
cod_poder int primary key,
habilidade varchar(50));

create table adquire_poder(
cod_aquisicao int primary key,
cod_jogador int,
cod_poder int,
dt_hora_aquisicao datetime,
foreign key(cod_jogador) references jogador (cod_jogador),
foreign key(cod_poder) references poder (cod_poder));

create table cenario(
cod_cenario int primary key,
caracteristicas varchar(50),
qtde_min_pontos int );

create table partida(
cod_partida int primary key auto_increment,
data_hora_inicio datetime,
data_hora_termino datetime,
pontos_obtidos int,
cod_jogador int,
cod_cenario int,
foreign key(cod_jogador) references jogador (cod_jogador),
foreign key(cod_cenario) references cenario (cod_cenario));

-- SQLBook: Code
-- Active: 1700597535888@@127.0.0.1@3306@thegame

create database thegame;
use thegame;


create table login(
login varchar(50) PRIMARY KEY,
senha varchar(50)
);

create table jogador(
cod_jogador int primary key auto_increment,
nome varchar(50),
nickname varchar(50),
sexo char(1),
email varchar(50),
dt_nasc date,
pontuacao int, 
moedas int);

create table poder(
cod_poder int primary key,
habilidade varchar(50));

create table adquire_poder(
cod_aquisicao int primary key,
cod_jogador int,
cod_poder int,
dt_hora_aquisicao datetime,
foreign key(cod_jogador) references jogador (cod_jogador),
foreign key(cod_poder) references poder (cod_poder));

create table cenario(
cod_cenario int primary key,
caracteristicas varchar(50),
qtde_min_pontos int );

create table partida(
cod_partida int primary key auto_increment,
data_hora_inicio datetime,
data_hora_termino datetime,
pontos_obtidos int,
cod_jogador int,
cod_cenario int,
foreign key(cod_jogador) references jogador (cod_jogador),
foreign key(cod_cenario) references cenario (cod_cenario));

SELECT * from login;