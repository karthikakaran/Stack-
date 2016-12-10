/**Program - To compare performance of standard quick sort and Quick Sort using Dual Partition.
 * 
 */

/**
 * @author Nevhetha,Kritika,Karthika
 *
 */
import java.util.Random;
import java.util.Scanner;

class ArrayIns {
	private int[] theArray;
	private int elements;

	public ArrayIns(int size) {
		theArray = new int[size];
		elements = 0;
	}

	public void arrayInsert(int number) {
		theArray[elements] = number;
		elements++;
	}


	private void swap(int a, int b) {
		int temp = theArray[a];
		theArray[a] = theArray[b];
		theArray[b] = temp;
	}

	public void quickSort() {
		ranQuickSort(0, elements - 1);
	}
/**
 * ranQuickSort picks a random pivot and calls the Partition function to sort the array
 * @param left : points to the 1st element of the array
 * @param right : points to the last element of the array
 */
	private void ranQuickSort(int left, int right) {
		if ((right - left) <= 0)
			return;
		else {
			Random rand = new Random();
			int pivotIndex = left + rand.nextInt(right - left + 1);
			swap(pivotIndex, right);
			int pivot = theArray[right];
			int partition = partitionArray(left, right, pivot);
			ranQuickSort(left, partition - 1);
			ranQuickSort(partition + 1, right);
		}
	}
	
	/**
	 * partitionArray partitions the array in two parts with reference to the pivot
	 * @param left: Points to the 1st element of the array
	 * @param right: Points to the last element of the array
	 * @param pivot : contains the pivot element
	 * @return leftPtr : points to the position of the pivot element
	 */

	private int partitionArray(int left, int right, int pivot) {
		int leftPtr = left - 1;
		int rightPtr = right;

		while (true) {
			while (theArray[++leftPtr] < pivot)
				;
			while (rightPtr > 0 && theArray[--rightPtr] > pivot)
				;
			if (leftPtr >= rightPtr)
				break;
			else
				swap(leftPtr, rightPtr);
		}
		swap(leftPtr, right);
		return leftPtr;
	}

}

class DualArrayIns {
	private int[] theArray;
	private int elements;
	
	public DualArrayIns(int size) {
		theArray = new int[size];
		elements = 0;
	}
	
	public  void ArrayInsert(int value) {
		theArray[elements++] = value;
	}
	
	public void dualQuickSort(int n) {
		ranDualQuickSort(0,n-1);
	}
	
	private void swap(int a, int b) {
		int temp = theArray[a];
		theArray[a] = theArray[b];
		theArray[b] = temp;
	}
	
	/**
	 * ranQuickSort picks two pivot elements and partitions the array in three parts
	 * @param left : Points to the 1st element of the array
	 * @param right : Points to the last element of the array
	 */
	private void ranDualQuickSort(int left,int right) {
		if((right-left) <= 0)
			return;
		else {
			Random rand = new Random();
			int pivotIndex1 = left + rand.nextInt(right-left+1);
			int pivotIndex2 = left + rand.nextInt(right-left+1);
			swap(pivotIndex1,left);
			swap(pivotIndex2,right);
			if(theArray[left] > theArray[right])
				swap(left,right);
			int lt = left+1;
			int gt = right-1;
			int i = left+1;
			while(i<=gt) {
				if(theArray[i] < theArray[left])
					swap(lt++,i++);
				else if (theArray[right] < theArray[i])
					swap(i,gt--);
				else
					i++;
			}
			swap(left,--lt);
			swap(right,++gt);
			ranDualQuickSort(left,lt-1);
			if(theArray[lt] < theArray[gt])
				ranDualQuickSort(lt+1,gt-1);
			ranDualQuickSort(gt+1,right);

		}
	}
	
}

public class QuickSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Timer timer1 = new Timer();
		Timer timer2 = new Timer();
		int n,m,temp;
		ArrayIns arr1;
		DualArrayIns arr2;
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter the size of the array");
		n = reader.nextInt();
		arr1 = new ArrayIns(n);
		arr2 = new DualArrayIns(n);
		System.out.println("Select 0 to for generating random numbers");
		System.out.println("Select 1 to for generating only duplicate numbers");
		m = reader.nextInt();
		for (int i = 0; i < n; i++) {
			switch(m){
			case 0 : temp = (int)(1 + Math.random() * (n-0+1));
			         break;
			case 1 : temp = 1000000;
			         break;
			default : temp = (int)(1 + Math.random() * (n-0+1));
			         break;
			}
			arr1.arrayInsert(temp);
			arr2.ArrayInsert(temp);
		}
		timer1.start();
		arr1.quickSort();
		timer1.end();
		System.out.println("Quick Sort using Standard partition");
		System.out.println(timer1);
		timer2.start();
		arr2.dualQuickSort(n);
		timer2.end();
		System.out.println("Quick Sort using Dual Pivot partition");
		System.out.println(timer2);
		reader.close();

	}

}
