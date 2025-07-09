package com.cognizant.springdata.jpa;

import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Service
public class JPAEmployeeService {
    
    @PersistenceContext
    private EntityManager entityManager;
    
    public Employee createEmployee(String name, String department, Double salary) {
        Employee employee = new Employee();
        employee.setName(name);
        employee.setDepartment(department);
        employee.setSalary(salary);
        
        entityManager.persist(employee);
        return employee;
    }
    
    public List<Employee> getAllEmployees() {
        TypedQuery<Employee> query = entityManager.createQuery(
            "SELECT e FROM Employee e", Employee.class);
        return query.getResultList();
    }
    
    public Employee getEmployeeById(Integer id) {
        return entityManager.find(Employee.class, id);
    }
    
    public void updateEmployee(Employee employee) {
        entityManager.merge(employee);
    }
    
    public void deleteEmployee(Integer id) {
        Employee employee = entityManager.find(Employee.class, id);
        if (employee != null) {
            entityManager.remove(employee);
        }
    }
} 