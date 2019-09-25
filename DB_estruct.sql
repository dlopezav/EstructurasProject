/*reate database Proyec_Estruc;*/
use Proyec_Estruc;

/*DROPING DE LAS TABLAS*/
/*
DROP TABLE Artista; 
DROP TABLE Concierto; 

DROP TABLE Concierto_Artistas; 
DROP TABLE Boleta; 
DROP TABLE Pesona; 
DROP TABLE Persona_Boletas; 
DROP TABLE Concierto_Asistentes; 
DROP TABLE Zona; 
DROP TABLE Zona_Boleta; 
DROP TABLE Concierto_Zonas; 
DROP TABLE Administrador; 
*/

/*CREACIÓN TABLA ARTISTA*/ 

CREATE TABLE Artista(
	Nombre char(80) primary key not null,
    GeneroMusical char(50) not null,
    integrantes int not null
);


/*CREACIÓN TABLA CONCIERTO Y SUS RELACIONES*/ 

CREATE TABLE Concierto(
	fecha Date not null,
    Nombre char(80) primary key not null,  
	hora int not null
);

CREATE TABLE Concierto_Artistas(
	Nombre_Concierto char(80) primary key not null,
    Artista_Nombre char(80) not null,
    FOREIGN KEY (Nombre_Concierto)
		REFERENCES Concierto (Nombre),
	FOREIGN KEY (Artista_Nombre) REFERENCES Artista (Nombre)
);

/*CREACIÓN TABLA BOLESTA*/ 

CREATE TABLE Boleta(
	numSilla int primary key,
    Seccion int not null,
	fecha date not null,
    Nombre_Concierto char(80) not null,
    estado boolean not null,
    FOREIGN KEY (Nombre_Concierto) REFERENCES Concierto (Nombre)
);

/*CREACIÓN TABLA PERSONA Y SU RELACIÓN CON LAS BOLETAS*/ 

CREATE TABLE Persona(
	cedula int primary key,
    NombreCompleto char(100) not null,
	correo char(100) not null,
	celular int not null,
    boleta int not null,   /*Es un array*/    
    fechaNacimiento Date not null,
	genero ENUM('F','M','O') NOT NULL ,
    EPS char(80) not null
);

CREATE TABLE Persona_Boletas(
	Per_cedula int primary key,
	Bol_numSilla int not null,
	FOREIGN KEY (Bol_numSilla) REFERENCES Boleta (numSilla),
    FOREIGN KEY (Per_cedula) REFERENCES Persona (cedula)
);

CREATE TABLE Concierto_Asistentes(
	Nombre_Concierto char(80) primary key not null,
    asistentes int not null,
    FOREIGN KEY (Nombre_Concierto) REFERENCES Concierto (Nombre),
	FOREIGN KEY (asistentes) REFERENCES Persona(cedula)
);

/*CREACIÓN TABLA ZONA Y SU RELACIÓN CON LAS BOLETAS*/

CREATE TABLE Zona(
	numero int primary key,
    cupos int not null,
    precio double not null                              
);

CREATE TABLE Zona_Boleta(
	numero_zona int primary key,
	numSilla_boleta int not null,
	FOREIGN KEY (numero_zona) REFERENCES zona (numero),
	FOREIGN KEY (numSilla_boleta) REFERENCES Boleta (numSilla)
);

CREATE TABLE Concierto_Zonas(
	Nombre_Concierto char(80) primary key not null,
	zona_numero int not null, 
    FOREIGN KEY (Nombre_Concierto) REFERENCES Concierto (Nombre),
    FOREIGN KEY (zona_numero) REFERENCES Zona (numero)
);



/*CREACIÓN TABLA ADMINISTRADOR*/ 

CREATE TABLE Administrador(
	Nombre_Concierto CHAR(100) not null,
    FOREIGN KEY (Nombre_Concierto) REFERENCES Concierto (Nombre)
);

