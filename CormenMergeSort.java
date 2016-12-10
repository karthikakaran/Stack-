//===========================================================================================================================
//	Program : To perform merge sort
//===========================================================================================================================
//	@author: Nevhetha,Kritika,Karthika
// 	Date created: 2016/09/25
//===========================================================================================================================
import java.util.*;
import java.util.Scanner;

public class CormenMergeSort<T extends Comparable<? super T>>{
	/** Procedure to recursively divide the list
	 * Runs in time O(nlogn) where n is the size of the array
	 * @param arr : array, to be sorted
	 * @param start : Integer, start index of the array
	 * @param end : Integer, end index of the array 
	 */
	//Divide the list into sublists
	public void mergeSort(T arr[], int start, int end){
		
		if(end - start < 1) return ;
		
		int middle = (start + end)/2;
		//Recursive calling
		mergeSort(arr, start, middle);
		mergeSort(arr,middle + 1, end);
		//Sending the sub lists to merge
		merge(arr, start, middle, end);
	}
	/** Procedure to sort by merging the two divided array
	 * @param arr : array, array to merge
	 * @param left : Integer, start index of the first array
	 * @param right : Integer, start index of the second array
	 * @param middle : Integer, middle index of array
	 */
	public void merge(T[] arr, int left, int middle, int right){
		//Copy only the sub list to sort and merge into Temp arraylist
		int n1 = middle - left + 1;
		int n2 = right - middle;
		T[] lArr = (T[]) new Integer[n1 + 1];
		T[] rArr = (T[]) new Integer[n2 + 1];
		int p = left;
		int q = middle;
		for (int index = 0; index < n1; index++) { 
			lArr[index] = arr[p++];
		}
		
		for (int index = 0; index < n2; index++) { 
			rArr[index] = arr[q+1];
			q++;
		}
		lArr[n1] = (T) new Integer(Integer.MAX_VALUE);
		rArr[n2] = (T) new Integer(Integer.MAX_VALUE);
		
		int i = 0;
		int j = 0;
		for (int k = left; k <= right; k++) {
			if(lArr[i].compareTo(rArr[j]) <= 0)
				arr[k] = lArr[i++];
			else
				arr[k] = rArr[j++];
		}
	}

	public static void main(String[] args) {		
		int n = 0;
		System.out.println("Enter the power of 2 ::");
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		CormenMergeSort<Integer> ms = new CormenMergeSort<>();
		Shuffle shuffle = new Shuffle();
		Integer[] arr = new Integer[(int) Math.pow(2, n)];
		for (int i = 0; i < (int) Math.pow(2, n); i++)
			arr[i] = new Integer(i + 1);
		shuffle.shuffle(arr);
		//shuffle.printArray(arr, "Before");
		System.out.println("Start...");
		Timer time = new Timer();
		ms.mergeSort(arr, 0, arr.length - 1);
		System.out.println(time.end());
		//shuffle.printArray(arr, "After");
		in.close();
	}
}
