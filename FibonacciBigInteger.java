/**
 * Program - find the largest value
   of n for which f(n) can be computed in less than 1 mins using dynamic programming.
 */
/**
 * @author Kritika,Karthika, Nevhetha
 */
import java.util.*;
import java.math.BigInteger;

class FibonacciSeries {
	
	BigInteger zero,one,two,answer;
	static BigInteger [][]F= new BigInteger[][]{{BigInteger.valueOf(1),BigInteger.valueOf(1)},{BigInteger.valueOf(1),BigInteger.valueOf(0)}};
	
	FibonacciSeries() {
	zero = new BigInteger("0");
	one = new BigInteger("1");
	two = new BigInteger("2");
	}
	
	/**
	 * DynamicFibonacci displays the f(n) for n = a
	 * @param a: contains the number for which we need to display the f(n)
	 */
	public BigInteger dynamicFibonacci(int a) {
		
	answer = new BigInteger("0");
        for(int i=2; i<=a; i++){

            //Fibonacci number is sum of previous two Fibonacci number
            answer = zero.add(one);             
            zero = one;
            one = answer;
        }
        return answer;
	}
	
}

public class FibonacciBigInteger {
	public static void main(String args[]) {
		int n;
		Timer timer = new Timer();
        System.out.println("Type a postive Integer");
		Scanner reader = new Scanner (System.in);
		n = reader.nextInt();
		FibonacciSeries obj = new FibonacciSeries();
		BigInteger outputDynamic = new BigInteger("0");
		timer.start();
        outputDynamic = obj.dynamicFibonacci(n);
        timer.end();
		System.out.println(outputDynamic);
		System.out.println(timer);

		reader.close();
		
		}

}
