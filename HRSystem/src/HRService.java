public class HRService {

    public HRService() {
    }

    public String fireEmployee(Employee employee) {
        employee.setStatus(false);
        employee.getDepartment().removeEmployee(employee);
        return employee.getName() + ", you are fired. Here is your $" + employee.getSalary() * 0.4 +
                ", which is 40% of your annual salary.";
    }

    public void changeDepartment(Employee employee, Department newDepartment) {
        Department currentDepartment = employee.getDepartment();
        currentDepartment.removeEmployee(employee);
        employee.setDepartment(newDepartment);
        newDepartment.addEmployee(employee);
    }

    public void increaseSalary(Employee employee, double amountToIncreasePercent) {
        double newSalary = employee.getSalary() * (1 + amountToIncreasePercent / 100);
        employee.setSalary(newSalary);
    }


}
