Tareas a realizar

1.- "Mudanza" de anotaciones de persistencia a las nuevas clases "PL".

Hemos de crear las nuevas clases:

- ClientePL
- DireccionPL
- DatosContactoPL
- ProductoPL
- FamiliaPL

2.- Configurar el fichero de mapping XML de Dozer

3.- Reimplementamos los servicios de business


- ClienteServices
- ProductoServices

================================0

Observaciones:

Dentro de la clase ClientePL, los atributos direccion y datosContacto se definirán de la siguiente forma:

private DireccionPL direccion;
private DatosContactoPL datosContacto;

Dentro de la clase ProductoPL, el atributo de familia se definirá de la siguiente forma:

private FamiliaPL familia;
	
	








