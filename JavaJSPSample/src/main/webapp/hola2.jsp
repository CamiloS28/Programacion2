<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<% String respServlet = request.getAttribute("respuesta").toString(); %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Respuesta Servlet</title>
</head>
<body>
	Respuesta: <h1><%=respServlet %></h1>
</body>
</html>