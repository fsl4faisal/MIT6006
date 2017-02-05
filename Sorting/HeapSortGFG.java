import java.util.Arrays;

class HeapSortGFG {
	
	public static int[] sort(int[] arr){
		int N=arr.length;
		int[] sorted=new int[N];
		sorted=Arrays.copyOf(arr,N);

		for(int i=N/2-1;i>=0;i--)
			heapify(sorted,N,i);

		for(int i=0,j=N-1;i<N;i++,j--){
			swap(sorted,0,j);
			heapify(sorted,j,0);
		}

		//display(sorted);
		
		return sorted;

	}

	private static void heapify(int[] arr,int N,int i){
		int largest=i;
		int l=2*i+1;
		int r=2*i+2;

		if(l<N && arr[l]>arr[largest])
			largest=l;
		if(r<N && arr[r]>arr[largest])
			largest=r;
		if(largest!=i){
			swap(arr,largest,i);
			heapify(arr,N,largest);
		}
	}

	private static void swap(int[] arr,int i,int j){
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}

	public static void main(String[] args) {
		int[] arr={19,27,15,1,112,32,134,13,110,76};
		display(arr);

		arr=sort(arr);	

		display(arr);
	}

	public static void display(int[] arr){
		System.out.println("arr:");
		for(int i:arr)
			System.out.print(i+" ");
		System.out.println();
	}
}