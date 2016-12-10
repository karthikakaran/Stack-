/**Program - Insertion sort.
 * 
 */

/**
 * @author Nevhetha,Kritika,Karthika
 *
 */
import java.util.*;

public class InsertionSort<T extends Comparable<? super T>> {
	/**
	 * insertionSort sorts the array by shuffling the smallest elements and sort one position at a time 
	 * @param arr[] : array to be sorted
	 */		
	public void insertionSort(T[] arr){
		int j = 0;
		T x= null;
		for (int i = 1 ; i < arr.length ; i++) {
			j = i - 1;
			x = (T) arr[i];
			while(j >= 0 && arr[j].compareTo(x) > 0) {
				arr[j + 1] = arr[j];
				j = j - 1;
			}
			arr[j + 1] = x;
		}
	}
	
	public static void main(String[] args) {
		int n = 0;
		System.out.println("Enter the power of 2 ::");
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		InsertionSort<Integer> is = new InsertionSort<>();
		Shuffle shuffle = new Shuffle();
		Integer[] arr = new Integer[(int) Math.pow(2, n)];
		for (int i = 0; i < (int) Math.pow(2, n); i++)
			arr[i] = new Integer(i + 1);
		shuffle.shuffle(arr);
		//shuffle.printArray(arr, "Before");
		System.out.println("Start...");
		Timer time = new Timer();
		is.insertionSort(arr);
		System.out.println(time.end());
		//shuffle.printArray(arr, "After");
	}

}
