import java.util.Arrays;
import java.util.Scanner;

public class MergeSortApp {

    // a) Recursive mergeSort method[cite: 2, 3]
    public static void mergeSort(int arr[], int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2; // Find the midpoint[cite: 3]
            mergeSort(arr, start, mid);    // Recursively sort Left half[cite: 3]
            mergeSort(arr, mid + 1, end);  // Recursively sort Right half[cite: 3]
            merge(arr, start, mid, end);   // Merge both halves[cite: 2, 3]
        }
    }

    // b) Fixed merge method
    public static void merge(int arr[], int s, int m, int e) {
        int size1 = m - s + 1; // Number of elements in Left sub-array[cite: 2]
        int size2 = e - m;     // Number of elements in Right sub-array[cite: 2]

        int left[] = new int[size1];  // Create Left sub-array[cite: 2]
        int right[] = new int[size2]; // Create Right sub-array[cite: 2]

        // Copy data into sub-arrays[cite: 2]
        for (int i = 0; i < size1; i++) {
            left[i] = arr[s + i]; // Fixed missing semicolon[cite: 2]
        }
        for (int j = 0; j < size2; j++) {
            right[j] = arr[m + 1 + j]; // Fixed missing semicolon[cite: 2]
        }

        // Merge sub-arrays[cite: 2]
        int i = 0;   // Initial index of Left array[cite: 2]
        int j = 0;   // Initial index of Right array[cite: 2]
        int cur = s; // Initial index of merged array[cite: 2]

        while (i < size1 && j < size2) {
            if (left[i] <= right[j]) {
                arr[cur] = left[i];
                i++;
            } else {
                arr[cur] = right[j];
                j++;
            }
            cur++;
        }

        // Copy remaining elements of left[] if any[cite: 2]
        while (i < size1) {
            arr[cur] = left[i];
            i++;
            cur++;
        }

        // Copy remaining elements of right[] if any[cite: 2]
        while (j < size2) {
            arr[cur] = right[j];
            j++;
            cur++;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String choice = "y";

        // v) Loop continuously until the user decides to terminate[cite: 2]
        while (choice.equalsIgnoreCase("y")) {
            int[] quizMarks = new int[30];
            int count = 0;

            // i) Generate 30 random int values between 0 and 100 using a while loop[cite: 2]
            while (count < 30) {
                quizMarks[count] = (int) (Math.random() * 101); // 0 to 100 inclusive[cite: 2]
                count++;
            }

            // ii) Display array contents before sorting[cite: 2]
            System.out.println("\n--- CSI247 Quiz 01 Marks (Unsorted) ---");
            System.out.println(Arrays.toString(quizMarks));

            // iii) Sort array contents using mergeSort[cite: 2]
            mergeSort(quizMarks, 0, quizMarks.length - 1);

            // iv) Display sorted array contents after sorting[cite: 2]
            System.out.println("\n--- CSI247 Quiz 01 Marks (Sorted) ---");
            System.out.println(Arrays.toString(quizMarks));

            // Ask user whether to continue[cite: 2]
            System.out.print("\nDo you want to generate and sort another batch? (y/n): ");
            choice = scanner.next();
        }

        System.out.println("Program terminated.");
        scanner.close();
    }
}
