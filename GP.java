public class GP extends Doctor {
    private double rate; // Allowance rate (e.g., 0.10 for 10%)

    // Constructor taking 3 super parameters plus rate
    public GP(String lastName, String firstName, double basicPay, double rate) {
        super(lastName, firstName, basicPay); // Calls superclass constructor[cite: 2]
        this.rate = rate;
    }

    // Getters and Setters[cite: 2]
    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    // Overriding tagName() to add "(GP)"[cite: 2]
    @Override
    public String tagName() {
        return super.tagName() + " (GP)";
    }

    // Overriding calculatePay() to add allowance[cite: 2]
    @Override
    public double calculatePay() {
        return super.getBasicPay() + (super.getBasicPay() * rate);
    }

    // Overriding toString()[cite: 1]
    @Override
    public String toString() {
        return tagName() + " | Total Pay: P" + calculatePay() + " (Rate: " + (rate * 100) + "%)";
    }

    // Overriding equals()[cite: 1]
    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false; // Ensure base Doctor attributes match[cite: 1]
        GP gp = (GP) obj;
        return Double.compare(gp.rate, rate) == 0;
    }
}