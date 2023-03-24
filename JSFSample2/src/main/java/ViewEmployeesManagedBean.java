import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class ViewEmployeesManagedBean {
	
	private ArrayList<Employee> employees = new ArrayList<Employee>();

	public ViewEmployeesManagedBean() {

	}

	@PostConstruct
	public void populateEmployeeList() {
		for (int i = 1; i <= 10; i++) {
			Employee emp = new Employee();
			emp.setEmployeeId(String.valueOf(i));
			emp.setEmployeeName("Employee#" + i);
			this.employees.add(emp);
		}
	}

	public ArrayList<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(ArrayList<Employee> employees) {
		this.employees = employees;
	}
}
