import java.util.Arrays;
class HeapSortNew {

	public static int[] sort(int[] arr){
		int N=arr.length;
		int[] sorted=new int[N];
		sorted=Arrays.copyOf(arr,N);

		
		int counter=N;
		bottomUpHeapification(sorted,N);

		for(int i=0,j=N-1;i<N;i++,j--){
			swap(sorted,0,j);
			bubbleDown(sorted,0,j);
			System.out.println("iteration:"+(i+1));
			display(sorted);	
		}

		return sorted;

	}

	private static void bubbleDown(int[] arr,int k,int N){
		int leftChildIndex=leftChildOf(k);
		int rightChildIndex=rightChildOf(k);
		//nothing to sink
		if(leftChildIndex>=N){
			return;
		}

		//check only with leftChild
		else if(rightChildIndex>=N){

			if(arr[k]<arr[leftChildIndex]){
				int j=sink(arr,k,N);
				bubbleDown(arr,j,N);
			}
			else
				return;
		}

		//check with both child
		else{

			//no swap needed
			if(arr[k]>arr[leftChildIndex] && arr[k]>arr[rightChildIndex])
				return;
			else if(arr[leftChildIndex]>arr[k] && arr[leftChildIndex]>arr[rightChildIndex]){
				int j=sink(arr,k,N);
				bubbleDown(arr,j,N);
			}
			else if(arr[rightChildIndex]>arr[k] && arr[rightChildIndex]>arr[leftChildIndex]){
				int j=sink(arr,k,N);
				bubbleDown(arr,j,N);
			}
		}
		return;
	}


	private static void bottomUpHeapification(int[] arr,int N){
		int j=1;
		for(int i=N;i>=0;i--)
			sink(arr,i,N);
	}

	private static int sink(int[] arr,int k,int N){
		int leftChildIndex=leftChildOf(k);
		int rightChildIndex=rightChildOf(k);
		//nothing to sink
		if(leftChildIndex>=N){
			return k;
		}

		//check only with leftChild
		else if(rightChildIndex>=N){

			if(arr[k]<arr[leftChildIndex]){
				swap(arr,k,leftChildIndex);
				return leftChildIndex;
			}
			else
				return k;
		}

		//check with both child
		else{

			//no swap needed
			if(arr[k]>arr[leftChildIndex] && arr[k]>arr[rightChildIndex])
				return k;
			else if(arr[leftChildIndex]>arr[k] && arr[leftChildIndex]>arr[rightChildIndex]){
				swap(arr,k,leftChildIndex);
				return leftChildIndex;
			}
			else if(arr[rightChildIndex]>arr[k] && arr[rightChildIndex]>arr[leftChildIndex]){
				swap(arr,k,rightChildIndex);
				return rightChildIndex;
			}
		}
		return k;
	}

	private static void swap(int[] arr,int i,int j){
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}

	private static int leftChildOf(int index){
		return 2*index+1;
	}
	private static int rightChildOf(int index){
		return 2*index+2;
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