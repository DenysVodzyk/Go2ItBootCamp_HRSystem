public class HRService {

    public HRService() {
    }

    //firing employee from the company
    public String fireEmployee(Employee employee) {
        leaveCompany(employee);
        return employee.getName() + ", you are fired. Here is your $" + employee.getSalary() * 0.4 +
                ", which is 40% of your annual salary.";
    }

    //employee voluntary leave
    public void leaveCompany(Employee employee) {
        employee.setStatus(false);
        employee.getDepartment().removeEmployee(employee);
        EmployeesDatabase.addEmployeeToDatabase(employee);
    }

    //moving from one department to another with a new role description
    public void changeDepartment(Employee employee, Department newDepartment, String newRoleDescription) throws EntryAlreadyExistException {
        employee.getDepartment().removeEmployee(employee);
        employee.setDepartment(null);
        newDepartment.addEmployee(employee);
        employee.setDepartment(newDepartment);
        employee.setRoleDescription(newRoleDescription);
    }

    //increase a salary, either after annual review or due to other circumstance
    public void increaseSalary(Employee employee, double amountToIncreasePercent) {
        double newSalary = employee.getSalary() * (1 + amountToIncreasePercent / 100);
        employee.setSalary(newSalary);
    }

    //print out employee's annual review history
    public void printAnnualReviewHistory(Employee employee) {
        System.out.println(employee.getAnnualReviewDatabase());
    }

}
