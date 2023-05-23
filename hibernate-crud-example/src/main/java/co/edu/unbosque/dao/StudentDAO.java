package co.edu.unbosque.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import co.edu.unbosque.dto.StudentDTO;
import co.edu.unbosque.util.HibernateUtil;

public class StudentDAO {
	
	public void saveStudent (StudentDTO student) {
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			session.save(student);
			transaction.commit();
		}
		catch(Exception e) {
			transaction.rollback();
		}
	}
	
	public void updateStudent (StudentDTO student) {
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			session.saveOrUpdate(student);
			transaction.commit();
		}
		catch(Exception e) {
			transaction.rollback();
		}
	}
	
	public StudentDTO getStudentById (long id) {
		Transaction transaction = null;
		StudentDTO student = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			student = session.get(StudentDTO.class, id);
			transaction.commit();
			session.close();
		}
		catch(Exception e) {
			transaction.rollback();
		}
		return student;
	}
	
	@SuppressWarnings("unchecked")
	public List<StudentDTO> getAllStudents () {
		Transaction transaction = null;
		List<StudentDTO> students = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			students = session.createQuery("from StudentDTO").list();
			transaction.commit();
		}
		catch(Exception e) {
			transaction.rollback();
		}
		return students;
	}
	
	public void deleteStudent(long id) {
		Transaction transaction = null;
		StudentDTO student = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			student = session.get(StudentDTO.class, id);
			session.delete(student);
			transaction.commit();
		}
		catch(Exception e) {
			transaction.rollback();
		}
	}
	
}
