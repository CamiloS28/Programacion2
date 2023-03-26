<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Actividad 1</title>
<script language="Javascript">
	function valida_envia(form) {
		if (form.usuario.value == "") {
			alert("Debe ingresar un nombre de usuario");
			form.usuario.focus();
			return;
		}
		if (form.clave.value == "") {
			alert("Debe ingresar la clave");
			form.clave.focus();
			return;
		}
		if (form.prof.value == "") {
			alert("Debe ingresar la profesión");
			form.prof.focus();
			return;
		}
		form.submit();
	}
</script>
</head>
<body>
	<h2>Formularios y validaciones</h2>
	<form action="EjemploServlet" method="post">
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
				<td><input type="button" value="Aceptar"
					onCLick="valida_envia(this.form)" /></td>
			</tr>
		</table>
	</form>
</body>
</html>