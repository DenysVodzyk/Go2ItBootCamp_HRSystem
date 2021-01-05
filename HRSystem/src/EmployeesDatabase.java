import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class EmployeesDatabase {
    public static Map<String, Boolean> allEmployeesDatabase = new HashMap<>();

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
}
