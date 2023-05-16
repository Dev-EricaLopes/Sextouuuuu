#drop database db_pessoas;
create database db_pessoas;

use db_pessoas;

CREATE TABLE tb_usuario 
(id INT PRIMARY KEY AUTO_INCREMENT,
nome VARCHAR(200), 
senha VARCHAR(200));

INSERT INTO tb_usuario (nome, senha) VALUES ("admin", "admin");

select * from tb_usuario;

CREATE TABLE tb_login
(
codigo INT PRIMARY KEY AUTO_INCREMENT,
usuario VARCHAR(200),
senha VARCHAR(200)
);


INSERT INTO tb_login 
(usuario, senha) 
VALUES 
("ericaolopes", "123"),
("admin", "admin");

select * from tb_login;

CREATE TABLE tb_pessoa
(
codigo INT PRIMARY KEY AUTO_INCREMENT,
nome VARCHAR(200),
fone VARCHAR(200),
email VARCHAR(200)
);

INSERT INTO tb_pessoa 
(nome, fone, email) 
VALUES 
('Catarina', '11223344', 'jose@email.com'),
('Pedro', '11223344', 'jose@email.com'),
('Guilherme', '11223344', 'jose@email.com'),
('Marcela', '11223344', 'jose@email.com'),
('Leonardo', '11223344', 'jose@email.com');

UPDATE tb_pessoa SET 
fone = '11 32659-9966', email = 'josec@usjt.br' 
WHERE codigo = 1;

select * from tb_pessoa;

use db_pessoas;
DELETE FROM tb_pessoa WHERE codigo>2;




