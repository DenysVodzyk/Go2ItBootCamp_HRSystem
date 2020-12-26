import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Department engineeringDepartment = new Department("Engineering Department");
        Department salesDepartment = new Department("Sales Department");

        HRService hrService = new HRService();

        Employee one = new Employee(engineeringDepartment, "David", LocalDate.of(1999, 10, 10), "engineer", 60000);


        engineeringDepartment.addEmployee(one);
        System.out.println(engineeringDepartment);
        System.out.println(salesDepartment);

        System.out.println(one.getSalary());
        System.out.println("Salary increase by 2%");
        hrService.increaseSalary(one, 2);
        System.out.println(one.getSalary());
        System.out.println(one.isStatus());

        hrService.changeDepartment(one, salesDepartment);
        System.out.println(one.isStatus());


        System.out.println(engineeringDepartment);
        System.out.println(salesDepartment);

        System.out.println("add one more time");
        salesDepartment.addEmployee(one);

        System.out.println(salesDepartment);


    }
}