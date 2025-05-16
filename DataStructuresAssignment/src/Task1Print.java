public class Task1Print {

    // Method to print a message 'n' times
    static void print(int n) {
        // Base case: if n is less than 1, exit the method
        if (n < 1) return;

        int i, j;

        // Outer loop runs from 1 to n
        for (i = 1; i <= n; i++) {
            // Inner loop starts from 1 to n, but only executes once due to break
            for (j = 1; j <= n; j++) {
                System.out.println("Welcome to java programming"); // Print message
                break; // Exit inner loop after first iteration
            }
        }
    }

    // Main method
    public static void main(String[] args) {
        print(10); // Call the method with n = 10; message will be printed 10 times
    }
}
