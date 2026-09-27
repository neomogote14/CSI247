public class Surgeon extends Doctor {
    private int numOfProcedures;
    private double procedureRate;

    // Constructor taking 3 super parameters plus procedures and rate[cite: 2]
    public Surgeon(String lastName, String firstName, double basicPay, double procedureRate, int numOfProcedures) {
        super(lastName, firstName, basicPay); // Calls superclass constructor[cite: 2]
        this.procedureRate = procedureRate;
        this.numOfProcedures = numOfProcedures;
    }

    // Getters and Setters[cite: 2]
    public int getNumOfProcedures() {
        return numOfProcedures;
    }

    public void setNumOfProcedures(int numOfProcedures) {
        this.numOfProcedures = numOfProcedures;
    }

    public double getProcedureRate() {
        return procedureRate;
    }

    public void setProcedureRate(double procedureRate) {
        this.procedureRate = procedureRate;
    }

    // Overriding tagName() to add "(Surgeon)"[cite: 2]
    @Override
    public String tagName() {
        return super.tagName() + " (Surgeon)";
    }

    // Overriding calculatePay(): basicPay + (procedures * rate)[cite: 2]
    @Override
    public double calculatePay() {
        return super.getBasicPay() + (numOfProcedures * procedureRate);
    }

    // Overriding toString()[cite: 1]
    @Override
    public String toString() {
        return tagName() + " | Total Pay: P" + calculatePay() + 
               " (" + numOfProcedures + " procedures @ P" + procedureRate + " each)";
    }

    // Overriding equals()[cite: 1]
    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false; // Ensure base Doctor attributes match[cite: 1]
        Surgeon surgeon = (Surgeon) obj;
        return numOfProcedures == surgeon.numOfProcedures &&
               Double.compare(surgeon.procedureRate, procedureRate) == 0;
    }
}