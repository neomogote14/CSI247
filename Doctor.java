public class Doctor {
    private String lastName;
    private String firstName;
    private double basicPay;

    // Constructor taking 3 parameters
    public Doctor(String lastName, String firstName, double basicPay) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.basicPay = basicPay;
    }

    // Getters and Setters
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public double getBasicPay() {
        return basicPay;
    }

    public void setBasicPay(double basicPay) {
        this.basicPay = basicPay;
    }

    // Method tagName() - Returns "Dr." Lastname initial. (e.g. Dr. Monei T.)
    public String tagName() {
        char initial = firstName.length() > 0 ? firstName.charAt(0) : ' ';
        return "Dr. " + lastName + " " + initial + ".";
    }

    // Method calculatePay() - Returns monthly basic pay
    public double calculatePay() {
        return basicPay;
    }

    @Override
    public String toString() {
        return tagName() + " | Basic Pay: P" + basicPay;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // Check if comparing the same object[cite: 1]
        if (obj == null || getClass() != obj.getClass()) return false; // Check for null and exact class type[cite: 1]

        Doctor doctor = (Doctor) obj;
        return Double.compare(doctor.basicPay, basicPay) == 0 &&
               lastName.equalsIgnoreCase(doctor.lastName) &&
               firstName.equalsIgnoreCase(doctor.firstName);
    }
}