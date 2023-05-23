package co.edu.unbosque.model;

import java.util.List;

import co.edu.unbosque.dao.StudentDAO;
import co.edu.unbosque.dto.StudentDTO;

public class App {
	
	public static void main(String[] args) {
		StudentDAO studentdao = new StudentDAO();
		StudentDTO student = new StudentDTO("Jorge","Ramirez", "jramirez@algo.com");
		studentdao.saveStudent(student);
		StudentDTO student2 = studentdao.getStudentById(student.getId());
		List<StudentDTO> students = studentdao.getAllStudents();
		students.forEach(student1 -> System.out.println(student1.getEmail()));
		studentdao.deleteStudent(student.getId());
	}
}
