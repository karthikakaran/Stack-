import java.util.*;
import java.util.Scanner;

public class MergeSortWithArrBInsertion<T extends Comparable<? super T>>{

	//Insertion sort
	public void insertionSort(T[] arr, int start, int end){
		int j = start;
		T x= null;
		for (int i = start + 1 ; i <= end ; i++) {
			j = i - 1;
			x = (T) arr[i];
			while(j >= start && arr[j].compareTo(x) > 0) {
				arr[j + 1] = arr[j];
				j = j - 1;
			}
			arr[j + 1] = x;
		}
	}
	
	//Divide the list into sublists
	public void mergeSort(T arr[], T[] arrB, int start, int end){
		
		if(end - start < 1) return ;
		
		if (end - start <= 10) {
			//is = new InsertionSort<>();
			insertionSort(arr, start, end);
		}
		
		int middle = (start + end)/2;
		//Recursive calling
		mergeSort(arr, arrB, start, middle);
		mergeSort(arr, arrB, middle + 1, end);
		//Sending the sub lists to merge
		merge(arr, arrB, start, middle, end);
	}
	
	public void merge(T[] arr, T[] arrB, int left, int middle, int right){
		//Copy only the sub list to sort and merge into Temp arraylist
		for (int index = left; index <= right; index++) { 
			arrB[index] = arr[index];
		}
		int i = left;
		int j = middle + 1;
		for (int index = left; index <= right; index++) {
			if (j > right || (i <= middle && arrB[i].compareTo(arrB[j]) <= 0))
				arr[index] = arrB[i++];
			else 
				arr[index] = arrB[j++];
		}
	}

	public static void main(String[] args) {		
		int n = 0;
		System.out.println("Enter the power of 2 ::");
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		MergeSortWithArrBInsertion<Integer> ms = new MergeSortWithArrBInsertion<>();
		Shuffle shuffle = new Shuffle();
		Integer[] arr = new Integer[(int) Math.pow(2, n)];
		Integer[] arrB = new Integer[(int) Math.pow(2, n)];
		for (int i = 0; i < (int) Math.pow(2, n); i++)
			arr[i] = new Integer(i + 1);
		shuffle.shuffle(arr);
		//shuffle.printArray(arr, "Before");
		System.out.println("Start...");
		Timer time = new Timer();
		//if (arr.length % 2 != 0)
		ms.mergeSort(arr, arrB, 0, arr.length - 1);
		System.out.println(time.end());
		//shuffle.printArray(arr, "After");
		in.close();
	}
}
