import java.util.*;

public class Department {
    private Set<Employee> employees = new HashSet<>();
    private String departmentName;

    public Department() {
    }

    public Department(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    //add employee to department, throw exception in case if department is already assigned to employee.
    public void addEmployee(Employee employee) throws DuplicateEmployeeException {
        if (employee.getDepartment() != null) {
            throw new DuplicateEmployeeException("Employee " + employee.getName() + " is already a part of " + employee.getDepartment().getDepartmentName() + " department.");
        }
        employee.setDepartment(Department.this);
        employees.add(employee);
        EmployeesDatabase.addEmployeeToDatabase(employee);
    }

    //remove employee from department list. Employee still stays within the company database.
    public void removeEmployee(Employee employee) {
        employees.remove(employee);
    }

    //print names of employees that are in the department
    public void getEmployees() {
        for (Employee employee : employees) {
            System.out.print(employee.getName() + " ");
        }
        System.out.println("");
    }


    @Override
    public String toString() {
        return "Department{" +
                "employees=" + employees +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }
}
