//=============================================================================================================================================
//						Program : To sort the given array using merge sort ( using an auxillary array)
//=============================================================================================================================================
//	@author: Nevhetha,Kritika,Karthika
// 	Date created: 2016/09/20
//	Date modified: 2016/09/24
//=============================================================================================================================================
/**
 * To sort the given array using merge Sort
 * Running time: O(nlog n)
 * 
 */
public class MergeSortTake2<T extends Comparable<? super T>> {
	/**
	 * To calculate the power of a given number
	 * @param i : int - number whose power is to be found
	 * @param n : int - raised to value
	 * @return power(i,n): int - i^n
	 */
	private static int power(int i, int n) {
		if(n==1)
			return i;
		int p=power(i,n/2);
		if(n%2==0)
			return p*p;
		else
			return p*p*i;
	}
	/**
	 * 
	 * @param arr: T[] - array to be sorted
	 */
	private void mergeSort(T[] arr) {
		T[] b=(T[])new Integer[arr.length];
		mergeSort(arr,b,0,arr.length-1);	
	}
	/**
	 * 
	 * @param arr: T[]- array to be sorted
	 * @param b:   T[]- auxillary array of the size of original array 
	 * @param low: int- the lower index from where the array is to be sorted
	 * @param high: int- the upper index upto which the array is to be sorted
	 */
	private void mergeSort(T[] arr,T[] b, int low, int high) {
		if(high>low){
			int middle;
			middle=(low+high)/2;
			mergeSort(arr,b,low,middle);
			mergeSort(arr,b,middle+1,high);
			merge(arr,b,low,middle,high);
		}
	}
	/**
	 * 
	 * @param arr: T[]- array to be sorted
	 * @param b:   T[]- auxillary array of the size of original array 
	 * @param low: int- the lower index from where the array is to be sorted
	 * @param high: int- the upper index upto which the array is to be sorted
	 * @param middle:int - middle=high-low
	 * 
	 */
	private void merge(T[] arr,T[] b, int low, int middle, int high) {
		copy(arr,low,high,b);
		int i=low;
		int j=middle+1;
		for(int k=low;k<=high;k++){
			if(j>i||((i<=middle)&&b[i].compareTo(b[j])<=0))
					arr[k]=b[i++];
			else
				arr[k]=b[j++];
		}
		
	}
	/**
	 * 
	 * @param arr : T[] - array to be copied
	 * @param low :int - lower index from where the array is to be copied
	 * @param high: int- upper index till which the array is to be copied
	 * @param b: T[]- array to be copied to
	 */
	private void copy(T[] arr, int low, int high, T[] b) {
		for(int i=low;i<=high;i++)
			b[i]=arr[i];
	}
	public static void main(String[] args) {
		int n=25;
		MergeSortTake2 s=new MergeSortTake2();
		Integer[] arr=new Integer[power(2,n)];
		for(int i=0;i<arr.length;i++)
			arr[i]=new Integer(i+1);
		Timer timer=new Timer();
		Shuffle.shuffle(arr);
		timer.start();
		s.mergeSort(arr);
		timer.end();
		long secs=(timer.endTime-timer.startTime)/1000;
		System.out.println("=================================================");
		System.out.println("MERGE SORT ANALYSIS");
		System.out.println("=================================================");
		System.out.println("Array Size in powers of 2"+n+"  Time Taken: "+secs+" secs");
		System.out.println("=================================================");
	}
}
