import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Department {
    private Set<Employee> employees = new HashSet<>();
    private String departmentName;


    public Department() {
    }

    public Department(String departmentName) {
        this.departmentName = departmentName;
    }

    public void addEmployee(Employee employee) throws EntryAlreadyExistException {
        if (employees.contains(employee)) {
            throw new EntryAlreadyExistException("Employee is already part of the " + this.departmentName + " department.");
        }
        employees.add(employee);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return employees.equals(that.employees) &&
                departmentName.equals(that.departmentName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employees, departmentName);
    }

    @Override
    public String toString() {
        return "Department{" +
                "employees=" + employees +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }
}
