public class HRService {

    public HRService() {
    }

    public String fireEmployee(Employee employee) {
        employee.setStatus(false);
        employee.getDepartment().removeEmployee(employee);
        Department.addEmployeeToDatabase(employee);
        return employee.getName() + ", you are fired. Here is your $" + employee.getSalary() * 0.4 +
                ", which is 40% of your annual salary.";
    }


    public void changeDepartment(Employee employee, Department newDepartment) throws EntryAlreadyExistException {
        employee.getDepartment().removeEmployee(employee);
        employee.setDepartment(null);
        newDepartment.addEmployee(employee);
        employee.setDepartment(newDepartment);
    }

    public void increaseSalary(Employee employee, double amountToIncreasePercent) {
        double newSalary = employee.getSalary() * (1 + amountToIncreasePercent / 100);
        employee.setSalary(newSalary);
    }


}
