package com.example.main;
import com.example.model.Employee;
import com.example.service.EmployeeService;

public class MainApp {
    static void main() {
         EmployeeService e = new EmployeeService();
         while(true) {
             IO.println("\n===== Employee Management System=====");
             IO.println("1. Add Employee");
             IO.println("2. Get Employee by ID");
             IO.println("3. Update Employee");
             IO.println("4. Delete Employee");
             IO.println("5. Get All Employees");
             IO.println("6. Exit");
             IO.println("Enter choice:");
             int choice = (Integer.parseInt(IO.readln()));

             try {
                 switch (choice)
                 {
                     case 1:
                         IO.println("Enter Employee ID:");
                         int id = Integer.parseInt(IO.readln());
                         IO.println("Enter Employee Name:");
                         String name = IO.readln();
                         IO.println("Enter Employee Salary:");
                         Double salary = Double.parseDouble(IO.readln());
                         e.addEmployee(new Employee(id,name,salary));
                         IO.println("Succesfully added Employee");
                         break;

                     case 2:
                         IO.println("Enter Employee ID to search:");
                         int sid = Integer.parseInt(IO.readln());
                         e.getEmployee(sid);

                     case 3:
                         IO.println("Enter Employee ID to update:");
                         int uid = Integer.parseInt(IO.readln());
                         IO.println("Enter New Employee Name: ");
                         String newname = IO.readln();
                         IO.println("Enter New Employee Salary: ");
                         Double newsal = Double.parseDouble(IO.readln());
                         e.updateEmployee(uid,new Employee(uid,newname,newsal));
                         IO.println("Succesfully updated Employee");

                     case 4:
                         IO.println("Enter Employee ID to delete:");
                         int did = Integer.parseInt(IO.readln());
                         e.deleteEmployee(did);
                         IO.println("Succesfully deleted Employee");

                     case 5:
                         IO.println("----EMPLOYEE----");
                         e.getAllEmployees();

                     case 6:
                         IO.println("Thank you for using this program");
                         break;

                     default:
                         IO.println("Invalid choice");


                 }
             } catch (Exception e1) {
                 IO.println(e1.getMessage());
             }
         }
    }
}
