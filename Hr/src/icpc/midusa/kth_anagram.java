package icpc.midusa;

import java.util.Arrays;
import java.util.Scanner;

public class kth_anagram {

	static long[] factorial = new long[16];
	
	public static String find(String s, long k){
		int len = s.length();
		if(k<=1){
			return s;
		}
		p(s+":"+k);
		long val = 1;
		long cpy = 1;
		int i = 0;
		while(k>=val){
			cpy = val;
			val = i*factorial[len-2]+1;
			i++;
			p(val+":"+i);
		}
		i--;
		p(cpy+":"+i);
		p(s.charAt(i-1)+s.substring(0, i-1)+s.substring(i)+":"+(k-cpy+1));
		
		return ""+s.charAt(i-1)+ find(s.substring(0, i-1)+s.substring(i),k-cpy+1);
	}
	
	public static void p(String s){
		System.out.println(s);
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		
		factorial[0] = 1;
		for(int i=1;i<16;i++){
			factorial[i] = (i+1)*factorial[i-1];
			
		}
	
		
		String s = sc.nextLine();
		String[] in = s.split(" ");
		long k = Long.parseLong(in[1]);
		char[] arr = in[0].toCharArray();
		Arrays.sort(arr);
		String l= "";
		for(int i=0;i<in[0].length();i++){
			l += arr[i];
		}
		p(l);
		p(find(l,k));
		
		

	}

}
