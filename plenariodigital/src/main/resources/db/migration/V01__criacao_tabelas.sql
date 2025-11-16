CREATE SCHEMA IF NOT EXISTS CAMARALEGISLATIVA;

CREATE TABLE IF NOT EXISTS camaralegislativa.partido(
	id_partido		SERIAL 						PRIMARY KEY,
	nome					VARCHAR(100)			NOT NULL,
	sigla					VARCHAR(50)				NOT NULL
); 

CREATE TABLE IF NOT EXISTS camaralegislativa.usuario(
	id_usuario		SERIAL	 					PRIMARY KEY,
	senha					VARCHAR(255)			NOT NULL,
	login					VARCHAR(100)			NOT NULL UNIQUE,
	tipo					VARCHAR(50)				NOT NULL
);

CREATE TABLE IF NOT EXISTS camaralegislativa.politico(
	id_politico		SERIAL	 				PRIMARY KEY,
	nome					VARCHAR(100)			NOT NULL,
	endereco			VARCHAR(200)			NOT NULL,
	cpf						VARCHAR(14)				NOT NULL UNIQUE,

	id_fkpartido	INTEGER 					NOT NULL,
	FOREIGN KEY (id_fkpartido) REFERENCES camaralegislativa.partido(id_partido),

	id_fkusuario	INTEGER						NOT NULL UNIQUE,
	FOREIGN KEY	(id_fkusuario) REFERENCES camaralegislativa.usuario(id_usuario)
);

CREATE TABLE IF NOT EXISTS camaralegislativa.projetodelei(
	id_projetodelei		SERIAL					PRIMARY KEY,
	titulo						VARCHAR(200)			NOT NULL,
	votos_favoraveis	INTEGER						NOT NULL,
	votos_contrarios	INTEGER 					NOT NULL,
	resultado					VARCHAR(50)				NOT NULL,

	id_fkpolitico			INTEGER						NOT NULL,
	FOREIGN KEY	(id_fkpolitico) REFERENCES camaralegislativa.politico(id_politico)
);




