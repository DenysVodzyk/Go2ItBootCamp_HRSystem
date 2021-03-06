import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Employee {
    private boolean isStatus = true;
    private Department department;
    private String name;
    private LocalDate dob;
    private String roleDescription;
    private double salary;
    private int yearsOfExperience;
    private Set<AnnualReview> annualReviewDatabase;

    public Employee() {
    }

    public Employee(String name, LocalDate dob, String roleDescription, double salary, int yearsOfExperience) {
        this.department = null;
        this.name = name;
        this.dob = dob;
        this.salary = salary;
        this.roleDescription = roleDescription;
        this.yearsOfExperience = yearsOfExperience;
        this.annualReviewDatabase = new HashSet<>();
    }

    public boolean isStatus() {
        return isStatus;
    }

    public void setStatus(boolean status) {
        this.isStatus = status;
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
        String salaryRounded = String.format("%.2f", salary);
        this.salary = Double.valueOf(salaryRounded);
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public void addAnnualReviewToDatabase(AnnualReview annualReview) {
        annualReviewDatabase.add(annualReview);
    }

    public Set<AnnualReview> getAnnualReviewDatabase() {
        return annualReviewDatabase;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "status=" + isStatus +
                ", department=" + department.getDepartmentName() +
                ", name='" + name + '\'' +
                ", dob=" + dob +
                ", roleDescription='" + roleDescription + '\'' +
                ", salary=" + salary +
                ", yearsOfExperience=" + yearsOfExperience +
                '}';
    }
}
