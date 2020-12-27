import java.util.*;

public class Department {
    private Set<Employee> employees = new HashSet<>();
    private String departmentName;
    private static Map<String, Boolean> allEmployeesDatabase = new HashMap<>();

    public Department() {
    }

    public Department(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    //add employee to department, throw exception in case if department is already assigned to employee.
    public void addEmployee(Employee employee) throws EntryAlreadyExistException {
        if (employee.getDepartment() != null) {
            throw new EntryAlreadyExistException("Employee " + employee.getName() + " is already a part of " + employee.getDepartment().getDepartmentName() + " department.");
        }
        employee.setDepartment(Department.this);
        employees.add(employee);
        addEmployeeToDatabase(employee);
    }

    //a list of all employees that ever worked in the company, active or inactive
    public static void addEmployeeToDatabase(Employee employee) {
        allEmployeesDatabase.put(employee.getName(), employee.isStatus());
    }

    //quantity of employees in the company database (active and inactive)
    public static int numberOfEmployeesInDatabase() {
        return allEmployeesDatabase.size();
    }

    //returning all employees in the company, just names (active and inactive)
    public static Set<String> allEmployeesNamesInDatabase() {
        return allEmployeesDatabase.keySet();
    }

    //Printing all active employees in the company
    public static void printActiveEmployees() {
        for (Map.Entry<String, Boolean> activeEmployee : allEmployeesDatabase.entrySet()) {
            if (activeEmployee.getValue()) {
                System.out.println(activeEmployee);
            }
        }
    }

    //Printing all inactive employees in the company
    public static void printInactiveEmployees() {
        for (Map.Entry<String, Boolean> inactiveEmployee : allEmployeesDatabase.entrySet()) {
            if (!inactiveEmployee.getValue()) {
                System.out.println(inactiveEmployee);
            }
        }
    }

    //remove employee from department list. Employee still stays within the company database.
    public void removeEmployee(Employee employee) {
        employees.remove(employee);
    }

    //print names of employees that are in the department
    public void printDepartmentEmployees() {
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
