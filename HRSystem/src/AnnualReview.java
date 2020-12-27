import java.time.LocalDate;

public class AnnualReview {
    private Employee employee;
    private String approvingManager;
    private LocalDate dateOfReview;
    private double salaryIncreaseInPercent;
    private double annualPerformanceInPercent;

    public AnnualReview() {
    }

    public AnnualReview(Employee employee, String approvingManager, LocalDate dateOfReview, double annualPerformanceInPercent) {
        this.employee = employee;
        this.approvingManager = approvingManager;
        this.dateOfReview = dateOfReview;
        this.annualPerformanceInPercent = annualPerformanceInPercent;
        increaseYearsOfExperienceByOne();
        this.salaryIncreaseInPercent = calculateSalaryIncreaseInPercent();
    }

    public Employee getEmployee() {
        return employee;
    }

    public String getApprovingManager() {
        return approvingManager;
    }

    public void setApprovingManager(String approvingManager) {
        this.approvingManager = approvingManager;
    }

    public LocalDate getDateOfReview() {
        return dateOfReview;
    }

    public void setDateOfReview(LocalDate dateOfReview) {
        this.dateOfReview = dateOfReview;
    }

    public double getSalaryIncreaseInPercent() {
        return salaryIncreaseInPercent;
    }

    public void setSalaryIncreaseInPercent(double salaryIncreaseInPercent) {
        this.salaryIncreaseInPercent = salaryIncreaseInPercent;
    }

    public double getAnnualPerformanceInPercent() {
        return annualPerformanceInPercent;
    }

    public void setAnnualPerformanceInPercent(double annualPerformanceInPercent) {
        this.annualPerformanceInPercent = annualPerformanceInPercent;
    }

    //manager determines the percent of salary increase, but HRService increases salary separately, based on the percent from annual review.
    public double calculateSalaryIncreaseInPercent() {
        if (employee.getYearsOfExperience() == 0) {
            return 0.4 + annualPerformanceInPercent * 0.1;
        }
        return employee.getYearsOfExperience() * 0.5 + annualPerformanceInPercent * 0.1;
    }

    //each year employee's annual review is done, years of experience is increased by one.
    public void increaseYearsOfExperienceByOne() {
        employee.setYearsOfExperience(employee.getYearsOfExperience() + 1);
    }

    @Override
    public String toString() {
        return "AnnualReview{" +
                "employee=" + employee.getName() +
                ", approvingManager='" + approvingManager + '\'' +
                ", dateOfReview=" + dateOfReview +
                ", salaryIncreaseInPercent=" + salaryIncreaseInPercent +
                ", annualPerformanceInPercent=" + annualPerformanceInPercent +
                '}';
    }
}
