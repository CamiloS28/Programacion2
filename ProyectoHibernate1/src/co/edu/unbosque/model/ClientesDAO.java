package co.edu.unbosque.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ClientesDAO {

	private static List<Clientes> listaClientes;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Clientes cliente1 = new Clientes(1,"Alberto","Garcia","Calle");
		// agregarCliente(new Clientes(5,"David","Valencia","Calle5"));
		// consultarCliente();
		// actualizarNombreCliente(3,"Ana Lucia");
		// eliminarCliente(2);
		// consultarCliente();
	}

	//Agregar Cliente
	public static void agregarCliente(Clientes cliente1) {
		SessionFactory miFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Clientes.class)
				.buildSessionFactory();

		Session miSession = miFactory.openSession();
		try {
			miSession.beginTransaction();
			miSession.save(cliente1);
			miSession.getTransaction().commit();
			System.out.println("Registro Insertado!");
			miSession.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			miFactory.close();

		}
	}
	
	// Consultar
	public static void consultarCliente() {
		SessionFactory miFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Clientes.class)
				.buildSessionFactory();
		Session miSession = miFactory.openSession();
		try {
			miSession.beginTransaction();
			listaClientes = miSession.createQuery("from Clientes").getResultList();
			listarClientes(listaClientes);

			listaClientes = miSession.createQuery("from Clientes where direccion='Calle2' or nombre='Alberto'")
					.getResultList();
			listarClientes(listaClientes);
			miSession.getTransaction().commit();
			miSession.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			miFactory.close();
		}
	}
	

	// Actualizar
	public static void actualizarNombreCliente(int idCliente, String nombre) {
		SessionFactory miFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Clientes.class)
				.buildSessionFactory();
		Session miSession = miFactory.openSession();

		try {
			miSession.beginTransaction();
			Clientes miCliente = miSession.get(Clientes.class, idCliente);
			miCliente.setNombre(nombre);
			miSession.getTransaction().commit();
			System.out.println("Nombre modificado!");
			miSession.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			miFactory.close();
		}
	}
	

	//Eliminar
	public static void eliminarCliente(int idCliente) {
		SessionFactory miFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Clientes.class)
				.buildSessionFactory();
		Session miSession = miFactory.openSession();

		try {
			miSession.beginTransaction();
			miSession.createQuery("delete Clientes where id="+idCliente).executeUpdate();
			miSession.getTransaction().commit();
			System.out.println("Nombre eliminado!");
			miSession.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			miFactory.close();
		}
	}
	
	//Imprimir
	private static void listarClientes(List<Clientes> listaClientes) {
		System.out.println(" --- Listado Cliente");
		for (Clientes cliente : listaClientes) {
			System.out.println(cliente);
		}
	}
}
