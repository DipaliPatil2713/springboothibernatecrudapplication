package com.csi.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "EMPLOYEE")
public class Employee {

	@Id
	@GeneratedValue
	private int empId;

	private String empName;

	private String empAddress;

	private double empSalary;

	private long empContactNumber;

	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date empDOB;

	private String empEmailId;

	private String empPassword;

}
