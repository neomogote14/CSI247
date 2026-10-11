package lab06;

/**
 * Concrete subclass representing a Teacher.
 */
public class Teacher extends Employee {
    private String subject;
    private double hoursWorked;
    private double hourlyRate;

    /**
     * Default constructor.
     */
    public Teacher() {
        super();
        this.subject = "Unassigned";
        this.hoursWorked = 0.0;
        this.hourlyRate = 0.0;
    }

    /**
     * Non-default constructor for Teacher.
     * @param name Teacher's name
     * @param employeeId Teacher's employee ID
     * @param subject Subject taught
     * @param hoursWorked Monthly hours worked
     * @param hourlyRate Pay per hour
     */
    public Teacher(String name, String employeeId, String subject, double hoursWorked, double hourlyRate) {
        super(name, employeeId);
        this.subject = subject;
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    // Getters and Setters
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    /**
     * Computes teacher's salary as hours worked x hourly rate.
     */
    @Override
    public double computeSalary() {
        return hoursWorked * hourlyRate;
    }

    /**
     * Overrides super class toString().
     */
    @Override
    public String toString() {
        return super.toString() + " | Subject: " + subject +
               " | Hours Worked: " + hoursWorked +
               " | Hourly Rate: P" + String.format("%.2f", hourlyRate) +
               " | Computed Salary: P" + String.format("%.2f", computeSalary());
    }

    /**
     * Teachers are equal when they teach the same subject and their IDs and salaries match.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Teacher other = (Teacher) obj;
        return subject != null && subject.equalsIgnoreCase(other.subject) &&
               getEmployeeId() != null && getEmployeeId().equalsIgnoreCase(other.getEmployeeId()) &&
               Math.abs(computeSalary() - other.computeSalary()) < 0.001;
    }
}