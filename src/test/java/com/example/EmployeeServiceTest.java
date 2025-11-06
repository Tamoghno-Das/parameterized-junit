package com.example;

import com.example.exception.EmployeeNotFoundException;
import com.example.model.Employee;
import com.example.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeServiceTest {
    private static EmployeeService service;

    @BeforeEach
    void setUp()
    {
        service = new EmployeeService();
    }


    @ParameterizedTest
    @DisplayName("ADD TEST USING CSV 🎨")
    @CsvSource (
            {
                    "1, John, 50000.00",
                    "2, Alice, 60000.00",
                    "3, Bob, 70000.00"
            }
    )
    void addEmployee(int id, String Name, double salary)
    {
        service.addEmployee(new Employee(id,Name,salary));
        try {
            assertEquals(Name,service.getEmployee(id).getName());
        } catch (EmployeeNotFoundException e) {
            IO.println("Invalid choice");
        }

    }

    @Test
    @DisplayName("UPDATE TEST ⚓")
    void updateEmployee()
    {
        service.addEmployee(new Employee(1, "Sam", 40000.00));
        boolean updated =
                false;
        try {
            updated = service.updateEmployee
                    (1,new Employee(1,"samuel",50000.00));
        } catch (EmployeeNotFoundException e) {
            IO.println("Invalid choice");
        }
        assertTrue(updated);
        try {
            assertEquals("samuel", service.getEmployee(1).getName());
        } catch (EmployeeNotFoundException e) {
                IO.println("Invalid choice");
        }
    }

    @Test
    @DisplayName("DELETE TEST🧮")
    void deleteEmployee()
    {
        service.addEmployee(new Employee(1, "John", 40000.00));
        boolean deleted =
                service.deleteEmployee(1);
        assertTrue(deleted);

    }

}