//=============================================================================================================================================
//						Program : To find the fibonacci(n) using recursive strategy
//=============================================================================================================================================
//	@author: Nevhetha,Kritika,Karthika
// 	Date created: 2016/09/20
//	Date modified: 2016/09/24
//=============================================================================================================================================
import java.math.BigInteger;
/**
 * 	Recursive Strategy to find fibonacci(n):
 * 	Running time: exponential : O(2^n)
 *
 */
public class FibonacciRecursive {
	/**
	 * 
	 * @param n:int- number whose corresponding value in fibonacci series is to be found
	 * @return fibonacci(n) : BigInteger
	 */
	private static BigInteger recursiveFibonacci(int n) {
		if(n<=1)
			return BigInteger.valueOf(n);
		else
			return recursiveFibonacci(n-1).add(recursiveFibonacci(n-2));
		
	}
	public static void main(String[] args) {
		int n=46;
		long sec=0;
		Timer timer = new Timer();
		BigInteger f;
		timer.start();
		f=recursiveFibonacci(n);
		timer.end();
		sec=(timer.endTime-timer.startTime)/1000;
		System.out.println("===========================================================================");
		System.out.println(" "+n+"th fibonacci number-Recursive");
		System.out.println("Input Size: "+(n)+" Time: "+sec);
		System.out.println("===========================================================================");		
	}
}
