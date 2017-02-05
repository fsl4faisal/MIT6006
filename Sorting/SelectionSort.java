import java.util.Arrays;
class SelectionSort {

	public static int[] sort(int[] arr){
		int N=arr.length;
		int[] sorted=new int[N];
		sorted=Arrays.copyOf(arr,N);

		
		for(int i=0;i<N;i++){
			int min=Integer.MAX_VALUE;
			int minIndex=-1;
			for(int j=i;j<N;j++){
				if(sorted[j]<min){
					min=sorted[j];
					minIndex=j;
				}
			}
			int temp=sorted[minIndex];
			sorted[minIndex]=sorted[i];
			sorted[i]=temp;
			// System.out.println("pass"+(i+1));
			// display(sorted);
		}
		return sorted;
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