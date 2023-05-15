package co.edu.unbosque.model;

import javax.faces.bean.ManagedBean;
import co.edu.unbosque.dao.UsuarioDAO;
import co.edu.unbosque.dto.UsuarioDTO;

@ManagedBean
public class UsuarioBean {
	
	private int codigo;
	private String nombre;
	private String resultado;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getResultado() {
		return resultado;
	}
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	public String registrar() {
		UsuarioDAO us = new UsuarioDAO();
		this.resultado = us.agregar(new UsuarioDTO(this.codigo,this.nombre));
		if(this.resultado.equals("OK")) {
			return "registrar.xhtml";
		}
		else {
			return "error.xhtml";
		}
	}
}
