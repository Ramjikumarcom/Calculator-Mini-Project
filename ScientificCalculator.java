import java.util.Scanner;

public class ScientificCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        double result;

        do {
            System.out.println("Scientific Calculator Menu:");
            System.out.println("1. Square root");
            System.out.println("2. Factorial");
            System.out.println("3. Natural logarithm (base e)");
            System.out.println("4. Power function");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            String input = scanner.nextLine(); // Read the input as a string

            try {
                choice = Integer.parseInt(input); // Try to parse the input into an integer
            } catch (Exception e) {
                // If parsing fails, print an error message and continue the loop
                System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter a number to find its square root: ");
                    double sqrtNum = scanner.nextDouble();
                    if(sqrtNum < 0){
                        System.out.println("Square root of a negative number cannot be found");
                    }
                    else{
                        result = squareRoot(sqrtNum);
                        System.out.println("Square root of " + sqrtNum + " is: " + result);
                    }                    
                    break;

                case 2:
                    System.out.print("Enter a number to find its factorial: ");
                    int factorialNum = scanner.nextInt();
                    if(factorialNum < 0){
                        System.out.println("Factorial of a negative number cannot be found");
                    }
                    else{
                        result = factorial(factorialNum);
                        System.out.println("Factorial of " + factorialNum+ " is: " + result);
                    }                    
                    break;
                
                case 3:
                    System.out.print("Enter a number to find its natural logarithm: ");
                    double logNum = scanner.nextDouble();
                    if(logNum < 0){
                        System.out.println("Factorial of a negative number cannot be found");
                    }
                    else{
                        result = naturalLog(logNum);
                        System.out.println("Natural logarithm of " + logNum + " is: " + result);
                    }                    
                    break;

                case 4:
                    System.out.print("Enter a base number: ");
                    double base = scanner.nextDouble();
                    System.out.print("Enter an exponent: ");
                    double exponent = scanner.nextDouble();
                    result = power(base, exponent);
                    System.out.println(base + " raised to the power of " + exponent + " is: " + result);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        } while (choice != 5);
        
        scanner.close();
    }

    public static double squareRoot(double x) {
        return Math.sqrt(x);
    }

    public static double factorial(int x) {
        if (x == 0)
            return 1;
        if(x < 0){
            throw new IllegalArgumentException("Number is negative");
        }
        double result = 1;
        for (int i = 1; i <= x; i++) {
            result *= i;
        }
        return result;
    }

    public static double naturalLog(double x) {
        return Math.log(x);
    }

    public static double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }
}

