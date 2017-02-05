class OneDPeakFinding {
	public static int peakFinder(int[] arr){
		int index=peakFinderHelper(arr,0,arr.length-1);
		return index;
	}

	public static int peakFinderHelper(int[] arr,int low,int high){

		int mid=(low+high)/2;

		if(getElement(arr,mid)<=getElement(arr,mid+1))
			return peakFinderHelper(arr,mid+1,high);
		if(getElement(arr,mid)<=getElement(arr,mid-1))
			return peakFinderHelper(arr,low,mid-1);
		else
			return mid;
	}
	public static int getElement(int[] arr,int index){
		try{
			return arr[index];
		}catch(ArrayIndexOutOfBoundsException e){
			return Integer.MIN_VALUE;
		}
	}
	public static void main(String[] args) {
		int[] arr={100, 80, 60, 50, 20};

		System.out.println("peak is at: "+peakFinder(arr));

	}
}