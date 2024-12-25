package com.csi.service;

import java.util.List;

import com.csi.model.Employee;

public interface EmployeeService {
	
	void signUp(Employee employee);

	boolean signIn(String empEmailId, String empPassword);

	Employee findById(int empId);

	List<Employee> findAll();

	void updateData(Employee employee, int empId);

	void deleteById(int empId);

	void deleteAll();

}
