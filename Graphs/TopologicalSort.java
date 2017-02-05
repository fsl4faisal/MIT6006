import java.util.Stack;
import java.util.Iterator;
class TopologicalSort {
	private boolean[] marked;
	private int[] edgeTo;
	private Stack<Integer> revPostOrder;
	

	public TopologicalSort(Graph G){
		marked=new boolean[G.V()];
		edgeTo=new int[G.V()];
		revPostOrder=new Stack<Integer>();

		for(int i=0;i<G.V();i++)
			dfs(G,i);
	}
	public Stack<Integer> revPostOrder(){
		return revPostOrder;
	}

	private void dfs(Graph G,int v){
		if(marked[v]==true)
			return;
		marked[v]=true;

		for(int w:G.adj(v)){
			if(marked[w]==false){
				edgeTo[w]=v;
				dfs(G,w);
			}
		}
		//System.out.print(v);
		revPostOrder.push(v);

	}
}