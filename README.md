#SIRAKU S.A.

Inclusión de Dozer:

- Se añade dependencia en pom.xml
- Se crea fichero de mapping "dozer-configuration-mapping.xml" en resources.
- Se configura DozerConfig para añadir el bean DozerBeanMapper en el application context.
- Se añade fichero "spring-devtools.properties" en la carpeta resources/META-INF para permitir que Dozer funcione en desarrollo.


Inclusión de páginas JSP:

- Se añaden dependencias en el pom.xml (JSP y JSTL)
- Indicamos en application.properties dónde están las vistas. (las páginas JSP)
- Creamos las carpetas /webapp/WEB-INF/vistas en la carpeta main
- Creamos fichero JSP dentro de vistas (home.jsp)
- Creamos el controlador (@Controller) que devolverá la página home.jsp
