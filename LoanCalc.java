
public class LoanCalc {
	
	static double epsilon = 0.001;  
	static int iterationCounter;    

	public static void main(String[] args) {		
		// Gets the loan data
		double loan = Double.parseDouble(args[0]);
		double rate = Double.parseDouble(args[1]);
		int n = Integer.parseInt(args[2]);
		System.out.println("Loan = " + loan + ", interest rate = " + rate + "%, periods = " + n);

		// Computes the ending balance of the loan, given a periodical payment
		double payment = 10000;
		double endBalance = endBalance(loan, rate, n, payment);
		
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
		for(int i= 0 ; i<n;i++)
		{
			endBalance = (endBalance - payment) * ((100+rate)/100);
		}
		return endBalance;
	}
	
	// Uses sequential search to compute an approximation of the periodical payment
	// that will bring the ending balance of a loan close to 0.
	// Given: the sum of the loan, the periodical interest rate (as a percentage),
	// the number of periods (n), and epsilon, the approximation's accuracy
	// Side effect: modifies the class variable iterationCounter.
    public static double bruteForceSolver(double loan, double rate, int n, double epsilon) { 
		double payment =loan/n;
		iterationCounter = 0;
		while(epsilon < endBalance(loan,rate,n,payment))
		{
			
			payment = payment + epsilon;
			iterationCounter++;
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
		double l = loan/n;
		double h = loan * ((100+rate) / 100);
		double payment = 0;
		iterationCounter = 0;
		while(h-l> epsilon)
		{
			iterationCounter++;
			payment = (l+h)/2;
			double balance = endBalance(loan, rate, n, payment);
			if(balance>0)
			{
				l= payment;
			}else{
				h=payment;
			}
		}
		return payment;
	 }
	}




