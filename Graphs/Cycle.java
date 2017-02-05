class Cycle {
	boolean[] marked;
	int[] edgeTo;
	boolean cycleFound=false;

	public Cycle(Graph g){
		marked=new boolean[g.V()];
		edgeTo=new int[g.V()];
	}
	public boolean testCycle(Graph G){
		boolean found=dfs(G,0);
		return found;
	}

	public boolean dfs(Graph G,int v){
		marked[v]=true;
		//System.out.print(v+"->");

		for(int w:G.adj(v)){
			//It's important to note here that I am not doing edgeTo[w]!=v 
			//beacuse that will lead to a circle in every case for undirected graphs
			//doing it like below is:-
			//edgeTo[v] meaning the node which is in consideration --v
			// if edgeTo[v] is w i.e. it is the node where v came from
			//0--[1]
			//1--[0,2]
			//when v is 0 w is 1 it's marked is false so it will never go in the first if 
			//when v is 1 then w is 0 and 2 in this case marked [0] is true and second condition
			//is checked leading edgeTo[1] (0) and w 0 so it won't consider the nodes where it came from
			
			if(marked[w]==true && w!=edgeTo[v]){
                cycleFound=true;
				System.out.println("cycleFound at:"+w);
				return cycleFound;
			}

			if(marked[w]==false){
				edgeTo[w]=v;
				return dfs(G,w);
			}
		}
		return cycleFound;
	}

	public static void main(String[] args) {
		Graph g=new Graph(5);
		g.addEdge(0,1);
		g.addEdge(1,2);
		g.addEdge(2,3);
		g.addEdge(2,4);
		//g.addEdge(3,4);
		
		
		Cycle cycle=new Cycle(g);
		System.out.println(cycle.testCycle(g));
		
	}

}