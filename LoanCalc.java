
public class LoanCalc {
	
	static double epsilon = 0.001;  // Approximation accuracy
	static int iterationCounter;    // Number of iterations 
	
	// Gets the loan data and computes the periodical payment.
    // Expects to get three command-line arguments: loan amount (double),
    // interest rate (double, as a percentage), and number of payments (int).  
	public static void main(String[] args) {		
		// Gets the loan data
		double loan = Double.parseDouble(args[0]);
		double rate = Double.parseDouble(args[1]);
		int n = Integer.parseInt(args[2]);
		System.out.println("Loan = " + loan + ", interest rate = " + rate + "%, periods = " + n);

		// Computes the ending balance of the loan, given a periodical payment
		double payment = 10000;
		double endBalance = endBalance(loan, rate, n, payment);
		System.out.println("If your periodical payment is " + payment + ", your ending balance is: " + (int) endBalance);
		
		// Computes the periodical payment using brute force search
		System.out.print("\nPeriodical payment, using brute force: ");
		System.out.println((int) bruteForceSolver(loan, rate, n, epsilon));
		System.out.println("number of iterations: " + iterationCounter);

		// Computes the periodical payment using bisection search
		System.out.print("\nPeriodical payment, using bi-section search: ");
		System.out.println((int) bisectionSolver(loan, rate, n, epsilon));
		System.out.println("number of iterations: " + iterationCounter);
	}
	

	// Computes the ending balance of a loan, given the loan amount, the periodical
	// interest rate (as a percentage), the number of periods (n), and the periodical payment.
	private static double endBalance(double loan, double rate, int n, double payment) {	
		double endBalance = loan;
		int years = n;
		while(years>0)
		{
			endBalance = (endBalance - payment) * ((100+rate)/100);
			years--;
		}
		return endBalance;
	}
	
	// Uses sequential search to compute an approximation of the periodical payment
	// that will bring the ending balance of a loan close to 0.
	// Given: the sum of the loan, the periodical interest rate (as a percentage),
	// the number of periods (n), and epsilon, the approximation's accuracy
	// Side effect: modifies the class variable iterationCounter.
    public static double bruteForceSolver(double loan, double rate, int n, double epsilon) { 
		double payment = 0.0;
		double num = loan;
		while(epsilon < num)
		{
			payment = payment + epsilon;
			num = endBalance(loan,rate,n,payment);
		}
		return payment;
    }
    // Uses bisection search to compute an approximation of the periodical payment 
	// that will bring the ending balance of a loan close to 0.
	// Given: the sum of the loan, the periodical interest rate (as a percentage),
	// the number of periods (n), and epsilon, the approximation's accuracy
	// Side effect: modifies the class variable iterationCounter.
    public static double bisectionSolver(double loan, double rate, int n, double epsilon)
	 {  
		double L = loan / n;  
        double H = loan * (1 + rate / 100);  
        double g = 0; 
        double fL = endBalance(loan, rate, n, L);

        while ((H - L) > epsilon) 
		{
            g = (L + H) / 2;  
            double fG = endBalance(loan, rate, n, g); 
            if (fG == 0) 
			{
                break; 
            } else if (fL * fG > 0)
			 {
                L = g;  
                fL = fG;
            } else {
                H = g;  
            }
        }
		return g;  
	
	 }
	}




