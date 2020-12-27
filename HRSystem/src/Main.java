import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Department engineeringDepartment = new Department("Engineering Department");
        Department salesDepartment = new Department("Sales Department");

        HRService hrService = new HRService();


        Employee one = new Employee("One", LocalDate.of(1993, 10, 10), "engineer1", 10000, 1);
        Employee two = new Employee("Two", LocalDate.of(1992, 10, 10), "engineer2", 20000, 0);
        Employee three = new Employee("Three", LocalDate.of(1991, 10, 10), "sales1", 30000, 2);

        //Add 2 employee to engineering dept and 1 to sales dept. Try to add employee with assigned dept to different dept.
        try {
            engineeringDepartment.addEmployee(one);
            engineeringDepartment.addEmployee(two);
            salesDepartment.addEmployee(three);
            salesDepartment.addEmployee(one);
        } catch (EntryAlreadyExistException e) {
            e.printStackTrace();
        }

        printDepartmentsContent(engineeringDepartment, salesDepartment);
        printAllEmployeesStatus();
        //increase salary to employee One by 10%, transfer employee Two from Engineering dept to Sale dept, fire employee Three
        hrService.increaseSalary(one, 10);
        hrService.fireEmployee(three);
        try {
            hrService.changeDepartment(two, salesDepartment);
        } catch (EntryAlreadyExistException e) {
            e.printStackTrace();
        }

        printDepartmentsContent(engineeringDepartment, salesDepartment);
        printAllEmployeesStatus();

        hrService.leaveCompany(one);
        printDepartmentsContent(engineeringDepartment, salesDepartment);
        printAllEmployeesStatus();


    }

    //Help method for functionality check
    public static void printDepartmentsContent(Department department1, Department department2) {
        System.out.println("Database of employees in the company: " + Department.allEmployeesNamesInDatabase());
        System.out.println(department1.getDepartmentName() + ":");
        System.out.println(department1);
        System.out.println(department2.getDepartmentName() + ":");
        System.out.println(department2);
        System.out.println();
    }

    public static void printAllEmployeesStatus() {
        System.out.println("Print all ACTIVE employees: ");
        Department.printActiveEmployees();
        System.out.println("Print all INACTIVE employees: ");
        Department.printInactiveEmployees();
        System.out.println();
    }
}