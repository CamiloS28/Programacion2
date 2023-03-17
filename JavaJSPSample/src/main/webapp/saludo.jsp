<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="DemoServlet" method="post">
		<table border="0">
			<tr>
				<td>Usuario:</td>
				<td><input type="text" name="usuario" value="" /></td>
			</tr>
			<tr>
				<td>Clave:</td>
				<td><input type="password" name="clave" value="" /></td>
			</tr>
			<tr>
				<td>Profesi&oacute;n:</td>
				<td>
					<select name="prof">
						<option value="0">Seleccione..</option>
						<option value="1">Ingeniero</option>
						<option value="2">Contador</option>
						<option value="3">Economista</option>
						<option value="4">Vigilante</option>
						<option value="5">Docente</option>
						<option value="6">Director</option>
					</select>
				</td>
			</tr>
			<tr>
				<td><input type="submit" value="Aceptar" /></td>
			</tr>
		</table>
	</form>
</body>
</html>