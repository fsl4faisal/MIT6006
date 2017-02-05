import java.util.*;

class MonkInRealEstate {
    public static void main(String args[] ) throws Exception {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();

        for(int i=0;i<T;i++){
        	int E=scan.nextInt();

        	HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        	for(int j=0;j<E;j++){
        		int x=scan.nextInt();
        		int y=scan.nextInt();
        		if(map.containsKey(x)){
        			int value=map.get(x);
        			map.put(x,++value);
        		}
        		else
        			map.put(x,1);
        		if(map.containsKey(y)){
        			int value=map.get(y);
        			map.put(y,++value);
        		}
        		else
        			map.put(y,1);
        	}

        	System.out.println(map.keySet().size());
        }

    }
}
