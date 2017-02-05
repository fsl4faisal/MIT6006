import java.util.ArrayDeque;
import java.util.Queue;

class ShortestCycleUsingBFS {
	  boolean[] marked;
	  int[] edgeTo;
	  int[] distTo;
	  int minCycle;
	public ShortestCycleUsingBFS(DirectedGraph g){
		edgeTo=new int[g.V()];
		

		for(int i=0;i<g.V();i++){
			distTo=new int[g.V()];
			marked=new boolean[g.V()];
			distTo[i]=0;
			System.out.println(bfs(g,i,i));
			
			// for(int j=0;j<distTo.length;j++)
			// 	System.out.print(distTo[j]+" ");
			//System.out.println();
		}

	}

	public int bfs(DirectedGraph G,int source,int i){
		marked[i]=true;
		Queue<Integer> queue=new ArrayDeque<Integer>();

		queue.add(i);

		while(!queue.isEmpty()){
			int v=queue.remove();

			for(int w:G.adj(v)){
				if(marked[w]==false){
					marked[w]=true;
					distTo[w]=v+1;
					queue.add(w);
				}
				if(distTo[w]>distTo[v]+1){
					distTo[w]=distTo[1]+1;
					queue.add(w);
				}
			}
		}

		for(i=0;i<G.V();i++)
			for(int w:G.adj(i))
				if(w==source)
					return distTo[w]+1;
		return -1;
	}
	
	public static void main(String[] args) {
		DirectedGraph dg=new DirectedGraph(8);
		dg.addEdge(0,1);
		dg.addEdge(0,3);
		dg.addEdge(1,4);
		dg.addEdge(2,5);
		dg.addEdge(3,2);
		dg.addEdge(4,3);
		dg.addEdge(4,6);//6-->6
		dg.addEdge(4,7);		
		dg.addEdge(5,4);//5-->4
		dg.addEdge(6,5);//6-->5
		int[] cycleLength=new int[dg.V()];

		int min=99999;

		for(int i=0;i<dg.V();i++)
			System.out.println(i+":"+dg.adj(i));

		ShortestCycleUsingBFS cycles=new ShortestCycleUsingBFS(dg);

	}
}