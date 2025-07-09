package com.cognizant.springdata.hibernate;

import org.springframework.stereotype.Service;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.util.List;

import com.cognizant.springdata.jpa.model.Employee;

@Service
public class HibernateEmployeeService {
    
    private SessionFactory sessionFactory;
    
    public HibernateEmployeeService() {
        try {
            // Initialize Hibernate SessionFactory
            org.hibernate.cfg.Configuration configuration = new org.hibernate.cfg.Configuration();
            configuration.configure("hibernate.cfg.xml");
            sessionFactory = configuration.buildSessionFactory();
        } catch (Exception e) {
            System.err.println("Failed to create sessionFactory object." + e);
            throw new ExceptionInInitializerError(e);
        }
    }
    
    public Employee createEmployee(String name, String department, Double salary) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        Employee employee = null;
        
        try {
            transaction = session.beginTransaction();
            employee = new Employee();
            employee.setName(name);
            employee.setDepartment(department);
            employee.setSalary(salary);
            session.save(employee);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return employee;
    }
    
    public List<Employee> getAllEmployees() {
        Session session = sessionFactory.openSession();
        try {
            Query<Employee> query = session.createQuery("FROM Employee", Employee.class);
            return query.list();
        } finally {
            session.close();
        }
    }
    
    public Employee getEmployeeById(Integer id) {
        Session session = sessionFactory.openSession();
        try {
            return session.get(Employee.class, id);
        } finally {
            session.close();
        }
    }
    
    public void updateEmployee(Employee employee) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        
        try {
            transaction = session.beginTransaction();
            session.update(employee);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    
    public void deleteEmployee(Integer id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        
        try {
            transaction = session.beginTransaction();
            Employee employee = session.get(Employee.class, id);
            if (employee != null) {
                session.delete(employee);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
} 