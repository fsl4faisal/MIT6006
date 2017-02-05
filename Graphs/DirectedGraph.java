import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class DirectedGraph{
	public final int v;

	private List<Integer>[] adj;

	public DirectedGraph(int v){
		this.v=v;
		adj=(List<Integer>[])new ArrayList[v];

		for(int i=0;i<v;i++)
			adj[i]=new ArrayList<Integer>();
	}
	public void addEdge(int v,int w){
		adj[v].add(w);
	}


	public Iterable<Integer> adj(int v){
		return adj[v];
	}

	public int V(){
		return v;
	}
}