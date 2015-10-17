package greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

class order{
	int i;
	int s;
	int d;
	order(int i,int s,int d){
		this.i = i;
		this.s = s;
		this.d = d;
	}
}

public class jim_and_orders {


public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		order[] o = new order[n];
		for(int i=0;i<n;i++){
			int a = sc.nextInt();
			int b = sc.nextInt();
			o[i] = new order(i+1,a,b);
		}
		Arrays.sort(o,new Comparator<order>() {
			public int compare(order a, order b) {
				return (a.s+a.d)-(b.s+b.d);
			}
		});
		for(int i=0;i<n;i++){
			System.out.print(o[i].i+" ");
		}
	}

}
