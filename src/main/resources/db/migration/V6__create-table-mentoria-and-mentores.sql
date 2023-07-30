create table mentores(
    id bigint not null auto_increment,
    nome varchar(100) not null,
    email varchar(100) not null unique,
    usuario varchar(100) not null unique,
    papel varchar(100) not null,
    cidade varchar(100) not null,
    logradouro varchar(100) not null,
    bairro varchar(100) not null,
    cep varchar(9) not null,
    uf char(2) not null,
    numero varchar(20),
    complemento varchar(100),
    active tinyint,

    primary key(id)
);

create table mentoria(

    id bigint not null auto_increment,
    mentor_id bigint not null,
    usuario_id bigint not null,
    data datetime not null,

    primary key(id),
    constraint fk_consultas_mentor_id foreign key(mentor_id) references mentores(id),
    constraint fk_consultas_usuario_id foreign key(usuario_id) references usuarios(id)

);