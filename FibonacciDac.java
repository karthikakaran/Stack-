//=============================================================================================================================================
//						Program : To find the fibonacci(n) using divide and conquer
//=============================================================================================================================================
//	@author: Nevhetha,Kritika,Karthika
// 	Date created: 2016/09/20
//	Date modified: 2016/09/24
//=============================================================================================================================================
import java.math.BigInteger;
/** Divide and Conquer Strategy to find fibonacci(n):
 * 	Running time: O(log n)
 * 			| 1	 1 |
 * 	matrix=	|      |
 *			| 1	 0 |
 *
 *				| fibonacci(n+1)	 fibonacci(n)  |
 * 	(matrix)^n=	|      							   |
 *				| fibonacci(n)	 	fibonacci(n-1) |
 */
public class FibonacciDac {
	/** @param n : int - number whose corresponding value in fibonacci series is to be found
	 * 
	 * 
	 * @return [1][1] th value from the matrix which corresponds to fibonacci(n) :BigInteger
	 */
	private static BigInteger dacFibonacci(int n) {
		BigInteger[][] matrix=new BigInteger[2][2];
		matrix[0][0]=new BigInteger("1");
		matrix[0][1]=new BigInteger("1");
		matrix[1][0]=new BigInteger("1");
		matrix[1][1]=new BigInteger("0");
		matrix=power(matrix,n);
		return matrix[1][1];
	}
	/** 
	 * 
	 * @param matrix: BigInteger[][]- matrix whose power is to be found
	 * @param n: int - raised to value
	 * @return BigInteger[][] - matrix raised to power n
	 */
	private static BigInteger[][] power(BigInteger[][] matrix,int n) {
		BigInteger [][] m=new BigInteger[2][2];
		if(n==1)
			return matrix;
		if(n==2) {
			return multiply(matrix,matrix);
		}
		else {
			m=power(matrix,n/2);
			if(n%2==0)
				return power(m,2);
			else
				return multiply(power(m,2),matrix);
		}
	}
	/**
	 * 
	 * @param matrix :BigInteger[][] - multiplier
	 * @param matrix2 : BigInteger[][] - multiplicand
	 * @return m: BigInteger[][] - product of multiplier*multiplicand
	 */
	private static BigInteger[][] multiply(BigInteger[][] matrix, BigInteger[][] matrix2) {
		BigInteger[][] m=new BigInteger[2][2];
		for(int i=0;i<2;i++) {
			for(int j=0;j<2;j++) {
				m[i][j]=new BigInteger("0");
				for(int k=0;k<2;k++)
					m[i][j]=m[i][j].add(matrix[i][k].multiply(matrix2[k][j]));
			}
		}
		return m;
	}
	public static void main(String[] args) {
		int n=66899999;
		long sec=0;
		BigInteger f;
		Timer timer=new Timer();
		timer.start();
		f=dacFibonacci(n);
		timer.end();
		sec=(timer.endTime-timer.startTime)/1000;
		System.out.println("===========================================================================");
		System.out.println(" "+n+"th fibonacci number-DAC");
		System.out.println("Input Size: "+n+" Time: "+sec+" secs");
		System.out.println("===========================================================================");
	}
}
