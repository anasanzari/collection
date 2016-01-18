package icpc.midusa;

import java.util.Scanner;

public class ReverseRot {

	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = 0;
		char[] arr = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','_','.'};
		
		n = sc.nextInt();
		while(n!=0){
			String s = sc.nextLine();
			for(int i=s.length()-1;i>=1;i--){
				char c = s.charAt(i);
				int cl;
				if(c=='_'||c=='.'){
					cl = (c=='_')? 26 : 27;
				}else cl = s.charAt(i) - 65;
				
				System.out.print(arr[(cl+n)%28]);
			}
			System.out.println("");
			n=sc.nextInt();
		}
	}

}
