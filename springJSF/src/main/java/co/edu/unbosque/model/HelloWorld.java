package co.edu.unbosque.model;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class HelloWorld {

	  private String firstName = "John";
	  private String lastName = "Doe";
	  private String greeting = "Hello " + firstName + " " + lastName + "!";;

	  public String getFirstName() {
	    return firstName;
	  }

	  public void setFirstName(String firstName) {
	    this.firstName = firstName;
	  }

	  public String getLastName() {
	    return lastName;
	  }

	  public void setLastName(String lastName) {
	    this.lastName = lastName;
	  }

	public String getGreeting() {
		return greeting;
	}

	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}
	}