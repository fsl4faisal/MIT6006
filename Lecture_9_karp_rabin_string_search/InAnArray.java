import java.util.*;

class InAnArray {

	private static class Pair{
		int i;
		int j;

		Pair(int i,int j){
			this.i=i;
			this.j=j;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + i;
			result = prime * result + j;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Pair other = (Pair) obj;
			if (i != other.i)
				return false;
			if (j != other.j)
				return false;
			return true;
		}

    	public String toString(){
    		return "("+i+","+j+")";
    	}
    	
    	
	}
public static void main(String args[] ) throws Exception {
	Scanner scan = new Scanner(System.in);
	int N = scan.nextInt();
	int K=scan.nextInt();
	int X=scan.nextInt();
	int Y=scan.nextInt();

	int[] arr=new int[N];

	for(int i=0;i<N;i++)
		arr[i]=scan.nextInt();

	long counter=0;
	HashMap<Pair,Integer> map=new HashMap<Pair,Integer>();
	java.util.Arrays.sort(arr);
	
	for(int i=0;i<N;i++){
		for(int j=i+1;j<N;j++){

			Pair pair=new Pair(arr[i],arr[j]);
			int count=0;
			if(map.containsKey(pair))
				count=map.get(pair);

			map.put(pair,++count);

		}
	}
	//System.out.println(map);

	for(Pair pair:map.keySet()){
		int varient1=(pair.i+pair.j)%K;
		int varient2=(pair.i*pair.j)%K;
		if(varient1==X && varient2==Y)
			counter=counter+(map.get(pair));
	}

	System.out.println(counter);

}
}
