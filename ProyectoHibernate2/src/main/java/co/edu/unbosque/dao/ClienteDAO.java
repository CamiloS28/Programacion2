package co.edu.unbosque.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import co.edu.unbosque.dto.ClienteDTO;

public class ClienteDAO implements ICrud{

	private List<ClienteDTO> listaClientes;

	public List<ClienteDTO> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(List<ClienteDTO> listaClientes) {
		this.listaClientes = listaClientes;
	}

	//Imprimir por consola
	private void listarClientes(List<ClienteDTO> listaClientes) {
		for (ClienteDTO cliente : listaClientes) {
			System.out.println(cliente);
		}
	}

//********************IMPLEMENTACIÓN DE LOS METODOS DE LA INTERFAZ ICRUD *********************/
	@Override
	public String agregar(Object registro) {
		// TODO Auto-generated method stub
		String resultado;
		SessionFactory miFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(ClienteDTO.class)
				.buildSessionFactory();

		Session miSession = miFactory.openSession();
		try {
			miSession.beginTransaction();
			miSession.save((ClienteDTO)registro);
			miSession.getTransaction().commit();
			//System.out.println("Registro Insertado!");
			resultado = "OK";
			miSession.close();
		} catch (Exception e) {
			resultado = e.toString();
		} finally {
			miFactory.close();
		}
		return resultado;
	}

	@Override
	public Object consultar() {
		// TODO Auto-generated method stub
		SessionFactory miFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(ClienteDTO.class)
				.buildSessionFactory();
		Session miSession = miFactory.openSession();
		try {
			miSession.beginTransaction();
			listaClientes = miSession.createQuery("from ClienteDTO").getResultList();
			listarClientes(listaClientes);
			miSession.getTransaction().commit();
			miSession.close();
		} catch (Exception e) {
			listaClientes=null;
			//resultado = e.toString();
		} finally {
			miFactory.close();
		}		
		return listaClientes;
	}

	@Override
	public String actualizar(Object id, Object registro) {
		// TODO Auto-generated method stub
		String resultado;
		SessionFactory miFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(ClienteDTO.class)
				.buildSessionFactory();
		Session miSession = miFactory.openSession();

		try {
			miSession.beginTransaction();
			ClienteDTO miCliente = miSession.get(ClienteDTO.class, (int)id);
			miCliente = (ClienteDTO) registro;
			miSession.getTransaction().commit();
			resultado = "OK";
			miSession.close();
		} catch (Exception e) {
			resultado = e.toString();
		} finally {
			miFactory.close();
		}		
		return resultado;
	}

	@Override
	public String eliminar(Object id) {
		// TODO Auto-generated method stub
		String resultado;
		SessionFactory miFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(ClienteDTO.class)
				.buildSessionFactory();
		Session miSession = miFactory.openSession();

		try {
			miSession.beginTransaction();
			miSession.createQuery("delete Clientes where id="+(int)id).executeUpdate();
			miSession.getTransaction().commit();
			resultado = "OK";
			miSession.close();
		} catch (Exception e) {
			resultado = e.toString();
		} finally {
			miFactory.close();
		}		
		return resultado;
	}

	@Override
	public Object listar() {
		// TODO Auto-generated method stub
		return null;
	}
	public int generarId() {
		int id;
		SessionFactory miFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(ClienteDTO.class)
				.buildSessionFactory();
		Session miSession = miFactory.openSession();

		try {
			miSession.beginTransaction();
			Query query = miSession.createQuery("select max(id)+1 as id from ClienteDTO");
			List numeros = query.getResultList();
			id = (int)numeros.get(0);
			miSession.close();
		} catch (Exception e) {
			id = -1;
		} finally {
			miFactory.close();
		}		
		return id;		
	}
	
}
