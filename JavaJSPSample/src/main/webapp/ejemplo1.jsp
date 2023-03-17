<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	//manejo de declaraciones y expresiones en JSP
	int n1 = 15;
	int n2 = 10;
	int s;
	%>
	<h4>Suma de dos n&uacute;meros:</h4>
	<%
	s = n1 + n2;
	out.println("n1:" + n1+"<br>");
	out.println("n2:" + n2+"<br>");
	out.println("Suma:" + s+"<br>");
	%>
	<h1>El resultado por HTML es:<%=s %></h1>
</body>
</html>