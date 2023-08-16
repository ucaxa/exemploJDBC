
/*criação do banco*/
create database fj21;
/*usando o banco*/
use fj21;

/*criando a tabela de contatos*/
create table contatos(
  id BIGINT NOT	NULL	AUTO_INCREMENT,
  nome VARCHAR(255),
  email	VARCHAR(255),
  endereco VARCHAR(255),
  dataNascimento DATE,
  primary key (id)
  );

/*listando contatos*/
select * from contatos;