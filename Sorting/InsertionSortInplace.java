import java.util.Arrays;

class InsertionSortInplace {

	public static int[] sort(int[] arr){
		int N=arr.length;
		int[] sorted=new int[N];
		sorted=Arrays.copyOf(arr,N);

		int k=0;
		for(int i=0;i<N;i++){
			for(int j=i;j>=1;j--){
				if(sorted[j]<sorted[j-1])
					swap(sorted,j,j-1);
			}
			k++;
		}
		
		
		return sorted;
	}

	private static void swap(int[] arr,int i,int j){
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	
	public static void main(String[] args) {
		int[] arr={9,7,5,11,12,2,14,3,10,6};
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