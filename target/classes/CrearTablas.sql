CREATE TABLE pais (
	id serial NOT NULL,
	nombre varchar(255) NULL,
	CONSTRAINT pais_pkey PRIMARY KEY (id)
)
--TABLESPACE pg_global
;
-- Permissions
--ALTER TABLE public.pais OWNER TO postgres;
--GRANT ALL ON TABLE public.pais TO postgres;

--------------Provincia-------
CREATE TABLE provincia (
	id serial NOT NULL,
	nombre varchar(255) NULL,
	pais_id int4 NULL,
	CONSTRAINT provincia_pkey PRIMARY KEY (id),
	CONSTRAINT fkgs8vq4ula76umo1ley89e0mf7 FOREIGN KEY (pais_id) REFERENCES pais(id)
);
-- Permissions
--ALTER TABLE public.provincia OWNER TO postgres;
--GRANT ALL ON TABLE public.provincia TO postgres;
--------------Localidad-------
CREATE TABLE localidad (
	id serial NOT NULL,
	nombre varchar(255) NULL,
	provincia_id int4 NULL,
	CONSTRAINT localidad_pkey PRIMARY KEY (id),
	CONSTRAINT fk8287lqwvj411skk30w0ov4w1k FOREIGN KEY (provincia_id) REFERENCES provincia(id)
);
-- Permissions
--ALTER TABLE public.localidad OWNER TO postgres;
--GRANT ALL ON TABLE public.localidad TO postgres;
-----------Cliente---------
CREATE TABLE cliente (
	id serial NOT NULL,
	apellido varchar(60) NULL,
	domicilio varchar(60) NULL,
	email varchar(60) NULL,
	localidad int4 NULL,
	nombre varchar(60) NULL,
	pais int4 NULL,
	provincia int4 NULL,
	telefono varchar(60) NULL,
	estado_civil int4 NULL,
	fechanacimiento timestamp NULL,
	nro_documento varchar(255) NULL,
	ocupacion varchar(255) NULL,
	tipo_documento int4 NULL,
	CONSTRAINT cliente_pkey PRIMARY KEY (id)
);
-- Permissions
--ALTER TABLE public.cliente OWNER TO postgres;
--GRANT ALL ON TABLE public.cliente TO postgres;
--------------CtaCte-----------
CREATE TABLE ctacte (
	id serial NOT NULL,
	apellido varchar(60) NULL,
	domicilio varchar(60) NULL,
	email varchar(60) NULL,
	localidad int4 NULL,
	nombre varchar(60) NULL,
	pais int4 NULL,
	provincia int4 NULL,
	telefono varchar(60) NULL,
	codigo_postal int4 NULL,
	cuit varchar(255) NULL,
	iva_tipo int4 NULL,
	CONSTRAINT ctacte_pkey PRIMARY KEY (id)
);
-- Permissions
--ALTER TABLE public.ctacte OWNER TO postgres;
--GRANT ALL ON TABLE public.ctacte TO postgres;
---------------Usuario-----------
CREATE TABLE usuario (
	id serial NOT NULL,
	apellido varchar(60) NULL,
	domicilio varchar(60) NULL,
	email varchar(60) NULL,
	localidad int4 NULL,
	nombre varchar(60) NULL,
	pais int4 NULL,
	provincia int4 NULL,
	telefono varchar(60) NULL,
	categoria varchar(255) NULL,
	cuil int4 NULL,
	password varchar(255) NOT NULL,
	profesion varchar(255) NULL,
	sso_id varchar(255) NOT NULL,
	CONSTRAINT uk_2m8vksya5b2gho157dk4c003v UNIQUE (sso_id),
	CONSTRAINT usuario_pkey PRIMARY KEY (id)
);
-- Permissions
--ALTER TABLE public.usuario OWNER TO postgres;
--GRANT ALL ON TABLE public.usuario TO postgres;
------------------UsuarioPerfil----------
CREATE TABLE usuario_perfil (
	id serial NOT NULL,
	"type" varchar(15) NOT NULL,
	CONSTRAINT uk_7bcc2tlvn8jru4quwvm5ddie0 UNIQUE (type),
	CONSTRAINT usuario_perfil_pkey PRIMARY KEY (id)
);
-- Permissions
--ALTER TABLE public.usuario_perfil OWNER TO postgres;
--GRANT ALL ON TABLE public.usuario_perfil TO postgres;
-----------------Usuario-Usuario-Perfil--------------
CREATE TABLE usuario_usuario_perfil (
	usuario_id int4 NOT NULL,
	usuario_perfil_id int4 NOT NULL,
	CONSTRAINT usuario_usuario_perfil_pkey PRIMARY KEY (usuario_id, usuario_perfil_id),
	CONSTRAINT fkd700at2qa8x3hk7viurp2jnu0 FOREIGN KEY (usuario_perfil_id) REFERENCES usuario_perfil(id),
	CONSTRAINT fkdtqoxpkkcmfpdyag3agtgf4tt FOREIGN KEY (usuario_id) REFERENCES usuario(id)
);
-- Permissions
--ALTER TABLE public.usuario_usuario_perfil OWNER TO postgres;
--GRANT ALL ON TABLE public.usuario_usuario_perfil TO postgres;
------------------RegitroHabitaciones---------
CREATE TABLE reghabitaciones (
	id serial NOT NULL,
	codcliente int4 NULL,
	flag bool NULL,
	fyhegreso timestamp NULL,
	fyhingreso timestamp NULL,
	CONSTRAINT reghabitaciones_pkey PRIMARY KEY (id)
);
-- Permissions
--ALTER TABLE public.reghabitaciones OWNER TO postgres;
--GRANT ALL ON TABLE public.reghabitaciones TO postgres;
------------------Logeo in and out---------
CREATE TABLE persistent_logins (
    nombreusuario varchar(64) not null,
    series varchar(64) not null,
    token varchar(64) not null,
    last_used timestamp not null,
    PRIMARY KEY (series)
);