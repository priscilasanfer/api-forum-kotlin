DROP TABLE IF EXISTS usuario;
DROP TABLE IF EXISTS curso;
DROP TABLE IF EXISTS resposta;
DROP TABLE IF EXISTS topico;

CREATE TABLE curso(
    id bigint not null,
    nome varchar(255) not null,
    categoria varchar(255) not null,

    primary key (id)
);

CREATE TABLE resposta(
    id bigint not null,
    data_criacao timestamp not null,
    mensagem varchar(255) not null,
    autor_id bigint not null,
    topico_id bigint not null,
    solucao boolean,
    primary key (id)
);

CREATE TABLE topico (
    id bigint not null,
    data_criacao datetime not null,
    mensagem varchar(255) not null,
    status varchar(20) not null,
    titulo varchar(255) not null,
    autor_id bigint not null,
    curso_id bigint not null,
    primary key (id)
);

 CREATE TABLE usuario(
    id bigint not null ,
    nome varchar(255) not null,
    email varchar(255) not null,
    primary key (id)
);

alter table topico
    add constraint fk_topico_curso
        foreign key (curso_id) references curso (id);

alter table topico
    add constraint fk_topico_usuario
        foreign key (autor_id) references usuario (id);

alter table resposta
    add constraint fk_resposta_autor
        foreign key (autor_id) references usuario (id);

alter table resposta
    add constraint fk_resposta_topico
        foreign key (topico_id) references topico (id);



insert into curso (id, nome, categoria) values (1, 'Kotlin', 'Programação');
insert into usuario (id, nome, email) values (1, 'Priscila', 'teste@email.com');
insert into topico (id, data_criacao, mensagem, status, titulo, autor_id, curso_id) values (1, CURRENT_DATE(), 'Duvida Kotlin', 'NAO_RESPONDIDO', 'Duva sobre algo', 1, 1);
insert into resposta (id, data_criacao, mensagem, autor_id, topico_id, solucao ) values(1, CURRENT_DATE(), 'A resposta é simples', 1,1, 1)

