package com.eg.emp.model;



import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Employee {

	@Id
	private int empId;
	private String firstName;
	private String lastName;
	private String addr;
	private String compname;
	private int salary;
	
	
	
	public Employee() {
		super();
	}
	
	
	
	public Employee(int empId, String firstName, String lastName, String addr, String compname, int salary) {
		super();
		this.empId = empId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.addr = addr;
		this.compname = compname;
		this.salary = salary;
	}
	
	
	public int getEmpId() {
		return empId;
	}
	
	
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	
	
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
	
	
	public String getAddr() {
		return addr;
	}
	
	
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	
	public String getCompname() {
		return compname;
	}
	
	
	public void setCompname(String compname) {
		this.compname = compname;
	}
	
	
	public int getSalary() {
		return salary;
	}
	
	
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	
}
