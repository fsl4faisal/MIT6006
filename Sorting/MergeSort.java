import java.util.Arrays;

class MergeSort {
	
	public static int[] sort(int[] arr){
		int N=arr.length;
		int[] sorted=new int[N];
		sorted=Arrays.copyOf(arr,N);

		
		return sorted;
	}

	public static int[] mergeSortedArray(int[] arr1,int[] arr2){
		int[] arr3=new int[arr1.length+arr2.length];
		int i=0,j=0;

		for(int k=0;k<arr3.length;k++){
			if(i<arr1.length && j<arr2.length){
				if(arr1[i]<=arr2[j]){
					arr3[k]=arr1[i];
					i++;
				}
				else{
					arr3[k]=arr2[j];
					j++;
				}
			}
			//arr2 is copied 
			if(j==arr2.length){
				System.arraycopy(arr1,i,arr3,k+1,arr1.length-i);
				return arr3;
			}
			//arr1 is copied
			if(i==arr1.length){
				System.arraycopy(arr2,j,arr3,k+1,arr2.length-j);
				return arr3;
			}
			
			
		}
		return arr3;
	}

	public static void main(String[] args) {
		// int[] arr={9,7,5,11,12,2,14,3,10,6};
		// display(arr);
		// arr=sort(arr);	
		// display(arr);
		int[] arr2={2,3,5};
		int[] arr1={1,6,7,8,9,10};

		int[] arr3=mergeSortedArray(arr1,arr2);

		display(arr3);

	}

	public static void display(int[] arr){
		System.out.println("arr:");
		for(int i:arr)
			System.out.print(i+" ");
		System.out.println();
	}
}