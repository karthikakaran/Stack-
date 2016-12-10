import java.util.*;
import java.util.Scanner;

public class MergeSortNoCopy<T extends Comparable<? super T>>{

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
	public int mergeSort(T arr[], T[] arrB, int start, int end){
		int h1 = 0, h2 = 0;
		if(end - start < 1) return 0;
		if (end - start <= 20) {
			insertionSort(arr, start, end);
			return 0;
		} else {
			int middle = (start + end)/2;
			//Recursive calling
			h1 = mergeSort(arr, arrB, start, middle);
			h2 = mergeSort(arr, arrB, middle + 1, end);
			if (h1 != h2) {
				System.err.println("Not power of 2");
				System.exit(0);
			} else {
				if (h1 %2 != 0)
					//Sending the sub lists to merge
					merge(arrB, arr, start, middle, end);
				else
					//Sending the sub lists to merge
					merge(arr, arrB, start, middle, end);
			}
			return h1+1;
		}
	}
	
	public void merge(T[] arr, T[] arrB, int left, int middle, int right){
		//Copy only the sub list to sort and merge into Temp arraylist
		for (int index = left; index <= right; index++) { 
			arrB[index] = arr[index];
		}
		int i = left;
		int j = middle + 1;
		for (int index = left; index <= right; index++) {
			if (j > right || (i <= middle && arr[i].compareTo(arr[j]) <= 0))
				arrB[index] = arr[i++];
			else 
				arrB[index] = arr[j++];
		}
	}

	public static void main(String[] args) {		
		int n = 0;
		System.out.println("Enter the power of 2 ::");
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		MergeSortNoCopy<Integer> ms = new MergeSortNoCopy<>();
		Shuffle shuffle = new Shuffle();
		Integer[] arr = new Integer[(int) Math.pow(2, n)];
		Integer[] arrB = new Integer[(int) Math.pow(2, n)];
		for (int i = 0; i < (int) Math.pow(2, n); i++)
			arr[i] = new Integer(i + 1);
		shuffle.shuffle(arr);
		//shuffle.printArray(arr, "Before");
		System.out.println("Start...");
		Timer time = new Timer();
		int h = 0;
		h = ms.mergeSort(arr, arrB, 0, arr.length - 1);
		if (h % 2 != 0)
			h = ms.mergeSort(arrB, arr, 0, arrB.length - 1);
		System.out.println(time.end());
		//shuffle.printArray(arr, "After");
		in.close();
	}
}