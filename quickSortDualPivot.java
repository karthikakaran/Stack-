import java.util.Random;
import java.util.Scanner;

public class quickSortDualPivot<T extends Comparable<? super T>> {

	public void swap(T[] arr, int one, int two) {
		T t = arr[one];
		arr[one] = arr[two];
		arr[two] = t;
	}

	public void sort(T[] arr, int low, int high) {
		if (low >= high)
			return;
		//Randomized pivot from random generator
		Random rand = new Random();
	    int piv1 = low + rand.nextInt(high - low);
	    swap(arr, low, piv1);
	    int piv2 = low + rand.nextInt(high - low);
	    swap(arr, high, piv2);
	    //Take first element as pivot1 and last element as pivot2
		//If first is larger than last element the n swap them and assign
		if (arr[low].compareTo(arr[high]) > 0) {
			swap(arr, low, high);
		}
		T pivot1 = arr[low];
		T pivot2 = arr[high];

		//lt pointer is one ahead of pivot1 and ht is one less than pivot2 
		int lt = low + 1;
		int gt = high - 1;
		//helper pointer to move set initialized to lt
		int i = lt;
		//loop till end
		while (i <= gt) {
			//if the element is smaller than pivot1 then place it in < than pivot1 sublist by swapping with lt pointer
			//and move the lt by one
			//keep placing them one after other in the sub list
			if (arr[i].compareTo(pivot1) < 0)
				swap(arr, i, lt++);
			//if the element is greater than or equal to pivot2 then place it in > than pivot2 sublist by swapping with gt pointer
			//and move the gt by one less
			//before that move gt to first place in that sub list
			else if (arr[i].compareTo(pivot2) >= 0) {
				while (arr[gt].compareTo(pivot2) > 0 && i < gt) {
					gt--;
				}
				swap(arr, i, gt);
				gt--;
				//check if the element that is swapped is less than pivot1 
				if (arr[i].compareTo(pivot1) < 0)
					swap(arr, i, lt++);
			}
			i++;
		}
		
		swap(arr, low, --lt);
		swap(arr, high, ++gt);
		// partition first half - below pivot1
		sort(arr, low, lt - 1);
		// partition second half - between pivot1 and pivot2
		sort(arr, lt + 1, gt - 1);
		// partition last half - greater than pivot2
		sort(arr, gt + 1, high);
	}

	public void println(T[] arr) {
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	public static void main(String[] args) {
		int n = (int)Math.pow(2, 26);
		Random rand = new Random();
		quickSortDualPivot<Integer> qss = new quickSortDualPivot<Integer>();
		Integer[] arr = new Integer[n];
		Scanner in = new Scanner(System.in);
		int j = 0;
		for (int i = n; i >= 1; i--) {
			arr[j] =  new Integer(n-3);
			j++;
		}
		//System.out.println("Before sorting :: ");
		//qss.println(arr);
		Timer time = new Timer();
		qss.sort(arr, 0, arr.length - 1);
		//System.out.println("Post sorting :: ");
		System.out.println(time.end());
		//qss.println(arr);
		in.close();
	}
}
