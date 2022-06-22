INSERT INTO SECUENCIAS (NOMBRE, VALOR) VALUES
('PEDIDO_SEQ', 10000),
('COMERCIAL_SEQ', 10000),
('REQUESTLOG_SEQ', 10000),
('PRODUCTO_SEQ', 10000);

INSERT INTO COMERCIALES(CODIGO, NOMBRE, APELLIDO1, APELLIDO2) VALUES
(100,'Pepín','Gálvez','Ridruejo'),
(101,'Honorio','Martín','Salvador'),
(102,'Carlota','Cifuentes','Merino'),
(103,'Anna','Vilchez','Gálvez');

INSERT INTO CLIENTES (ID, NOMBRE_COMERCIAL, NOMBRE, APELLIDO1, APELLIDO2, DIRECCION, POBLACION, CODIGO_POSTAL, PROVINCIA, PAIS, TELEFONO1, TELEFONO2, EMAIL) VALUES
('B46558912','ADEPSA','José Ramón','Fernández','Marín','Avda. Pino, 23','Barcelona','08020','Barcelona','España','93 229 45 66','+34 6203443','admin@adepsa.com'),
('B33298034','CEDIPSA','Marta','Simón','Mirandello','c/ Marte, 33','Madrid','80020','Madrid','España','91 2409089',null,'a.martos@gmail.com'),
('46322456K',null,'Marta','Clara','García','c/Muntaner, 334','Barcelona','08034','Barcelona','España','93 231 88 94','6205667','clara.g@gmail.com'),
('B56672134','Hermanos Mata, S.L.','Carlos','Mata','González','Rambla Ploble Nou 12 2-B','Barcelona','08013','Barcelona','España','932209088',null,'joan.mata@hermanosmata.es'),
('B20098712','GRUMASA','Arturo','Badimón','Tejerina','Avda. Pau Casals, 23','Vendrell','08090','Tarragona','España','+34 620 66 77','+34 620 66 77','clientes@grumasa.es');

INSERT INTO PRODUCTOS (CODIGO, NOMBRE, PRECIO, FECHA_ALTA, FAMILIA, DESCATALOGADO) VALUES 
(100,'Impresora Laser HP 2P plus','540.0','2015-10-21','HARDWARE', FALSE),
(101,'Impresora Laser HP 4P plus Color','1200.0','2015-10-28','HARDWARE', FALSE),
(102,'Alfrombrilla Mouse CR7','2.0','2006-02-14','CONSUMIBLE', TRUE),
(103,'ContaNerd v2 Basic Edition','46.0','2019-04-01','SOFTWARE', FALSE),
(104,'ContaNerd v3 Full Edition','105.5','2020-07-10','SOFTWARE', FALSE),
(105,'Ordenador Epson D10 1x50 1Tb','870','2019-06-05','HARDWARE', FALSE),
(106,'Funda portátil DEXMOR 140PX BLANCA','39.0','2018-11-01','CONSUMIBLE', FALSE),
(107,'Funda portátil DEXMOR 140PX ROJA','39.0','2018-11-01','CONSUMIBLE', FALSE),
(108,'Funda portátil DEXMOR 140PX NEGRA','39.0','2018-11-01','CONSUMIBLE', FALSE);

INSERT INTO PEDIDOS (CODIGO, ID_CLIENTE, CODIGO_COMERCIAL, FECHA_HORA, OBSERVACIONES) VALUES
(1,'B46558912', 101, '2022-06-20',null),
(2,'B56672134', 102, '2022-06-21','Pasan a recoger en furgoneta.');

INSERT INTO LINEAS_PEDIDO (CODIGO_PRODUCTO, CANTIDAD, CODIGO_PEDIDO, ORDEN) VALUES
(105,2,1,0),
(106,1,1,1),
(107,1,1,2),
(102,50,2,0);