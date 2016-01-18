package graph;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class dijkstra {
	
	private class pq{
		Node[] heap;
		int heapsize;
		int[] loc;
		pq(int n){
			heap = new Node[n];
			loc = new int[n];
			heapsize = 0;
		}
		int parent(int i){
			return (i%2==0)? i/2-1: (i-1)/2;
		}
		int left(int i){
			return 2*i+1;
		}
		int right(int i){
			return 2*i+2;
		}
		
		void min_heapify(int i){
			int l = left(i);
			int r = right(i);
			int min = i;
			if(l<heapsize&&heap[i].d>heap[l].d){
				min = l;
			}
			if(r<heapsize&&heap[min].d>heap[r].d){
				min = r;
			}
			if(min!=i){
				swap(i,min);
				min_heapify(min);
			}
		}
		Node extractMin(){
			Node a = heap[0];
			heap[0] = heap[heapsize-1];
			heapsize--;
			min_heapify(0);
			return a;
		}
		
		void swap(int a, int b){
			Node m = heap[a];
			heap[a] = heap[b];
			heap[b] = m;
			loc[heap[a].key] = a;
			loc[heap[b].key] = b;
		}
		
		void insert(Node n){
			heapsize++;
			heap[(heapsize-1)] = n;
			
			loc[n.key] = heapsize-1;
			
			int i = heapsize-1;
			while(i>0&&heap[parent(i)].d>heap[i].d){
				swap(i,parent(i));
				i = parent(i);
			}
			
		}
		public void decreaseKey(int i,int w) {
			
			int l = loc[i];
			heap[l].d = w;
			while(l>0&&heap[parent(l)].d>heap[l].d){
				swap(l,parent(l));
				l = parent(l);
			}
			
		}
	}
	
	private class Edgelist{
		LinkedList<Node> list = new LinkedList<Node>();
	}
	

	private class Node{
		int key;
		int d;
		boolean visited = false;
		Node(int k, int d){
			this.key = k;
			this.d = d;
			
		}
	}
	
	private class Graph{
		
		Edgelist[] adj;
		Node[] nodes;
		int[][] weight;
		int n;
		
		Graph(int n){
			this.n = n;
			adj =  new Edgelist[n];
			nodes = new Node[n];
			weight = new int[n][n];
			for(int i=0;i<n;i++){
				adj[i] = new Edgelist(); 
				nodes[i] = new Node(i,Integer.MAX_VALUE);
			}
		}

		public void add(int a, int b,int w) {
			
			if(weight[a][b]!=0&&w<weight[a][b]){
				weight[a][b] = w;
				weight[b][a] = w;
			}else if(weight[a][b]==0){
				weight[a][b] = w;
				weight[b][a] = w;
			}
			
			if(adj[a].list.contains(nodes[b])){
				return;
			}
			
			adj[a].list.add(nodes[b]);
			adj[b].list.add(nodes[a]);
		}
		
	}
	
	
	dijkstra(){
		
		
		
		Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for(int z=0;z<t;z++){
            int n = sc.nextInt();
            int m = sc.nextInt();
            
            Graph g = new Graph(n);
            for(int i=0;i<m;i++){
            	int a = sc.nextInt()-1;
                int b = sc.nextInt()-1;
                int r = sc.nextInt();
                g.add(a,b,r);
            }
            int s = sc.nextInt()-1; //start
            g.nodes[s].d = 0;
            
            
            //dijkstra
            
            pq q = new pq(n);
            for(int i=0;i<n;i++){
            	q.insert(g.nodes[i]);
            }
            while(q.heapsize!=0){
            	Node min = q.extractMin();
            
            	Iterator<Node> l = g.adj[min.key].list.iterator();
            	while(l.hasNext()){
            		Node b = l.next();
            		//relax
            		if(b.d>min.d+g.weight[b.key][min.key]){
            			q.decreaseKey(b.key,min.d+g.weight[b.key][min.key]);
            			//b.d = min.d + g.weight[b.key][min.key];
            			
            		}
            	}
            }
            
            for(int i=0;i<n;i++){
            	if(i==s)continue;
            	int v = g.nodes[i].d;
            	v = (v==Integer.MAX_VALUE||v<0)? -1 : v;
            	System.out.print(v+" ");
            }
            System.out.println("");
            
            
            
        }
		
		
	}
	
	public static void main(String[] args) {
		//damn multiple edges!!
		dijkstra g = new dijkstra();
		
	}

}
