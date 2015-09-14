
package mainpackage;

import java.util.Scanner;
import org.apache.poi.ss.formula.functions.FinanceLib;


public class Main {

	public static void main(String[] args) {
		
		
		
		//Input statements block...
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the number of years you have left to work:");
		double yearstowork = input.nextDouble();
		
		System.out.print("Enter your desired annual return, preretirement, as a percentage:");
		double annualreturn1 = input.nextDouble();
		
		//if they put in something like 12 instead of .12, assume they mean 12%, not 1200%
		if (annualreturn1 > 1.0)
			annualreturn1 = annualreturn1/100.0;
		
		System.out.print("Enter the number of years you want your money to last in retirement:");
		double yearsretired = input.nextDouble();
		
		System.out.print("Enter the expected annual return, postretirement, as a percentage:");
		double annualreturn2 = input.nextDouble();
		
		//if they put in something like 12 instead of .12, assume they mean 12%, not 1200%
		if (annualreturn2>1.0)
			annualreturn2 = annualreturn2/100.0;
		
		System.out.print("Enter the monthly income you need in retirement:");
		double requiredincome = input.nextDouble();
		
		System.out.print("Enter your expected SSI payments:");
		double monthlyssi = input.nextDouble();
		
		
		
		
		
		//assigning the input variables to function variables for PV
		double r = annualreturn2 / 12;
		double n = yearsretired * 12;
		double y = requiredincome - monthlyssi;
		double f = 0;
		boolean t = false;
		
		//outsourcing the PV calculation...
		double PV = FinanceLib.pv(r,n,y,f,t);
		
		System.out.printf("Your goal should be to save $%.2f%n", -PV);
		
		
		//assigning the input variables to function variables for PMT
		r = annualreturn1 / 12;
		n = yearstowork * 12;
		double p = 0;
		f = PV;
		
		//outsourcing the PMT calculation...
		double PMT = FinanceLib.pmt(r,n,p,f,t);
		
		System.out.printf("So you need to save $%.2f each month", PMT);
		
		
		//crossing t's and dotting i's
		input.close();		
		
		
		
	}

}