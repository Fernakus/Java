/*  -------------------------------------------------------
  *  Employee.java
 *  -------------------------------------------------------
 *  Author:  Matthew Ferlaino
 *  Course:	 COSC2006A
 *  ID:      169657520
 *  Email:   mferlaino@algomau.ca
 *  Date:	 Mar 2, 2019
 *  ------------------------------------------------------- */

// Imports
import java.io.Serializable;

public class Employee implements Serializable{
	// Data Members
	private String firstName, lastName, jobPosition, username, password, employeeId;
	private double salary;
	private static final long serialVersionUID = 1600408968359349958L;
			
	// No-arg constructor
	public Employee() {
		firstName = lastName = jobPosition = username = password = employeeId = null;
		salary = 0.0;
	}
	
	// Getters
	// getName()
	public String getName() {
		return firstName;
	}
	
	// getSirname
	public String getSirname() {
		return lastName;
	}
	
	// getPosition
	public String getPosition() {
		return jobPosition;
	}
	
	// getUser()
	public String getUsername() {
		return username;
	}
	
	// getPass()
	public String getPass() {
		return password;
	}
	
	// getId()
	public String getId() {
		return employeeId;
	}

	// getSalary()
	public double getSalary() {
		return salary;
	}
	
	// Setters
	// setName()
	public void setName(String firstName) {
		this.firstName = firstName;
	}
	
	// setSirname()
	public void setSirname(String lastName) {
		this.lastName = lastName;
	}
	
	// setPosition()
	public void setPosition(String jobPosition) {
		this.jobPosition = jobPosition;
	}
	
	// setUser()
	public void setUsername(String username) {
		this.username = username;
	}

	// setPass()
	public void setPass(String password) {
		this.password = password;
	}

	// setId()
	public void setId(String employeeId) {
		this.employeeId = employeeId;
	}

	// setSalary()
	public void setSalary(double salary) {
		this.salary = salary;
	}
}
