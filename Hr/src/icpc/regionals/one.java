package icpc.regionals;

import java.util.Iterator;
import java.util.Scanner;

import java.util.ArrayList;

import java.util.HashMap;

import java.util.HashSet;

import java.util.List;

import java.util.Map;

import java.util.Set;

class one {

	private class DisjointSets implements Cloneable

	{

		public Object clone()throws CloneNotSupportedException{  
			return super.clone();  
		}  
		
		private List<Map<Integer, Set<Integer>>> disjointSet;

		public DisjointSets()

		{

			disjointSet = new ArrayList<Map<Integer, Set<Integer>>>();

		}

		public void create_set(int element)

		{

			Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();

			Set<Integer> set = new HashSet<Integer>();

			set.add(element);

			map.put(element, set);

			disjointSet.add(map);

		}

		public void union(int first, int second)

		{

			int first_rep = find_set(first);

			int second_rep = find_set(second);

			Set<Integer> first_set = null;

			Set<Integer> second_set = null;

			for (int index = 0; index < disjointSet.size(); index++)

			{

				Map<Integer, Set<Integer>> map = disjointSet.get(index);

				if (map.containsKey(first_rep))

				{

					first_set = map.get(first_rep);

				} else if (map.containsKey(second_rep))

				{

					second_set = map.get(second_rep);

				}

			}

			if (first_set != null && second_set != null)

				first_set.addAll(second_set);

			for (int index = 0; index < disjointSet.size(); index++)

			{

				Map<Integer, Set<Integer>> map = disjointSet.get(index);

				if (map.containsKey(first_rep))

				{

					map.put(first_rep, first_set);

				} else if (map.containsKey(second_rep))

				{

					map.remove(second_rep);

					disjointSet.remove(index);

				}

			}

			return;

		}

		public int find_set(int element)

		{

			for (int index = 0; index < disjointSet.size(); index++)

			{

				Map<Integer, Set<Integer>> map = disjointSet.get(index);

				Set<Integer> keySet = map.keySet();

				for (Integer key : keySet)

				{

					Set<Integer> set = map.get(key);

					if (set.contains(element))

					{

						return key;

					}

				}

			}

			return -1;

		}
		
		public void print(int k){
			for(int i=0;i<k;i++){
				System.out.print(i+":"+find_set(k)+" :: ");
			}
			System.out.println("");
		}

		public int getNumberofDisjointSets()

		{

			return disjointSet.size();

		}

	}
	DisjointSets sets;
	public one(){
		sets = new DisjointSets();
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int tests = sc.nextInt();
		for (int t = 0; t < tests; t++) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			int[] odds = new int[n];
			int len = 0;
			
			one o = new one();
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
				o.sets.create_set(i);
				if(i!=0&&arr[i]==-1){
					odds[len++] = i;
				}
			}
			
			for(int i=1;i<n;i++){
				if(arr[i]!=-1){
					o.sets.union(i, arr[i]);
				}
			}
			
			for(int i=0;i<n;i++){
				p(i+":p-"+o.sets.find_set(i));
			}
			
			/*for(int i=0;i<len;i++){
				p(""+odds[i]+":"+len);
			}*/
			
			p(""+recur(odds,len-1,o.sets));
			
		}
	}
	
	
	public static double recur(int[] odds, int i,  DisjointSets sets){
		if(i<0) {
			p(""+sets.getNumberofDisjointSets());
			return sets.getNumberofDisjointSets();
		}
		
		int k = odds[i];
		
		Double n1 = 0.5*recur(odds,i-1,sets);
		Double n2 = 0.0;
		for(int j=k-1;j>=0;j--){
			DisjointSets s;
			try {
				s = (DisjointSets) sets.clone();
				p("joining"+k+":"+j);
				s.union(k, j);
				n2 +=   0.5*recur(odds,i-1,s);
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}		
			  //noofteams(i-1,sets.union(k, j)); 
		}
		n2 = n2/k;
		
		
		return n1+n2;
	}
	
	public static void p(String s){
		
		System.out.println(s);
	}

}
