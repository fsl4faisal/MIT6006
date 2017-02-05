import java.io.*;
import java.util.*;

public class DijkstraAlgo {

    static class Vertex{
        int fromVertex;
        int toVertex;
        int edgeLength;
        //int distance;

        public Vertex(int fromVertex,int toVertex,int edgeLength){
            this.fromVertex=fromVertex;
            this.toVertex=toVertex;
            this.edgeLength=edgeLength;
            //this.distance=2147483647;
        }

        public String toString(){
            return "("+fromVertex+","+toVertex+","+edgeLength+")";
        }
    }

    static class Node implements Comparable<Node>{
        int vertex;
        int distance;

        public Node(int vertex,int distance){
            this.vertex=vertex;
            this.distance=distance;
        }

        public int compareTo(Node node){
            return this.distance-node.distance;
        }
    }

    public static void main(String[] args) throws IOException{
    
        Scanner scan=new Scanner(System.in);
        int T=scan.nextInt();
        for(int i=0;i<T;i++){
            int V=scan.nextInt();
            int E=scan.nextInt();
            //System.out.println(V +" "+E);

            int[] distTo=new int[V+1];
            int[] edgeTo=new int[V+1];
            boolean[] marked=new boolean[V+1];

            for(int j=1;j<=V;j++){
                distTo[j]=2147483647;
                edgeTo[j]=0;
                marked[j]=false;
            }

            Vertex vertex;
            List<Vertex>[] adj=(ArrayList<Vertex>[])new ArrayList[V+1];
            for(int j=1;j<=V;j++){ 
                adj[j]=new ArrayList<Vertex>();
            }

            for(int j=0;j<E;j++){
                int v=scan.nextInt();
                int w=scan.nextInt();
                int e=scan.nextInt();
                vertex=new Vertex(v,w,e);
                adj[v].add(vertex);
                vertex=new Vertex(w,v,e);
                adj[w].add(vertex);
            }
            int S=scan.nextInt();




            

            PriorityQueue<Node> specialPQ=new PriorityQueue<Node>();

            Node node;
            distTo[S]=0;

            for(int j=1;j<=V;j++){
                node = new Node(j,distTo[j]);
                specialPQ.add(node);
            }

            // for(int j=1;j<=V;j++)
            //     System.out.println(j+":"+distTo[j]);

            //System.out.println(distTo[S]);
            while(!specialPQ.isEmpty()){
                node=specialPQ.remove();
                int v=node.vertex;
                marked[v]=true;
                for(Vertex w:adj[v]){
                        //marked[w.fromVertex]=true;
                        if(marked[w.toVertex]==true)
                            continue;
                        Node backupNode=new Node(w.toVertex,distTo[w.toVertex]);
                        if(distTo[w.toVertex]>distTo[v]+w.edgeLength){
                            //System.out.println(distTo[v]+" "+w.edgeLength);
                            edgeTo[w.toVertex]=v;
                            distTo[w.toVertex]=distTo[v]+w.edgeLength;
                            specialPQ.remove(backupNode);
                            specialPQ.add(new Node(w.toVertex,distTo[w.toVertex]));
                        }
                    //System.out.println(w);
                }
            }

            // for(int j=1;j<=V;j++)
            //     System.out.print(edgeTo[j]+" ");
            // System.out.println();
            for(int j=1;j<=V;j++){
                if(j==S)
                    continue;
                if(distTo[j]<0)
                    distTo[j]=-1;
                //System.out.println(j+": "+edgeTo[j]+" "+distTo[j]+" ");
                System.out.print(distTo[j]+" ");
            }
            System.out.println();

        }
    }
}