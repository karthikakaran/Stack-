import java.util.Random;
import java.util.Scanner;

public class quickSortStandard<T extends Comparable<? super T>> {
	
   //Lomutu algorithm - Cormen's
	public int partition (T[] arr, int low, int high) {
		//Randomized pivot from random generator
		Random rand = new Random();
	    int pivot = low + rand.nextInt(high - low);
	    
	    //Swap high and pivot and take high as pivot
	    T temp = arr[pivot];
 		arr[pivot] = arr[high];
 		arr[high] = temp;
 		T pivotValue = arr[high];
 		
 		//Set i pointer before low
	    int i = low - 1;
	    //loop through the elements and swap if arr element is larger than pivot
	    for(int j = low; j < high; j++)
	    {
	        if(arr[j].compareTo(pivotValue) < 0)
	        {
	            i++;
	           // if (i != j) can be added to avoid swap of same elements - my check
	            T tmp = arr[i];
	   	 		arr[i] = arr[j];
	   	 		arr[j] = tmp;
	        }
	    }
	    //Swap the pivot and i + 1 element - placing the pivot in right place (partition operation)
	    //if (i + 1 != high)  can be added to avoid swap of same elements - my check
	    T t = arr[i+1];
 		arr[i+1] = arr[high];
 		arr[high] = t;      
	    
 		//Return pivot position
	    /*by this pivot is brought to center and so further it is not considered for sorting
	    only elements lower than pivot and higher than pivot are processed*/
	    return i+1;
	}
	
	public void sort(T[] arr, int low, int high) {
		if (low < high) {
			int partIndex = partition(arr, low, high);
			//partition first half
			sort(arr, low, partIndex - 1);
			//partition second half
			sort(arr, partIndex + 1, high);
		}
	}
	
	public void println(T[] arr) {
		for (int i = 0; i < arr.length; i++ ){
			
		}
			System.out.print(arr[arr.length-1] + " ");
		System.out.println();
	}
	
	public static void main(String[] args) {
		int n = (int)Math.pow(2, 26);
		Random rand = new Random();
		quickSortStandard<Integer> qss = new quickSortStandard<Integer>();
		Integer[] arr = new Integer[n];
		Scanner in = new Scanner(System.in);
		int j = 0;
		for (int i = n; i >= 1; i--) {
			arr[j] = new Integer(100);
			j++;
		}
		//System.out.println("Before sorting :: ");
		//qss.println(arr);
		Timer time = new Timer();
		qss.sort(arr, 0, arr.length - 1);
		System.out.println("Post sorting :: ");
		System.out.println(time.end());
		//qss.println(arr);
		in.close();
	}
}
