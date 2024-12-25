package com.csi.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.springframework.stereotype.Component;

import com.csi.model.Employee;

@Component
public class EmployeeDaoImpl implements EmployeeDao {

	private static SessionFactory factory = new AnnotationConfiguration().configure().buildSessionFactory();

	@Override
	public void signUp(Employee employee) {
		// TODO Auto-generated method stub

		Session session = factory.openSession();

		Transaction transaction = session.beginTransaction();

		session.save(employee);

		transaction.commit();

	}

	@Override
	public boolean signIn(String empEmailId, String empPassword) {
		// TODO Auto-generated method stub

		boolean flag = false;

		for (Employee employee : findAll()) {
			if (employee.getEmpEmailId().equals(empEmailId) && employee.getEmpPassword().equals(empPassword)) {
				flag = true;
				break;
			}
		}

		return flag;
	}

	@Override
	public Employee findById(int empId) {
		// TODO Auto-generated method stub

		Session session = factory.openSession();

		return (Employee) session.get(Employee.class, empId);

	}

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub

		Session session = factory.openSession();

		return session.createQuery("from Employee").list();
	}

	@Override
	public void updateData(Employee employee, int empId) {
		// TODO Auto-generated method stub

		Session session = factory.openSession();

		Transaction transaction = session.beginTransaction();

		Employee employee2 = findById(empId);

		employee2.setEmpName(employee.getEmpName());
		employee2.setEmpAddress(employee.getEmpAddress());
		employee2.setEmpSalary(employee.getEmpSalary());
		employee2.setEmpContactNumber(employee.getEmpContactNumber());
		employee2.setEmpDOB(employee.getEmpDOB());
		employee2.setEmpEmailId(employee.getEmpEmailId());
		employee2.setEmpPassword(employee.getEmpPassword());

		session.merge(employee2);

		transaction.commit();
	}

	@Override
	public void deleteById(int empId) {
		// TODO Auto-generated method stub
		Session session = factory.openSession();

		Transaction transaction = session.beginTransaction();

		Employee employee2 = findById(empId);

		session.delete(employee2);

		transaction.commit();
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

		Session session = factory.openSession();

		for (Employee employee : findAll()) {
			Transaction transaction = session.beginTransaction();

			session.delete(employee);

			transaction.commit();
		}
	}

}
