package co.edu.unbosque.model;

import java.util.List;

import javax.faces.bean.ManagedBean;
import co.edu.unbosque.dao.ClienteDAO;
import co.edu.unbosque.dto.ClienteDTO;

@ManagedBean
public class ClienteBean {

	private int id;
	private String nombre;
	private String apellidos;
	private String direccion;
	private String resultado;
	private List<ClienteDTO> listaClientes;
	
	
	public List<ClienteDTO> getListaClientes() {
		return listaClientes;
	}
	public void setListaClientes(List<ClienteDTO> listaClientes) {
		this.listaClientes = listaClientes;
	}
	public String getResultado() {
		return resultado;
	}
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public String agregar() {
		ClienteDAO cl = new ClienteDAO();
		this.id = cl.generarId();
		this.resultado = cl.agregar(new ClienteDTO(this.id,this.nombre, this.apellidos,this.direccion));
		this.listaClientes = (List<ClienteDTO>)cl.consultar();
		if(this.resultado.equals("OK") && this.listaClientes!=null) {
			return "tablaclientes.xhtml";
		}
		else {
			return "error.xhtml";
		}
	}
	
	public String consultar() {
		ClienteDAO cl = new ClienteDAO();
		this.listaClientes = (List<ClienteDTO>)cl.consultar();
		if(this.listaClientes!=null) {
			return "tablaclientes.xhtml";
		}
		else {
			return "error.xhtml";
		}
	}
}
