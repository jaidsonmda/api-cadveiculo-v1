
    create sequence veiculos_SEQ start with 1 increment by 50;

    create table veiculos (
        ano integer,
        created date,
        updated date,
        vendido boolean,
        id bigint not null,
        cor varchar(255),
        descricao varchar(255),
        marca varchar(255),
        veiculo varchar(255),
        primary key (id)
    );
