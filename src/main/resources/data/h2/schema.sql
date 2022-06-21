CREATE TABLE PRODUCTOS(
	
	CODIGO			BIGINT				NOT NULL,
	NOMBRE			VARCHAR(150)		,
	PRECIO			DOUBLE				,
	FECHA_ALTA		DATE				,
	FAMILIA			VARCHAR(30)			,
	DESCATALOGADO	BOOLEAN				,
	
	PRIMARY KEY (CODIGO)

);

CREATE TABLE COMERCIALES(

	CODIGO			BIGINT    			NOT NULL,
	NOMBRE			VARCHAR(150)		,
	APELLIDO1		VARCHAR(150)		,
	APELLIDO2		VARCHAR(150)		,
	
	PRIMARY KEY (CODIGO)

);

CREATE TABLE CLIENTES(

	ID					VARCHAR(30)			NOT NULL,
	NOMBRE_COMERCIAL	VARCHAR(200)		,
	NOMBRE				VARCHAR(100)		,
	APELLIDO1			VARCHAR(100)		,
	APELLIDO2			VARCHAR(100)		,
	DIRECCION			VARCHAR(100)		,
	POBLACION			VARCHAR(100)		,
	CODIGO_POSTAL		VARCHAR(5)			,
	PROVINCIA			VARCHAR(100)		,
	PAIS				VARCHAR(100)		,
	TELEFONO1			VARCHAR(30)			,
	TELEFONO2			VARCHAR(30)			,
	EMAIL				VARCHAR(200)		,
	
	PRIMARY KEY (ID)

);

CREATE TABLE PEDIDOS(

	CODIGO				BIGINT				NOT NULL,
	ID_CLIENTE			VARCHAR(30)			,
	CODIGO_COMERCIAL	BIGINT				,
	FECHA_HORA			TIMESTAMP			,
	OBSERVACIONES		VARCHAR(250)		,
	
	PRIMARY KEY (CODIGO),
	FOREIGN KEY (ID_CLIENTE) REFERENCES CLIENTES (ID),
	FOREIGN KEY (CODIGO_COMERCIAL) REFERENCES COMERCIALES (CODIGO)

);

CREATE TABLE LINEAS_PEDIDO(

	CODIGO_PRODUCTO		BIGINT				NOT NULL,
	CANTIDAD			INTEGER				,
	CODIGO_PEDIDO		BIGINT				,
	ORDEN				INTEGER				,
	
	FOREIGN KEY(CODIGO_PRODUCTO) REFERENCES PRODUCTOS (CODIGO),
	FOREIGN KEY(CODIGO_PEDIDO) REFERENCES PEDIDOS (CODIGO)

);



