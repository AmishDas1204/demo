package com.eg.emp.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eg.emp.dao.EmployeeDAO;
import com.eg.emp.model.Employee;

@RestController
@RequestMapping(value="/")
@CrossOrigin(origins={"http://localhost:4200"})
public class EmployeeController {
    
	@Autowired
	private EmployeeDAO edao;
	
	@RequestMapping(value="/listemp",method=RequestMethod.GET)
	public List<Employee> getEmployees(){
		return edao.getEmployees();
	}
	
	@RequestMapping(value="/create",method=RequestMethod.POST)
	public Employee createEmployee(@RequestBody Employee emp){
		return edao.createEmployee(emp);
	}
	
	@RequestMapping(value="/deleteById",method=RequestMethod.POST)
	public Employee deleteEmployeeById(@RequestBody Employee emp) {
		return edao.deleteEmployeeById(emp);
	}
	
	@RequestMapping(value="/deleteByCompName",method=RequestMethod.POST)
	public List<Employee> deleteEmployeeByCompName(@RequestBody Employee emp) {
		return edao.deleteEmployeeByCompName(emp);
	}
	
	@RequestMapping(value="/update",method=RequestMethod.PUT)
	public String updateEmployee(@RequestBody Employee emp) {
		return edao.updateEmployee(emp);
	}
	
	@RequestMapping(value="/search",method=RequestMethod.POST)
	public List<Employee> searchEmployee(@RequestBody Employee emp){
		return edao.searchEmployee(emp);
	}
	
	@RequestMapping(value="/sort",method=RequestMethod.GET)
	public List<Employee> getSortedEmployee(){
		return edao.getSortedEmployee();
	}
	
}
