package com.eg.emp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.eg.emp.model.Employee;


@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

	
	@Autowired
	private MongoTemplate mTemplate;
	
	@Override
	public List<Employee> getEmployees() {
		
		return mTemplate.findAll(Employee.class);
	}

	@Override
	public Employee createEmployee(Employee emp) {
		// TODO Auto-generated method stub
		mTemplate.insert(emp);
		return emp;
	}

	@Override
	public String updateEmployee(Employee emp) {
		String s;
		if(mTemplate.findById(emp.getEmpId(), Employee.class) != null)
		{
			mTemplate.save(emp);
			s="Success";
		}
		else{
			s="failure";
		}
		return s;
	}

	@Override
	public Employee deleteEmployeeById(Employee emp) {
		Query q=new Query();
		q.addCriteria(Criteria.where("empId").is(emp.getEmpId()));
		Employee e=mTemplate.findOne(q, Employee.class);
		mTemplate.remove(e);
		return e;
	}

	@Override
	public List<Employee> searchEmployee(Employee emp) {
		Query q=new Query();
		q.addCriteria(Criteria.where("empId").is(emp.getEmpId()));
		List<Employee> lt=mTemplate.find(q, Employee.class);
		return lt;
	}

	@Override
	public List<Employee> getSortedEmployee() {
		// TODO Auto-generated method stub
		Query q=new Query();
		q.with(new Sort(Sort.Direction.ASC, "_id"));
		return mTemplate.find(q, Employee.class);
	}

	@Override
	public List<Employee> deleteEmployeeByCompName(Employee emp) {
		Query q=new Query();
		q.addCriteria(Criteria.where("compname").is(emp.getCompname()));
		List<Employee> lt=mTemplate.find(q, Employee.class);
		mTemplate.findAllAndRemove(q, Employee.class);
		return lt;
	}

}

