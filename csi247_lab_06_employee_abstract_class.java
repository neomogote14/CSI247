package lab06;

/**
 * Abstract class Employee representing a general school employee.
 */
public abstract class Employee {
    private String name;
    private String employeeId;

    /**
     * Default constructor.
     */
    public Employee() {
        this("Unknown", "00000");
    }

    /**
     * Non-default constructor with name.
     * @param name Name of the employee
     */
    public Employee(String name) {
        this(name, "00000");
    }

    /**
     * Non-default constructor with name and employee ID.
     * @param name Name of the employee
     * @param employeeId Unique identifier for the employee
     */
    public Employee(String name, String employeeId) {
        this.name = name;
        this.employeeId = employeeId;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    /**
     * Abstract method to compute monthly salary.
     * @return Employee's calculated monthly salary
     */
    public abstract double computeSalary();

    /**
     * Overrides Object.toString() to return formatted employee details.
     */
    @Override
    public String toString() {
        return "Employee ID: " + employeeId + " | Name: " + name;
    }

    /**
     * Overrides Object.equals() to test equality based on ID and Name.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Employee other = (Employee) obj;
        return (employeeId != null && employeeId.equalsIgnoreCase(other.employeeId)) &&
               (name != null && name.equalsIgnoreCase(other.name));
    }
}