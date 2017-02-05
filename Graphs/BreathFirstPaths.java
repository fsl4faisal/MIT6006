import java.util.Queue;
import java.util.ArrayDeque;

class BreathFirstPaths {
	private boolean[] marked;
	private int[] edgeTo;
	private int s;
	private Queue<Integer> fringe;
	public BreathFirstPaths(Graph G,int s){
		marked=new boolean[G.V()];
		edgeTo=new int[G.V()];
		fringe=new ArrayDeque<Integer>();
		//fringe.insert(s);
		marked[s]=true;
		fringe.add(s);
		bfs(G);
	}

	public boolean[] getMarked(){
		return marked;
	}

	public int[] getEdgeTo(){
		return edgeTo;
	}

	private void bfs(Graph G){
		while(!fringe.isEmpty()){
			int v=fringe.remove();
			System.out.println("adj:"+v+" "+G.adj(v));
			for(int w:G.adj(v)){
				if(marked[w]==false){
					marked[w]=true;
					edgeTo[w]=v;
					fringe.add(w);
				}
			}
		}
	}
}