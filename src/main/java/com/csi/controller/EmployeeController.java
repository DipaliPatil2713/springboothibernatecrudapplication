package com.csi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.csi.model.Employee;
import com.csi.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/employees")
@Slf4j
public class EmployeeController {

	@Autowired
	private EmployeeService employeeServiceImpl;

	@PostMapping("/signup")
	public ResponseEntity<String> signUp(@RequestBody Employee employee) {

		log.info("Trying to signup for Employee: " + employee.getEmpName());
		employeeServiceImpl.signUp(employee);

		return ResponseEntity.ok("SignUp Done Successfully");
	}

	@GetMapping("/signin/{empEmailId}/{empPassword}")
	public ResponseEntity<Boolean> signIn(@PathVariable String empEmailId, @PathVariable String empPassword) {

		log.info("#########Trying to SignIn for Employee###########: " + empEmailId);
		return ResponseEntity.ok(employeeServiceImpl.signIn(empEmailId, empPassword));
	}

	@GetMapping("/findbyid/{empId}")
	public ResponseEntity<Employee> findById(@PathVariable int empId) {
		return ResponseEntity.ok(employeeServiceImpl.findById(empId));
	}

	@GetMapping("/findall")
	public ResponseEntity<List<Employee>> findAll() {

		return ResponseEntity.ok(employeeServiceImpl.findAll());

	}

	@PutMapping("/updatedata/{empId}")
	public ResponseEntity<String> updateData(@PathVariable int empId, @RequestBody Employee employee) {
		employeeServiceImpl.updateData(employee, empId);

		return ResponseEntity.ok("Data Updated Successfully");
	}

	@DeleteMapping("/deletebyid/{empId}")
	public ResponseEntity<String> deleteById(@PathVariable int empId) {
		employeeServiceImpl.deleteById(empId);

		return ResponseEntity.ok("Data Deleted Successfully");
	}

	@DeleteMapping("deleteall")
	public ResponseEntity<String> deleteAll() {
		employeeServiceImpl.deleteAll();

		return ResponseEntity.ok("All Data Deleted Successfully");
	}

}
