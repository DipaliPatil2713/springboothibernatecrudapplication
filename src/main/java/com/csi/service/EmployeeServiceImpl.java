package com.csi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csi.dao.EmployeeDao;
import com.csi.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDaoImpl;

	@Override
	public void signUp(Employee employee) {
		// TODO Auto-generated method stub
		employeeDaoImpl.signUp(employee);
	}

	@Override
	public boolean signIn(String empEmailId, String empPassword) {
		// TODO Auto-generated method stub
		return employeeDaoImpl.signIn(empEmailId, empPassword);
	}

	@Override
	public Employee findById(int empId) {
		// TODO Auto-generated method stub
		return employeeDaoImpl.findById(empId);
	}

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return employeeDaoImpl.findAll();
	}

	@Override
	public void updateData(Employee employee, int empId) {
		// TODO Auto-generated method stub
		employeeDaoImpl.updateData(employee, empId);
	}

	@Override
	public void deleteById(int empId) {
		// TODO Auto-generated method stub
		employeeDaoImpl.deleteById(empId);
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		employeeDaoImpl.deleteAll();
	}

}
