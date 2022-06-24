<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>ciraku</title>
	</head>
	<body>
	
		<jsp:include page="header.jsp"/>
		<h2>Nuevo Comercial</h2>
		
        <form:form method="POST" action="/siraku/addComercial" modelAttribute="comercial">
             
             <table>
             
                <tr>
                    <td><form:label path="nombre">Nombre</form:label></td>
                    <td><form:input path="nombre"/></td>
                </tr>
                
                <tr>
                    <td><form:label path="apellido1">Apellido1</form:label></td>
                    <td><form:input path="apellido1"/></td>
                </tr>
                
                <tr>
                    <td><form:label path="apellido2">Apellido2</form:label></td>
                    <td><form:input path="apellido2"/></td>
                </tr>
                
                <tr>
                    <td><input type="submit" value="CREAR COMERCIAL"/></td>
                </tr>
                
            </table>
        </form:form>	
	</body>
</html>