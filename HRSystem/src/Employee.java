import java.time.LocalDate;

public class Employee {
    private boolean status = true;
    private Department department;
    private String name;
    private LocalDate dob;
    private String roleDescription;
    private double salary;

    public Employee() {
    }

    public Employee(Department department, String name, LocalDate dob, String roleDescription, double salary) {
        this.department = department;
        this.name = name;
        this.dob = dob;
        this.salary = salary;
        this.roleDescription = roleDescription;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return getName();
    }
}
