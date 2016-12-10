//===========================================================================================================================
//	Program : To perform merge sort
//===========================================================================================================================
//	@author: Nevhetha,Kritika,Karthika
// 	Date created: 2016/09/25
//===========================================================================================================================
import java.util.*;
import java.util.Scanner;

public class MergeSort<T extends Comparable<? super T>>{
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
		merge(arr, start, middle, middle + 1, end);
	}
	
	/** Procedure to sort by merging the two divided array
	 * @param arr : array, array to merge
	 * @param left : Integer, start index of the first array
	 * @param leftEnd : Integer, end index of the first array
	 * @param right : Integer, start index of the second array
	 * @param rightEnd : Integer, end index of the second array
	 */
	public void merge(T[] arr, int left, int leftEnd, int right, int rightEnd){
		//Copy only the sub list to sort and merge into Temp arraylist
		T[] tmpList = (T[]) new Integer[rightEnd - left + 1];
		int i = left;
		int j = right;
		int index = 0;
		//Copy which ever is smaller
		while(i <= leftEnd && j <= rightEnd){
			if(arr[i].compareTo(arr[j]) < 0){
				tmpList[index++] = arr[i++];
			} else {
				tmpList[index++] = arr[j++];
			}
		}
		//Copy remaining elements
		while(i <= leftEnd){
			tmpList[index++] = arr[i++];
		}
		while(j <= rightEnd){
			tmpList[index++] = arr[j++];
		}
		//Replace the actual list with sorted portion in the temp list
		for (int k = 0; k < tmpList.length; k++)
			arr[k + left] = tmpList[k];
	}

	public static void main(String[] args) {		
		int n = 0;
		System.out.println("Enter the power of 2 ::");
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		MergeSort<Integer> ms = new MergeSort<>();
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
