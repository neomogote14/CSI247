import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {
        File inputFile = new File("data.txt");

        try (
            Scanner scanner = new Scanner(inputFile);
            PrintWriter gpWriter = new PrintWriter("gps.txt");
            PrintWriter surgeonWriter = new PrintWriter("surgeons.txt");
            PrintWriter doctorWriter = new PrintWriter("doctors.txt")
        ) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (line.isEmpty()) continue;

                // Input format: Lastname; Firstname(s); pay; rate; number of procedures[cite: 2]
                String[] parts = line.split(";");

                String lastName = parts[0].trim();
                String firstName = parts[1].trim();
                double basicPay = Double.parseDouble(parts[2].trim());

                if (parts.length == 3) {
                    // Regular Doctor[cite: 2]
                    Doctor doc = new Doctor(lastName, firstName, basicPay);
                    doctorWriter.println(doc.tagName() + " | Monthly Pay: P" + String.format("%.2f", doc.calculatePay()));
                } 
                else if (parts.length == 4) {
                    // General Practitioner (GP)[cite: 2]
                    double rate = Double.parseDouble(parts[3].trim());
                    GP gp = new GP(lastName, firstName, basicPay, rate);
                    gpWriter.println(gp.tagName() + " | Monthly Pay: P" + String.format("%.2f", gp.calculatePay()));
                } 
                else if (parts.length == 5) {
                    // Surgeon[cite: 2]
                    double rate = Double.parseDouble(parts[3].trim());
                    int procedures = Integer.parseInt(parts[4].trim());
                    Surgeon surgeon = new Surgeon(lastName, firstName, basicPay, rate, procedures);
                    surgeonWriter.println(surgeon.tagName() + " | Monthly Pay: P" + String.format("%.2f", surgeon.calculatePay()));
                }
            }

            System.out.println("Processing completed successfully! Check gps.txt, surgeons.txt, and doctors.txt.");

        } catch (FileNotFoundException e) {
            System.err.println("Error: Input file 'data.txt' not found.");
        } catch (Exception e) {
            System.err.println("Error processing file data: " + e.getMessage());
        }
    }
}