create table usuarios(

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

    primary key(id)

);