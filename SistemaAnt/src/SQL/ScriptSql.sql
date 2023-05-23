#drop database db_pessoas;
create database db_pessoas;

use db_pessoas;

CREATE TABLE tb_usuario 
(id INT PRIMARY KEY AUTO_INCREMENT,
nome VARCHAR(50), 
usuario VARCHAR(50),
senha VARCHAR(50));

INSERT INTO tb_usuario (nome, usuario, senha) VALUES ("Administrador", "admin", "admin");


CREATE TABLE tb_pessoa
(
codigo INT PRIMARY KEY AUTO_INCREMENT,
nome VARCHAR(200),
enderco VARCHAR(200),
cpf VARCHAR(200),
fone VARCHAR(200),
email VARCHAR(200));



