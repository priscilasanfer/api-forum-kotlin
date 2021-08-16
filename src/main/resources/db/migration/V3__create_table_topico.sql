CREATE TABLE topico (
    id bigint not null auto_increment,
    titulo varchar(50) not null,
    mensagem varchar(300) not null,
    data_criacao datetime not null,
    status varchar(20) not null,
    curso_id bigint not null,
    autor_id bigint not null,
    primary key (id)
);

alter table topico
    add constraint fk_topico_curso
        foreign key (curso_id) references curso (id);

alter table topico
    add constraint fk_topico_usuario
        foreign key (autor_id) references usuario (id);