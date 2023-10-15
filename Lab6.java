import java.util.Scanner;

/**
 * Lab6_Methods.java
 * Original Author: Dr. D. Lang
 * Modified by: (Eli james)
 * Course: CIS 200
 * Lab Section: (B Thurs @ 1:05)
 * PURPOSE - reate a program that can be used
by a Bank to calculate the monthly and total payment on a house mortgage loan, given the interest rate, length,
and amount of the loan.
Look over the main method. You will see that it basically is an outline of methods calls
1) 3 input methods are used to read in values for interest rate, loan amount, and term (years) of the loan.
2) A method is called to calculate the monthly payment for the loan.
3) Calculate the total paid and the total interest paid on the loan.
4) A method is called to display monthly payment, the total amount paid, and the total amount of interest paid.
• Notice which methods are passing values INTO a method (calcMonthlyPayment, displayOutput), while
others pass nothing to the method, yet the return value is used to assign a value into a variable that is
LOCAL to main (getInterest, getLoanAmount, getYears)
You will be completing the following methods:
1) Complete the getInterest method
2) Complete the getLoanAmount method
3) Complete the getYears method
4) Complete the calcMonthlyPayment method (formula given on the next page)
5) Complete the displayOutput method
Part 2: 
add data validation
within each input method. Within the method, loop until valid data is entered, THEN return that value.
1) For interest, valid range is 3-12 (3%-12%) inclusive
2) For loan amount, valid range is $50,000-$1,000,000 (1 million) inclusive
3) For number of years, valid range is 1-50 years inclusive

 */
public class Lab6 {
    /**
     * main: Starting point of the Program
     *
     * @param args - Array of Strings entered from the command line
     */
    public static void main(String[] args) {
        double interestRate; // holds YEARLY interest rate
        double loanAmount; // Amount of the Loan
        int years; // Length of the Loan
        double monthlyPayment; // Monthly Payment required

        // Declare a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // -------------------- Get User-entered Input ------------------
        interestRate = getInterest(scanner);
        loanAmount = getLoanAmount(scanner);
        years = getYears(scanner);

        // ----------------------- Calculate the Payments ------------------
        // Call method to calculate monthly payment, passing the loan amount,
        // interest rate, and how many years of the loan as ARGUMENTS
        // Must pass in the correct order!
        monthlyPayment = calcMonthlyPayment(years, loanAmount, interestRate);

        // calculate the total amount to be paid on the loan
        double totalPaid = monthlyPayment * years * 12;

        // calculate the total interest to be paid on the loan
        double interestPaid = totalPaid - loanAmount;

        // ----------------------- Display Results ------------------------------
        // call displayOutput method defined below main...pass needed info as ARGUMENTS
        displayOutput(monthlyPayment, totalPaid, interestPaid);

        // Close the scanner
        scanner.close();
    } // end main method

    // -------------------- Input Methods -----------------------------------

    /**
     * getInterest: Gets a YEARLY interest rate from the user,
     * converts and returns a monthly interest rate (double)
     *
     * @param scanner The Scanner object for input.
     * @return The monthly interest rate.
     */
    public static double getInterest(Scanner scanner) {
        double interestRate;
        System.out.print("Enter yearly interest rate (Ex 8.25): ");

        do {
           // System.out.print("Enter yearly interest rate (Ex 8.25): ");
            while (!scanner.hasNextDouble()) {
                System.out.println("Valid Interest rates are 3%-12%.");
                System.out.print("Please re-enter: ");
                scanner.next(); // Clear the invalid input
            }
            interestRate = scanner.nextDouble();

            while (interestRate < 3 || interestRate > 12) {
                System.out.println("Valid Interest rates are 3%-12%.");
                System.out.print("Please re-enter: ");
                interestRate = scanner.nextDouble();
                //continue;
            }
        } while (interestRate < 3 || interestRate > 12);

        // Convert yearly interest rate to monthly
        double monthlyInterestRate = interestRate / 12 / 100;
        return monthlyInterestRate;
    }

    /**
     * getYears: Gets from the user and returns the term of the loan
     * (number of years) as an int
     *
     * @param scanner The Scanner object for input.
     * @return The number of years.
     */
    public static int getYears(Scanner scanner) {
        int years;

        do {
            System.out.print("Enter number of years (as an integer): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a valid number of years.");
                scanner.next(); // Clear the invalid input
            }
            years = scanner.nextInt();

            if (years < 1 || years > 50) {
                System.out.println("Number of years must be between 1 and 50.");
            }
        } while (years < 1 || years > 50);

        return years;
    }

    /**
     * getLoanAmount: Gets from the user and returns the loan amount (double)
     *
     * @param scanner The Scanner object for input.
     * @return The loan amount.
     */
    public static double getLoanAmount(Scanner scanner) {
        double loanAmount;

        do {
            System.out.print("Enter loan amount (Example 120000.95): ");
            while (!scanner.hasNextDouble()) {
                System.out.println("Invalid input. Please enter a valid loan amount.");
                scanner.next(); // Clear the invalid input
            }
            loanAmount = scanner.nextDouble();

            if (loanAmount < 50000 || loanAmount > 1000000) {
                System.out.println("Loan amount must be between $50,000 and $1,000,000.");
            }
        } while (loanAmount < 50000 || loanAmount > 1000000);

        return loanAmount;
    }

    // ----------------------- Calculate Monthly Payment ------------------

    /**
     * calcMonthlyPayment: Calculates and returns the monthly payment (double)
     * Requires passing in the term of the loan, loan amount, and monthly interest rate.
     *
     * @param term   The number of years for the loan.
     * @param amount The loan amount.
     * @param rate   The monthly interest rate.
     * @return The monthly payment.
     */
    public static double calcMonthlyPayment(int term, double amount, double rate) {
        double monthlyInterestRate = rate;
        int numberOfPayments = term * 12;
        double monthlyPayment = (amount * monthlyInterestRate) /
                (1 - Math.pow(1 + monthlyInterestRate, -numberOfPayments));
        return monthlyPayment;
    }

    // ----------------------- Display Output ------------------------------

    /**
     * displayOutput: Displays the monthly payment, total amount paid, and total interest paid.
     *
     * @param monthlyPayment The monthly payment.
     * @param totalPaid      The total amount paid.
     * @param interestPaid   The total interest paid.
     */
    public static void displayOutput(double monthlyPayment, double totalPaid, double interestPaid) {
        System.out.println();
        System.out.printf("The monthly payment is $%.2f%n", monthlyPayment);
        System.out.printf("The total paid on the loan is $%.2f%n", totalPaid);
        System.out.printf("The total interest paid on the loan is $%.2f%n", interestPaid);
    }
}
