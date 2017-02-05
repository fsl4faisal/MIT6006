class DepthFirstPaths {
	private boolean[] marked;
	private int[] edgeTo;

	public DepthFirstPaths(Graph G,int s){
		marked=new boolean[G.V()];
		edgeTo=new int[G.V()];
		dfs(G,s);


	}

	private void dfs(Graph G,int v){
		//Uncheck this to see order of DFS calls --also preorder
		//System.out.print(v);
		marked[v]=true;

		for(int w:G.adj(v)){
			if(marked[w]==false){
				edgeTo[w]=v;
				dfs(G,w);
			}
		}
		//Uncheck this to see order of DFS calls --also postorder
		System.out.print(v);		
	}	
}