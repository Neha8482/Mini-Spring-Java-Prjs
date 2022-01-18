package com.xoriant.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.xoriant.beans.Employee;

public class EmployeeDaoImpl implements EmployeeDAO {

	private SessionFactory factory;
	
	public EmployeeDaoImpl() {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
		factory = meta.getSessionFactoryBuilder().build();
	}

	@Override
	public Integer addEmployee(Employee employee) {
		Integer empId = null;
		Session session = factory.openSession();
		Transaction txn = session.beginTransaction();
		empId = (Integer)session.save(employee);
		txn.commit();
		session.close();
		return empId;
	}

	@Override
	public void updateEmployee(Integer employeeId,int exp) {
		Session session = factory.openSession();
		Transaction txn = session.beginTransaction();
		Employee employee = session.get(Employee.class, employeeId);
		employee.setExp(exp);
		session.update(employee);
		txn.commit();
		session.close();
	}

	@Override
	public void deleteEmployee(Integer employeeId) {
		Session session = factory.openSession();
		Transaction txn = session.beginTransaction();
		Employee employee = session.get(Employee.class, employeeId);
		session.delete(employee);
		txn.commit();
		session.close();
		
	}

	@Override
	public List<Employee> listEmployees() {
		List<Employee> employees = null;
		Session session =  factory.openSession();
		Transaction txn = session.beginTransaction();
		String hql = "FROM Employee";
		TypedQuery<Employee> query = session.createQuery(hql);
		employees = query.getResultList();
		session.close();
	    return employees;
	}

	@Override
	public List<String> getEmployeeNames() {
		List<String> names = null;
		Session session = factory.openSession();
		Transaction txn = session.beginTransaction();
		String hql = "Select e.empName FROM Employee e";
		TypedQuery<String> query = session.createQuery(hql);
		names = query.getResultList();
		return names;
	}


	@Override
	public List<Employee> searchByID(Integer id) {
		List<Employee> employees = null;
		Session session = factory.openSession();
		Transaction txn = session.beginTransaction();
		String hql = "FROM Employee e where e.empID = "+id;
		TypedQuery<Employee> query = session.createQuery(hql);
		employees = query.getResultList();
		return employees;
	}
	
	public List<Employee> orderByNames(){
		List<Employee> employees = null;
		Session session = factory.openSession();
		Transaction txn = session.beginTransaction();
		String hql = "FROM Employee e where e.empID < 10 Order by e.empName"; 
		TypedQuery<Employee> query = session.createQuery(hql);
		employees = query.getResultList();
		return employees;
	}

}
