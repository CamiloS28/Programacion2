package co.edu.unbosque.model;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ConsultaClientes {
	
	private List<Clientes> listaClientes;
	
	public static void main(String[] args) {
		SessionFactory miFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Clientes.class)
				.buildSessionFactory();
		Session miSession = miFactory.openSession();
		try {
			miSession.beginTransaction();
			List<Clientes> listaClientes = 
					miSession.createQuery("from Clientes").getResultList();
			listarClientes(listaClientes);
			
			listaClientes = 
					miSession.createQuery("from Clientes where direccion='Calle2' or nombre='Alberto'")
					.getResultList();
			listarClientes(listaClientes);
			System.out.println("Resultado:"+generarId());
			miSession.getTransaction().commit();
			
			miSession.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			miFactory.close();
		}
	}

	private static void listarClientes(List<Clientes> listaClientes) {
		for(Clientes cliente:listaClientes) {
			System.out.println(cliente);
		}
	}
	
	public static int generarId() {
		int id;
		SessionFactory miFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Clientes.class)
				.buildSessionFactory();
		Session miSession = miFactory.openSession();

		try {
			miSession.beginTransaction();
			Query query = miSession.createQuery("select max(id)+1 as id from Clientes");
			List numeros = query.getResultList();
			id = (int)numeros.get(0);
			miSession.close();
		} catch (Exception e) {
			e.printStackTrace();
			id = -1;
		} finally {
			miFactory.close();
		}		
		return id;		
	}
	
	public Object consultar() {
		// TODO Auto-generated method stub
		SessionFactory miFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Clientes.class)
				.buildSessionFactory();
		Session miSession = miFactory.openSession();
		try {
			miSession.beginTransaction();
			listaClientes = miSession.createQuery("from Clientes").getResultList();
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
}
