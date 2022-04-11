CREATE TABLE IF NOT EXISTS cliente
(
    id                int auto_increment primary key,
    tipoID            int          not null,
    nroID             int          not null,
    nombre            varchar(200) not null,
    apellido          varchar(200) not null,
    usuario           varchar(200) not null,
    contrasena        varchar(200) not null,
    nroCelular        varchar(10)  not null,
    correoElectronico varchar(200) not null,
    constraint cliente_correoElectronico_uindex unique (correoElectronico),
    constraint cliente_id_uindex unique (id),
    constraint cliente_usuario_uindex unique (usuario)
);