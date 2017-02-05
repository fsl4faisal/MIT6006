import java.util.Arrays;


class QuickSort {
	public static int[] sort(int[] arr){
		int N=arr.length;
		int[] sorted=new int[N];
		sorted=Arrays.copyOf(arr,N);

		quicksort(sorted,0,sorted.length-1);
		
		return sorted;
	}

	public static void quicksort(int[] arr,int low,int high){
		if(low<high){
			int q=partition(arr,low,high);

			quicksort(arr,low,q-1);
			quicksort(arr,q+1,high);
		}
	}


	/*In this partition algorithm we start by choosing a pivot from the right most 
	**side of the array. We start scanning from the left most side of the array.
	**Use i pointer to the start of the array, j pointer to scan till the next last 
	**of the pivot.
	**Whenever we encounter an element less than or equal to pivot we swap with arr[i] 
	**and arr[j] increment i after that.
	** doing such operation till high-1 times we finally swap the ith position with 
	**pivot and return the ith position.
	**/
	public static int partition(int[] arr,int low,int high){
		if(low==high)
			return low;
		int pivot=arr[high];
		int i=low;
		for(int j=low;j<=high-1;j++){
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
		System.out.println("partition:"+low+" "+high);
		display(arr);

		return i;
	}
	

	public static void main(String[] args) {
		int[] arr={9,7,5,11,12,-02,14,13,10,6};

		
		for(int i:arr)
			System.out.print(i+" ");
		System.out.println();

		arr=sort(arr);

		System.out.println("\nSorted:");
		for(int i:arr)
			System.out.print(i+" ");
		System.out.println();

	}

	public static void display(int[] arr){
		System.out.println("arr:");
		for(int i:arr)
			System.out.print(i+" ");
		System.out.println();
	}
}