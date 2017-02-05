import java.io.*;
import java.util.*;

class QuickSort {

	public static void quickSort(int[] arr,int p,int r){
		//System.out.println("\nRunning QuickSort");
		if(p<r){
			int q=partition(arr,p,r);
			//System.out.print(arr[q]+" ");
			quickSort(arr,p,q-1);
			quickSort(arr,q+1,r);
		}
	}

	public static void quickSort(int[] arr){
		quickSort(arr,0,arr.length-1);
	}

	public static int partition(int[] arr,int low,int high){
		if(low==high)
			return low;
		
		int pivot=arr[high];
		int i=low;
		for(int j=low;j<high;j++){
			if(arr[j]<=pivot){
				int temp=arr[i];
				arr[i]=arr[j];
				arr[j]=temp;
				i++;
			}
		}
		int temp=arr[high];
		arr[high]=arr[i];
		arr[i]=temp;

		for(int c:arr)
			System.out.print(c+" ");
		System.out.println();

		return i;
	}

	public static void main(String[] args) {
		int[] arr={9,7,5,11,12,2,14,3,10,6};

		
		for(int i:arr)
			System.out.print(i+" ");
		System.out.println();

		// Scanner scan=new Scanner(System.in);
		// int length=scan.nextInt();

		// int[] arr=new int[length];

		// for(int i=0;i<length;i++)
		// 	arr[i]=scan.nextInt();

		quickSort(arr);

		System.out.println("\nSorted:");
		for(int i:arr)
			System.out.print(i+" ");
		System.out.println();

	}
}