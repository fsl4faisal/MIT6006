class TwoDPeakFinding {
	
	 class Peak{
		int i;
		int j;
		public String toString(){
			return "("+i+","+j+")";
		}
	}


	public Peak peakFinder(int[][] arr){
		Peak peak=new Peak();

		peak=peakFinderHelper(peak,arr,arr[0].length/2);

		return peak;
	}

	public Peak peakFinderHelper(Peak peak,int[][] arr,int j){
		int globalMaxI=globalMax(arr,j);
		peak.i=globalMaxI;

		if(getElement(arr,globalMaxI,j-1)>getElement(arr,globalMaxI,j))
			return peakFinderHelper(peak,arr,j-1);
		if(getElement(arr,globalMaxI,j+1)>getElement(arr,globalMaxI,j))
			return peakFinderHelper(peak,arr,j+1);
		else{
			peak.j=j;
			System.out.println(arr[peak.i][peak.j]);
			return peak;
		}
		
	}

	public int globalMax(int[][] arr,int j){
		int maxI=0;
		int max=Integer.MIN_VALUE;

		for(int i=0;i<arr.length;i++){
			if(arr[i][j]>max){
				max=arr[i][j];
				maxI=i;
			}
		}
		return maxI;
			
	}

	

	public int getElement(int[][] arr,int i,int j){
		try{
			return arr[i][j];
		}catch(ArrayIndexOutOfBoundsException e){
			return Integer.MIN_VALUE;
		}
	}
	public static void main(String[] args) {
		// int[][] arr=
		// {
		// 	{5,2,9,7,8},
		// 	{3,12,18,6,11},
		// 	{15,18,17,16,19},
		// 	{4,13,12,11,15}
		// };
		int[][] arr=
		{
			{5},
			{3},
			{15},
			{4}
		};
		TwoDPeakFinding finder=new TwoDPeakFinding();

		System.out.println("peak is at: "+finder.peakFinder(arr));

	}
}