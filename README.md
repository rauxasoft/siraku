#SIRAKU S.A.

Inclusión de Dozer:

- Se añade dependencia en pom.xml
- Se crea fichero de mapping "dozer-configuration-mapping.xml" en resources.
- Se configura DozerConfig para añadir el bean DozerBeanMapper en el application context.
- Se añade fichero "spring-devtools.properties" en la carpeta resources/META-INF para permitir que Dozer funcione en desarrollo.