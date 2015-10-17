package godaddy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

class obj{
	int x;
	int y;
	int w;
	LinkedList<Integer> list = new LinkedList<Integer>();
	boolean visited = false;
	obj(int x,int y,int w){
		this.x =x;
		this.y =y;
		this.w =w;
	}
}

public class q3 {


	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		obj[] graph = new obj[n];
		for(int i=0;i<n;i++){
			int x = sc.nextInt();
			int y = sc.nextInt();
			int w = sc.nextInt();
			graph[i] = new obj(x, y, w);
			
		}
		Arrays.sort(graph,new Comparator<obj>(){
		      public int compare(obj b1, obj b2) {
		    	  if(b1.x==b2.x){
		    		  return b1.y-b2.y;
		    	  }
		    	return b1.x-b2.x;
		    }
		});
		for(int i=n-1;i>=0;i--){
			for(int j=i-1;j>=0;j--){
				if(graph[j].y<=graph[i].y){
					graph[i].list.add(j);
				}
			}
		}
		
		dfs(graph,n);
		int max = Integer.MIN_VALUE;
		for(int i=0;i<n;i++){
			if(graph[i].w>max){
				max = graph[i].w;
			}
		}
		System.out.println(max);
		
	}

	private static void dfs(obj[] graph,int n) {
		for(int i=0;i<n;i++){
			if(graph[i].visited){
				continue;
			}else{
				calc(graph,i);
			}
		}
		
	}

	private static int calc(obj[] graph, int i) {
		int max = 0;
		if(graph[i].visited){
			return graph[i].w;
		}
		ListIterator<Integer> iter = graph[i].list.listIterator();
		while(iter.hasNext()){
			int l = iter.next();
			int val = calc(graph,l);
			
			if(val>max){
				max = val;
			}
		}
		graph[i].w += max;
		graph[i].visited = true;
		return graph[i].w;
	}

}
