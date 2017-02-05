import java.util.Arrays;

class MergeSortGFG {
	
	public static int[] sort(int[] arr){
		int N=arr.length;
		int[] sorted=new int[N];
		sorted=Arrays.copyOf(arr,N);

		mergeSort(sorted,0,N-1);
		return sorted;
	}

	public static void mergeSort(int[] arr,int low,int high){
		if(low<high){
			//System.out.println("mergeSort:"+low+" "+high);
			int middle=(high+low)/2;
			mergeSort(arr,low,middle);
			mergeSort(arr,middle+1,high);
			merge(arr,low,middle,high);
		}
	}

	public static void merge(int[] arr,int low,int middle,int high){
		int[] left=new int[middle-low+1];//2-0+1--3
		int[] right=new int[high-middle];
		//System.out.println("merge:"+low+" "+middle+" "+high);
		int k=low;
		for(int i=0;i<left.length;i++)
			left[i]=arr[k++];

		k=middle+1;

		for(int i=0;i<right.length;i++)
			right[i]=arr[k++];

		int i=0,j=0;
		for(k=low;k<=high;k++){
			if(left[i]<=right[j]){
				arr[k]=left[i];
				i++;
			}else{
				arr[k]=right[j];
				j++;
			}
			if(i==left.length){
				System.arraycopy(right,j,arr,k+1,right.length-j);
				return;
			}
			if(j==right.length){
				System.arraycopy(left,i,arr,k+1,left.length-i);
				return;
			}
		}
	}

	

	public static void main(String[] args) {
		int[] arr={9,7,15,-101,12,2,14,3,10,6};
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