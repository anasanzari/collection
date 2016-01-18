package icpc.midusa;

import java.util.Scanner;

public class More_multiplication {
	
	public static boolean started = false;
	public static int sofar = 0;

	public static void p(String s){
		System.out.print(s);
	}
	public static void pl(){
		System.out.println("");
	}
	
	public static void maindivider(String a){
		p("+--");
		for(int i=0;i<a.length();i++){
			p("----");
		}
		p("-+");
		pl();
	}
	public static void divider(String a){
		p("| +");
		for(int i=0;i<a.length();i++){
			p("---+");
		}
		p(" |");
		pl();
	}
	public static void mulp(String a){
		p("|   ");
		for(int i=0;i<a.length();i++){
			p(a.charAt(i)+"   ");
		}
		p("|");
		pl();
	}
	
	public static void section(String a, String b, int posb, String pr){
		char[][] p = new char[a.length()][2];
		int bval = Integer.parseInt(""+b.charAt(posb));
		
		for(int i=0;i<a.length();i++){
			String pro = ""+Integer.parseInt(""+a.charAt(i))*bval;
			p[i][0] = ((pro.length()==1)? '0' : pro.charAt(0));
			p[i][1] = ((pro.length()==1)? pro.charAt(0) : pro.charAt(1));
			
		}
		if(started){
			p("|/");
		}else{
			p("| ");
		}
		
		for(int i=0;i<a.length();i++){
			p("|"+p[i][0]+" /");
		}
		p("| |");
		pl();
		p("| ");
		for(int i=0;i<a.length();i++){
			p("| / ");
		}
		p("|"+b.charAt(posb)+"|");
		pl();
		
		if((pr.length()-(a.length()+b.length()))+posb>=0){
			p("|"+pr.charAt(sofar++));
			//sofar++;
			started = true;
		}else{
			p("| ");
		}
		for(int i=0;i<a.length();i++){
			p("|/ "+p[i][1]);
		}
		p("| |");
		pl();
		
		
		
	}
	
	public static void bottom(String a, String b, String pr){
		p("|");
		
		if(sofar==0){
			p("  "+pr.charAt(sofar)+" ");
		}else{
			p("/ "+pr.charAt(sofar)+" ");
		}
		
		for(int i=1;i<a.length();i++){
			p("/ "+pr.charAt(sofar+i)+" ");
		}
		p("   |");
		pl();
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		do{
			int x = sc.nextInt();
			int y = sc.nextInt();
			int product = x*y;
			String p = ""+product;
			if(x==0&&y==0) return;
			
			String a = ""+x;
			String b = ""+y;
			//int width = 6 + a.length()*4-1;
			
			
			maindivider(a);
			mulp(a);
			for(int i=0;i<b.length();i++){
				divider(a);
				section(a,b,i,p);	
			}
			
			divider(a);
			bottom(a, b, p);
			maindivider(a);
			
			sofar = 0;
			started= false;
			
			
			
		}while(true);

	}

}
