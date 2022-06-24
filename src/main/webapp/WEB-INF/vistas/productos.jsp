<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>ciraku</title>
	</head>
	<body>
		<jsp:include page="header.jsp"/>
		<h2>Listado de Productos</h2>
		<table>
			<tr>
				<th>Código</th>
				<th>Nombre</th>
				<th>Primer Apellido</th>
				<th>Segundo Apellido</th>
			</tr>
			<c:forEach var="comer" items="${comerciales}">
			<tr>
				<td>${comer.codigo}</td>
				<td>${comer.nombre}</td>
				<td>${comer.apellido1}</td>
				<td>${comer.apellido2}</td>	
			<tr>
			</c:forEach>
		</table>
	</body>
</html>