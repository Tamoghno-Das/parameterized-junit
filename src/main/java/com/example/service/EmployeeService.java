package com.example.service;

import com.example.exception.EmployeeNotFoundException;
import com.example.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeService {
    private List<Employee> employees = new ArrayList<>();
    Employee e = new Employee();

    public void addEmployee(Employee e)
    {
        employees.add(e);
    }
    public Employee getEmployee(int id) throws EmployeeNotFoundException
    {
        return employees.stream()
                .filter(e -> e.getId()==id)
                .findFirst().orElseThrow(()->new EmployeeNotFoundException
                        ("Employee not found with id "+id));
    }

    public boolean updateEmployee(int id, Employee e)  throws EmployeeNotFoundException{
        for(Employee e1: employees)
        {
            if(e1.getId()==id)
            {
                e1.setName(e.getName());
                e1.setSalary(e.getSalary());
                return true;
            }
        }
        throw new EmployeeNotFoundException("Employee not found with id "+id);
    }

    public boolean deleteEmployee(int id)
    {
        employees.removeIf(e2 -> e2.getId() == id);
        return true;
    }
    public List<Employee> getAllEmployees()
    {
        return employees;
    }
}
