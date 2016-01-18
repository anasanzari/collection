package graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class bfs_1 {

	private class Node{
		int key;
		int d;
		boolean visited = false;
		Node(int k, int d){
			this.key = k;
			this.d = d;
			
		}
	}
	private class Edgelist{
		LinkedList<Node> list = new LinkedList<Node>();
	}
	private class Graph{
		
		Edgelist[] adj;
		Node[] nodes;
		int n;
		
		Graph(int n){
			this.n = n;
			adj = new Edgelist[n];
			nodes = new Node[n];
			for(int i=0;i<n;i++){
				adj[i] = new Edgelist(); 
				nodes[i] = new Node(i,-1);
			}
		}

		public void add(int a, int b) {
			
			if(adj[a].list.contains(nodes[b])){
				return;
			}
			
			adj[a].list.add(nodes[b]);
			adj[b].list.add(nodes[a]);
			
		}
		
	}
	
	
	bfs_1(){
		Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int z=0;z<t;z++){
            int n = sc.nextInt();
            int m = sc.nextInt();
            
            Graph g = new Graph(n);
            for(int i=0;i<m;i++){
            	int a = sc.nextInt()-1;
                int b = sc.nextInt()-1;
                g.add(a,b);
            }
            int s = sc.nextInt()-1; //start
            g.nodes[s].d = 0;
            
            //g.nodes[s].visited = true;
            LinkedList<Node> queue = new LinkedList<Node>();
            queue.addLast(g.nodes[s]);
            int p = 0;
            while(!queue.isEmpty()){
            	
            	Node u = queue.pollFirst();
            	
            	Iterator<Node> l = g.adj[u.key].list.listIterator();
            	while(l.hasNext()){
            		Node v = l.next();
            		
            		if(!v.visited){
            			v.visited = true;
            			v.d = u.d + 1;
            			queue.addLast(v);
            		}
            		u.visited = true;
            	}
            	
            	
            }
            for(int i=0;i<n;i++){
            	if(i==s)continue;
            	int v = g.nodes[i].d;
            	v = (v>=0)? v*6 : v;
            	System.out.print(v+" ");
            }
            System.out.println("");
            
            
            
        }
		
		
	}
	
	public static void main(String[] args) {
		//damn multiple edges!!
		bfs_1 g = new bfs_1();
		
	}

}
