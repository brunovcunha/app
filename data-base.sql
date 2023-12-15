-- SQLBook: Code
-- Active: 1700922240653@@127.0.0.1@3306@dbccp
create database dbCCP;
use dbCCP;


create table tb_login(
usuario varchar(255) primary key,
senha varchar(255)
);

create table jogador(
    cod_jogador bigint primary key auto_increment,
    apelido varchar(50),
    senha varchar(50),
    data_nasc date,
    pontuacao int
);

create table poder(
    cod_poder int primary key auto_increment,
    habilidade varchar(50),
    descricao varchar(max)
);

create table adquire_habilidade(
    cod_jogador int primary3 key,
    cod_poder int primary key,
    foreign key(cod_jogador) references jogador (cod_jogador),
    foreign key(cod_poder) references poder (cod_poder)
);

create table cenario(
    cod_cenario int primary key auto_increment,
    caracteristicas varchar(50),
    pontos_necessarios int
);

create table partida(
    id_partida int primary key auto_increment,
    duracao long,
    pontos_obtidos int,
    jogador int,
    cenario int,
    foreign key(cod_jogador) references jogador (cod_jogador),
    foreign key(cod_cenario) references cenario (cod_cenario)
);

insert into login values
('admin', 'admin');

insert into poder(habilidade, descricao) values
("Cura Milagrosa", "Ervas mágicas com propriedades curativas inigualáveis, altamente suspeitas"),
("Ponta perfurante", "Com sua flecha mais forte, as barreiras do inimigo serão quebradas!"),
("Recarga eficiente", "Adquira não só uma, mas duas flechas de uma vez só!"),
("Salva-vidas", "Com este peitoral você conseguirá sobreviver a qualquer flecha, porém ele é bastante frágil!");

insert into jogador(nickname,email,data_nasc,pontuacao) values
("SolidSnake","snake@gmail.com","1990-06-20", 0),
("Tizil","tizil@bol.com","1909-08-30", 0),
("CJ","carl@iftm.com","2002-10-08", 0),
("Kratos","ihatezeus@yahoo.com","2007-09-02", 0);

insert into cenario(caracteristicas, pontos_necessarios) values
("Floresta"),
("Torneio"),
("Castelo"),
("Montanha Gélida");

INSERT INTO tb_login VALUES
('teste', 'admin');

INSERT INTO tb_login VALUES
('teste1', 'admin');

create table tb_role (
id integer auto_increment,
nome varchar(255) not null,
primary key(id)
);

insert into tb_role(nome) values ('ADMIN');

insert into tb_role(nome) values ('USER');

create table tb_role_user (
usuario varchar(255) not null,
role_id integer not null,
primary key(usuario,role_id),
foreign key(usuario) references tb_login(usuario),
foreign key(role_id) references tb_role(id)
);

insert into tb_role_user(usuario,role_id) values ('teste',1);

insert into tb_role_user(usuario,role_id) values ('teste1',2);

