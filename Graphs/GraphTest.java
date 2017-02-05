class GraphTest {
	public static void main(String[] args) {
		Graph g=new Graph(9);
		g.addEdge(0,1);
		g.addEdge(1,2);
		g.addEdge(1,4);
		g.addEdge(2,5);
		g.addEdge(3,4);
		g.addEdge(4,5);
		g.addEdge(5,6);
		g.addEdge(5,8);
		g.addEdge(6,7);

		
		Cycle cycle=new Cycle(g);
		cycle.testCycle(g);

		// BreathFirstPaths bfs=new BreathFirstPaths(g,0);
		// for(boolean bool:bfs.getMarked())
		// 	System.out.print(bool+" ");
		// System.out.println();
		// for(int i:bfs.getEdgeTo())
		// 	System.out.print(i+" ");
		// DepthFirstPaths dfs=new DepthFirstPaths(g,0);

		// Graph G2=new Graph(8);
		// G2.addEdge(0,1);
		// G2.addEdge(0,3);
		// G2.addEdge(1,4);
		// G2.addEdge(2,3);
		// G2.addEdge(2,5);
		// G2.addEdge(3,4);
		// G2.addEdge(4,7);	
		// G2.addEdge(5,4);
		// G2.addEdge(5,6);

		// TopologicalSort tp=new TopologicalSort(G2);
		// System.out.println();

		// while(!tp.revPostOrder().isEmpty())
		// 	System.out.print(tp.revPostOrder().pop());
	}

}