package com.eg.emp.dao;


import java.util.List;

import com.eg.emp.model.Employee;

public interface EmployeeDAO {

	  public List<Employee> getEmployees();
	  
	  public Employee createEmployee(Employee emp);
	  
	  public String updateEmployee(Employee emp);
	  
	  public Employee deleteEmployeeById(Employee emp);
	  
	  public List<Employee> deleteEmployeeByCompName(Employee emp);
	  
	  public List<Employee> searchEmployee(Employee emp);
	  
	  public List<Employee> getSortedEmployee();
}

