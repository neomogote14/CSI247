package lab06;

/**
 * Concrete subclass representing an Admin employee.
 */
public class Admin extends Employee {
    private double monthlySalary;
    private String role;

    /**
     * Default constructor.
     */
    public Admin() {
        super();
        this.monthlySalary = 0.0;
        this.role = "General Admin";
    }

    /**
     * Non-default constructor for Admin.
     * @param name Admin's name
     * @param employeeId Admin's employee ID
     * @param role Administrative role
     * @param monthlySalary Fixed monthly salary
     */
    public Admin(String name, String employeeId, String role, double monthlySalary) {
        super(name, employeeId);
        this.role = role;
        this.monthlySalary = monthlySalary;
    }

    // Getters and Setters
    public double getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    /**
     * Returns admin employee's monthly salary.
     */
    @Override
    public double computeSalary() {
        return monthlySalary;
    }

    /**
     * Overrides super class toString().
     */
    @Override
    public String toString() {
        return super.toString() + " | Role: " + role +
               " | Computed Salary: P" + String.format("%.2f", computeSalary());
    }

    /**
     * Admin employees are equal when they play the same role and their IDs and salaries match.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Admin other = (Admin) obj;
        return role != null && role.equalsIgnoreCase(other.role) &&
               getEmployeeId() != null && getEmployeeId().equalsIgnoreCase(other.getEmployeeId()) &&
               Math.abs(computeSalary() - other.computeSalary()) < 0.001;
    }
}