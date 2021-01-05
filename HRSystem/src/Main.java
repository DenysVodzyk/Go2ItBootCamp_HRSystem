import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Department engineeringDepartment = new Department("Engineering Department");
        Department salesDepartment = new Department("Sales Department");

        HRService hrService = new HRService();


        Employee one = new Employee("One", LocalDate.of(1993, 10, 10), "engineer1", 10000, 0);
        Employee two = new Employee("Two", LocalDate.of(1992, 10, 10), "engineer2", 20000, 1);
        Employee three = new Employee("Three", LocalDate.of(1991, 10, 10), "sales1", 30000, 2);
        Employee four = new Employee("Four", LocalDate.of(1991, 10, 10), "sales3", 5000, 0);

        //Add 2 employee to engineering dept and 1 to sales dept. Try to add employee with assigned dept to different dept.
        try {
            engineeringDepartment.addEmployee(one);
            engineeringDepartment.addEmployee(two);
            salesDepartment.addEmployee(three);
            salesDepartment.addEmployee(four);
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
            hrService.changeDepartment(two, salesDepartment, "sales2");
        } catch (EntryAlreadyExistException e) {
            e.printStackTrace();
        }

        printDepartmentsContent(engineeringDepartment, salesDepartment);
        printAllEmployeesStatus();

        //Employee One voluntarily leaves the company
        hrService.leaveCompany(one);
        printDepartmentsContent(engineeringDepartment, salesDepartment);
        printAllEmployeesStatus();

        //Two annual reviews were held from year 2018 and 2019 for employee Two
        AnnualReview annualReviewEmployeeTwo2018 = new AnnualReview(two, "Elon Musk", LocalDate.of(2018, 12, 25), 80);
        AnnualReview annualReviewEmployeeTwo2019 = new AnnualReview(two, "Elon Musk", LocalDate.of(2019, 12, 25), 80);
        AnnualReview annualReviewEmployeeFour2019 = new AnnualReview(four, "Bill", LocalDate.of(2019, 12, 20), 0);

        //Add 2018 annual review to the database of reviews and increase salary based on result of the annual review.
        two.addAnnualReviewToDatabase(annualReviewEmployeeTwo2018);
        hrService.increaseSalary(two, annualReviewEmployeeTwo2018.getSalaryIncreaseInPercent());

        //Add 2019 annual review to the database of reviews and increase salary based on result of the annual review.
        two.addAnnualReviewToDatabase(annualReviewEmployeeTwo2019);
        hrService.increaseSalary(two, annualReviewEmployeeTwo2019.getSalaryIncreaseInPercent());

        //Add 2019 annual review for Employee Four to the database of reviews and increase salary based on result of the annual review.
        four.addAnnualReviewToDatabase(annualReviewEmployeeFour2019);
        hrService.increaseSalary(four, annualReviewEmployeeFour2019.getSalaryIncreaseInPercent());

        hrService.printAnnualReviewHistory(two);
        System.out.println();
        System.out.println(two);
        System.out.println(four);

    }

    //Help method for functionality check
    public static void printDepartmentsContent(Department department1, Department department2) {
        System.out.println("Database of employees in the company (active and inactive): " + EmployeesDatabase.allEmployeesNamesInDatabase());
        System.out.println(department1.getDepartmentName() + ":");
        System.out.println(department1);
        System.out.println(department2.getDepartmentName() + ":");
        System.out.println(department2);
        System.out.println();
    }

    public static void printAllEmployeesStatus() {
        System.out.println("Print all ACTIVE employees: ");
        EmployeesDatabase.printActiveEmployees();
        System.out.println("Print all INACTIVE employees: ");
        EmployeesDatabase.printInactiveEmployees();
        System.out.println();
    }
}