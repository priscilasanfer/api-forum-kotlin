CREATE TABLE resposta(
    id bigint not null auto_increment,
    mensagem varchar(300) not null,
    data_criacao datetime not null,
    topico_id bigint not null,
    autor_id bigint not null,
    solucao boolean,
    primary key (id)
);

alter table resposta
    add constraint fk_resposta_autor
        foreign key (autor_id) references usuario (id);

alter table resposta
    add constraint fk_resposta_topico
        foreign key (topico_id) references topico (id);