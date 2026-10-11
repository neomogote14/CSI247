package lab06;

/**
 * Question 2: Single and Multiple Interfaces Demonstration.
 */

// Interface Test (Lecture 11 base interface + methodD requirement)
interface Test {
    void methodA();
    void methodB();
    void methodC();

    /**
     * Accepts an integer value n and displays text "Done, bye!" n times, one per line.
     */
    void methodD(int n);
}

// Interface Test2 (Multiple inheritance requirement)
interface Test2 {
    /**
     * Accepts a string and displays the last character in the string n times in one line,
     * where n represents the number of characters in the string.
     */
    void methodE(String str);

    /**
     * Displays text "Multiple inheritance achieved!"
     */
    void methodF();
}

// Class Bob implementing interface Test
class Bob implements Test {
    @Override
    public void methodA() {
        System.out.println("Bob: Executing methodA()");
    }

    @Override
    public void methodB() {
        System.out.println("Bob: Executing methodB()");
    }

    @Override
    public void methodC() {
        System.out.println("Bob: Executing methodC()");
    }

    @Override
    public void methodD(int n) {
        System.out.println("Bob executing methodD:");
        for (int i = 0; i < n; i++) {
            System.out.println("Done, bye!");
        }
    }
}

// Class Mist implementing interface Test
class Mist implements Test {
    @Override
    public void methodA() {
        System.out.println("Mist: Executing methodA()");
    }

    @Override
    public void methodB() {
        System.out.println("Mist: Executing methodB()");
    }

    @Override
    public void methodC() {
        System.out.println("Mist: Executing methodC()");
    }

    @Override
    public void methodD(int n) {
        System.out.println("Mist executing methodD:");
        for (int i = 0; i < n; i++) {
            System.out.println("Done, bye!");
        }
    }
}

// Class Done implementing interface Test
class Done implements Test {
    @Override
    public void methodA() {
        System.out.println("Done: Executing methodA()");
    }

    @Override
    public void methodB() {
        System.out.println("Done: Executing methodB()");
    }

    @Override
    public void methodC() {
        System.out.println("Done: Executing methodC()");
    }

    @Override
    public void methodD(int n) {
        for (int i = 0; i < n; i++) {
            System.out.println("Done, bye!");
        }
    }
}

// Class implementing multiple interfaces (Test and Test2)
class MultiTestImpl implements Test, Test2 {
    @Override
    public void methodA() {
        System.out.println("MultiTestImpl: methodA()");
    }

    @Override
    public void methodB() {
        System.out.println("MultiTestImpl: methodB()");
    }

    @Override
    public void methodC() {
        System.out.println("MultiTestImpl: methodC()");
    }

    @Override
    public void methodD(int n) {
        for (int i = 0; i < n; i++) {
            System.out.println("Done, bye!");
        }
    }

    @Override
    public void methodE(String str) {
        if (str == null || str.isEmpty()) {
            System.out.println("String is empty.");
            return;
        }
        int n = str.length();
        char lastChar = str.charAt(n - 1);
        for (int i = 0; i < n; i++) {
            System.out.print(lastChar);
        }
        System.out.println(); // New line
    }

    @Override
    public void methodF() {
        System.out.println("Multiple inheritance achieved!");
    }
}

/**
 * Tester class for Question 2.
 */
public class Lab06_Question2 {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("         QUESTION 2A: SINGLE INTERFACE TEST       ");
        System.out.println("==================================================");

        Test bob = new Bob();
        bob.methodA();
        bob.methodB();

        System.out.println("\n--- Testing Class Done (methodD with n = 3) ---");
        Test doneObj = new Done();
        doneObj.methodD(3);

        System.out.println("\n==================================================");
        System.out.println("        QUESTION 2B: MULTIPLE INTERFACES TEST     ");
        System.out.println("==================================================");

        MultiTestImpl multiObj = new MultiTestImpl();

        System.out.println("Testing methodE(\"CSI247\"):");
        multiObj.methodE("CSI247");

        System.out.println("\nTesting methodF():");
        multiObj.methodF();
    }
}