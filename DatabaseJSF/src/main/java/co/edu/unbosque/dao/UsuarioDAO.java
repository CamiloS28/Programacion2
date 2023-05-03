package co.edu.unbosque.dao;

import co.edu.unbosque.dto.UsuarioDTO;
import co.edu.unbosque.persistence.MySQLDB;

public class UsuarioDAO implements ICrud {

	private UsuarioDTO usuario;
	private String cadena;

	@Override
	public String agregar(Object registro) {
		// TODO Auto-generated method stub
		MySQLDB ms = new MySQLDB();
		usuario = (UsuarioDTO) registro;
		cadena = "INSERT INTO USUARIO VALUES(" 
		+ usuario.getCodigo() + ",\'" 
		+ usuario.getNombre() + "\');";
		return ms.insertarDB(cadena);
	}

	@Override
	public Object listar() {
		// TODO Auto-generated method stub
		return null;
	}

	public UsuarioDTO getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}

	public String getCadena() {
		return cadena;
	}

	public void setCadena(String cadena) {
		this.cadena = cadena;
	}

	
	
}
