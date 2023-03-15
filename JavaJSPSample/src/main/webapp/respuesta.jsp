<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	String usuario = request.getParameter("usuario");
	String clave = request.getParameter("clave");
	String profesion = request.getParameter("prof");
%>
<html>
<head>
<meta charset="UTF-8">
<title>Respuesta desde el JSP</title>
</head>
<body>
	<% out.println("<h1>Resultados del Formulario</h1>"); %>
	<p>Se leyeron los siguientes valores:</p><br>
	<p>Usuario: <%=usuario%></p><br>
	<p>Clave: <%=clave%></p><br>
	<p>Profesi&oacute;n: <%=profesion%></p><br>
	<a href="inicio.jsp"> Volver </a>
</body>
</html>