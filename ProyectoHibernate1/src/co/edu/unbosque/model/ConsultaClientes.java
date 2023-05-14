package co.edu.unbosque.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ConsultaClientes {
	
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
}
