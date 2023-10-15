# Lab6.java
PURPOSE - reate a program that can be used
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
