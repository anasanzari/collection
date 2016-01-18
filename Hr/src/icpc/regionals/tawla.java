package icpc.regionals;

import java.util.Scanner;

public class tawla {

	
	public static void p(int i,String s){
		System.out.println("Case "+i+": "+s);
	}
	
	public static String w(int i){
		String x = "";
		switch(i){
		case 1:x="Yakk";break;
		case 2:x="Doh";break;
		case 3:x="Seh";break;
		case 4:x="Ghar";break;
		case 5:x="Bang";break;
		case 6:x="Sheesh";break;
		}
		return x;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i=0;i<n;i++){
			int a = sc.nextInt();
			int b = sc.nextInt();
			if(a==b){
				switch(a){
				case 1:p(i,"Habb Yakk");break;
				case 2:p(i,"Dobara");break;
				case 3:p(i,"Dousa");break;
				case 4:p(i,"Dorgy");break;
				case 5:p(i,"Dabash");break;
				case 6:p(i,"Dosh");break;
				}
			}else{
				if(b>a){
					int t = b;
					b = a;
					a = t; 
				}
				if(a==6&&b==5){
					p(i,"Sheesh Beesh");
				}else{
					String m = w(a)+" "+w(b);
					p(i,m);
				}
			}
		}
	}

}
