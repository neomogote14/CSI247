package lab06;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Tester program for Question 1 that reads employee records,
 * processes polymorphism, writes output text files, and calculates totals.
 */
public class RunPayroll {

    public static void main(String[] args) {
        Employee[] employees = new Employee[30];
        int count = 0;

        File inputDataFile = new File("lab06/employees.txt");
        if (!inputDataFile.exists()) {
            inputDataFile = new File("employees.txt"); // Fallback if running directly inside lab06 directory
        }

        System.out.println("Reading employee records from file...");

        try (Scanner scanner = new Scanner(inputDataFile)) {
            while (scanner.hasNextLine() && count < employees.length) {
                String line = scanner.nextLine().trim();
                if (line.isEmpty()) continue;

                String[] parts = line.split(";");

                if (parts.length == 4) {
                    // Admin record: Name; ID; Role; MonthlySalary
                    String name = parts[0].trim();
                    String id = parts[1].trim();
                    String role = parts[2].trim();
                    double salary = Double.parseDouble(parts[3].trim());

                    employees[count++] = new Admin(name, id, role, salary);
                } else if (parts.length == 5) {
                    // Teacher record: Name; ID; Subject; HoursWorked; HourlyRate
                    String name = parts[0].trim();
                    String id = parts[1].trim();
                    String subject = parts[2].trim();
                    double hours = Double.parseDouble(parts[3].trim());
                    double rate = Double.parseDouble(parts[4].trim());

                    employees[count++] = new Teacher(name, id, subject, hours, rate);
                } else {
                    System.out.println("Warning: Invalid record format encountered -> " + line);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error: Input file 'employees.txt' not found! Ensure file exists in the directory.");
            return;
        } catch (NumberFormatException e) {
            System.err.println("Error parsing numeric values from file: " + e.getMessage());
            return;
        }

        double totalTeachersPay = 0.0;
        double totalAdminPay = 0.0;

        try (PrintWriter teachersWriter = new PrintWriter("teacherspay.txt");
             PrintWriter adminWriter = new PrintWriter("adminpay.txt")) {

            teachersWriter.println("==========================================================================");
            teachersWriter.println("                       TEACHERS PAYROLL REPORT                           ");
            teachersWriter.println("==========================================================================");

            adminWriter.println("==========================================================================");
            adminWriter.println("                    ADMINISTRATORS PAYROLL REPORT                        ");
            adminWriter.println("==========================================================================");

            for (int i = 0; i < count; i++) {
                Employee emp = employees[i];
                double salary = emp.computeSalary();

                if (emp instanceof Teacher) {
                    Teacher t = (Teacher) emp;
                    teachersWriter.printf("ID: %-8s | Name: %-16s | Subject: %-18s | Salary: P%,10.2f%n",
                            t.getEmployeeId(), t.getName(), t.getSubject(), salary);
                    totalTeachersPay += salary;
                } else if (emp instanceof Admin) {
                    Admin a = (Admin) emp;
                    adminWriter.printf("ID: %-8s | Name: %-16s | Role: %-21s | Salary: P%,10.2f%n",
                            a.getEmployeeId(), a.getName(), a.getRole(), salary);
                    totalAdminPay += salary;
                }
            }

            teachersWriter.println("==========================================================================");
            teachersWriter.printf("TOTAL TEACHERS PAYROLL: P%,10.2f%n", totalTeachersPay);
            teachersWriter.println("==========================================================================");

            adminWriter.println("==========================================================================");
            adminWriter.printf("TOTAL ADMINISTRATORS PAYROLL: P%,10.2f%n", totalAdminPay);
            adminWriter.println("==========================================================================");

            System.out.println("Payroll files generated successfully: 'teacherspay.txt' and 'adminpay.txt'.\n");

        } catch (FileNotFoundException e) {
            System.err.println("Error writing output payroll files: " + e.getMessage());
        }

        double totalWageBill = totalTeachersPay + totalAdminPay;

        System.out.println("==================================================");
        System.out.println("             MONTHLY PAYROLL SUMMARY              ");
        System.out.println("==================================================");
        System.out.printf("Total Teachers Salary Bill      : P%,12.2f%n", totalTeachersPay);
        System.out.printf("Total Administrators Salary Bill: P%,12.2f%n", totalAdminPay);
        System.out.println("--------------------------------------------------");
        System.out.printf("TOTAL WAGE BILL FOR THE MONTH   : P%,12.2f%n", totalWageBill);
        System.out.println("==================================================");
    }
}