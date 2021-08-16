 CREATE TABLE usuario(
    id bigint not null auto_increment,
    nome varchar(255) not null,
    email varchar(255) not null,
    primary key (id)
);

insert into usuario (id, nome, email) values (1, 'Priscila', 'teste@email.com');
