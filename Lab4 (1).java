/*
eli james
lab 4
cis 200 sec B
Within the provided file (Lab4.java), the following has been done for you: Declare and initialize a 2D
array of doubles to hold the values listed in the lookup table above. Study the code and ask a TA if you
do not understand what is being done.
Then,
- Declare a constant to hold the number of clients (5).
- Use a for loop to read in info for 5 separate clients. For each client, ask the user to input the client’s
name (store in a String array), the amount to be invested (assume int $100-$10,000) the interest rate
(assume int 5-10 percent) and the term (years) of the investment (assume int 1-10). Store these last 3
values in either 3 separate, parallel int arrays or a single 2D array. (You will, therefore, either have 4
single-dimensional arrays or 1 single-D and 1 multi-D array)
- After all values have been entered in for all 5 clients, use another for loop for your output. Use the 2D
lookup table to determine the Compound Value and the Compound Interest earned by each client and
display with a $-sign and 2 decimals (along with their name)
for part 2 :
add f the amount to
be invested ($100-$10,000, inclusive) the interest rate (5%-10%, inclusive) and the term (years) of the
investment (1-10, inclusive). If invalid, display an error message and require the user to re-enter the value
until the value is valid. A piece of data must be valid before moving on to the next. For example, if
investment amount is invalid, loop until a valid value is entered, THEN move on to interest rate.
 */

 import java.util.Scanner;

 public class Lab4 {
	 public static void main(String[] args) {
		 Scanner input = new Scanner(System.in);
		 double [] [] table = {  {1.05, 1.06, 1.07, 1.08, 1.09, 1.10},//row 1
				 {1.1025, 1.1236, 1.1449, 1.1664, 1.1881, 1.21},	//row 2
				 {1.1576250, 1.1910160, 1.2250430, 1.2597120, 1.2950290, 1.331},	//row 3
				 {1.2155063, 1.2624770, 1.3107960, 1.3604890, 1.4115816, 1.4641},//row 4
				 {1.2762816, 1.3382256, 1.4025517, 1.4693281, 1.5386240, 1.61051}, //row 5
				 {1.3400956, 1.4185191, 1.5007304, 1.5868743, 1.6771001, 1.771561}, //row 6
				 {1.4071004, 1.5036303, 1.6057815, 1.7138243, 1.8280391, 1.9487171}, //row 7
				 {1.4774554, 1.5938481, 1.7181862, 1.8509302, 1.9925626, 2.1435888}, //row 8
				 {1.5513282, 1.6894790, 1.8384592, 1.9990046, 2.1718933, 2.3579477}, //row 9
				 {1.6288946, 1.7908477, 1.9671514, 2.1589250, 2.3673637, 2.5937425} //row 10
		 };
 
		 final int numberOfClients = 3;// final for the amount of clients
		 String[] nameOfClient = new String[numberOfClients];
		 int[] investments = new int[numberOfClients];
		 int[] interestRates = new int[numberOfClients];
		 int[] terms = new int[numberOfClients];
		 for (int i = 0; i < numberOfClients; i++) {
			 System.out.print("Enter client name: ");
			 nameOfClient[i] = input.nextLine();
 
			 while (true) {
				 System.out.print("Enter investment amount ($100-$10,000): ");
				 investments[i] = input.nextInt();
				 if (investments[i] >= 100 && investments[i] <= 10000) {
					 break;
				 } else {
					 System.out.println("That is not a valid amount. Please enter an amount between $100 and $10,000...");
				 }
			 }
			 while (true) {
				 System.out.print("Enter interest rate (5%-10%): ");
				 interestRates[i] = input.nextInt();
				 if (interestRates[i] >= 5 && interestRates[i] <= 10) {
					 break;
				 } else {
					 System.out.println("That is not a valid interest rate. Please enter a rate between 5% and 10%...");
				 }
			 }
			 while (true) {
				 System.out.print("Enter term (1-10 years): ");
				 terms[i] = input.nextInt();
				 if (terms[i] >= 1 && terms[i] <= 10) {
					 break;
				 } else {
					 System.out.println("That is not a valid term. Please enter a term between 1 and 10 years...");
				 }
			 }
 
			 input.nextLine();
		 }
		 for (int i = 0; i < numberOfClients; i++) {
			 int raterIndex = interestRates[i] - 5;
			 int termIndex = terms[i] - 1;
			 double compoundValue = table[termIndex][raterIndex] * investments[i];
			 double compoundInterest = compoundValue - investments[i];
			 System.out.printf("%s \t Compound Value:$%.2f\t Interest:$%.2f%n",
					 nameOfClient[i], compoundValue, compoundInterest);
 
		 }
		 input.close();//close prog
	 }
 }
 