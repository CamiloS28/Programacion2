package co.edu.unbosque.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GuardaClientePrueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory miFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Clientes.class)
				.buildSessionFactory();
		
		Session miSession = miFactory.openSession();
		
		try {
			Clientes cliente1 = new Clientes(1,"Alberto","Garcia","Calle");
			miSession.beginTransaction();
			miSession.save(cliente1);
			miSession.getTransaction().commit();
			System.out.println("Registro Insertado!");
			miSession.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			miFactory.close();
		}
	}
}
