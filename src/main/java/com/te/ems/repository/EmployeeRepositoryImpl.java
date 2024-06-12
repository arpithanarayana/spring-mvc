package com.te.ems.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.te.ems.entity.Employee;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository{
	private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("MySQL01");
	private EntityManager entityManager = entityManagerFactory.createEntityManager();

	@Override
	public String registerEmployee(Employee employee) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(employee);
		entityTransaction.commit();
		return employee.getEmployeeId();
	}

	@Override
	public boolean login(String employeeId, String password) {
		Employee employee = entityManager.find(Employee.class, employeeId);
		if(employee!=null && employee.getPassword().equals(password)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean forgotPassword(String employeeId, String password, String newpassword, String retypepassword) {
		Employee employee = entityManager.find(Employee.class, employeeId);
		if(employee!=null && password!=null && employee.getPassword().equals(password)
				&& newpassword.equals(retypepassword)) {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			employee.setPassword(newpassword);
			entityManager.persist(employee);
			entityTransaction.commit();
			return true;
		}
		return false;
	}
	
	@Override
	public boolean updateEmployee(String employeeId, String employeeEmail) {
         Employee employee = entityManager.find(Employee.class, employeeId);
         if(employee!=null && employee.getEmployeeId().equals(employeeId)) {
        	 EntityTransaction entityTransaction = entityManager.getTransaction();
        	 entityTransaction.begin();
        	 employee.setEmployeeEmail(employeeEmail);
        	 entityManager.persist(employee);
        	 entityTransaction.commit();
        	 return true;
         }
		return false;
	}

	@Override
	public boolean deleteEmployee(String employeeId) {
		Employee employee = entityManager.find(Employee.class, employeeId);
		if(employee!=null) {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(employee);
			entityTransaction.commit();
			return true;
		}
		return false;
	}

	@Override
	public List<Employee> fetchAllEmployee() {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Query query = entityManager.createQuery("FROM Employee");
		List resultList = query.getResultList();
		entityTransaction.commit();
		return resultList;
	}

	

}
