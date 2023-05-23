#drop database db_pessoas;
create database db_pessoas;

use db_pessoas;

CREATE TABLE tb_usuario 
(id INT PRIMARY KEY AUTO_INCREMENT,
nome VARCHAR(200), 
senha VARCHAR(200));

INSERT INTO tb_usuario (nome, senha) VALUES ("admin", "admin");


CREATE TABLE tb_login
(
codigo INT PRIMARY KEY AUTO_INCREMENT,
usuario VARCHAR(200),
senha VARCHAR(200)
);


CREATE TABLE tb_pessoa
(
codigo INT PRIMARY KEY AUTO_INCREMENT,
nome VARCHAR(200),
fone VARCHAR(200),
email VARCHAR(200)
);

