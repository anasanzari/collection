package implementation;

import java.util.HashSet;
import java.util.Scanner;

public class Manasa_and_stones {

	public static void main(String[] args) {
        
		Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            int n = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            if(a>b){
            	int temp = b;
            	b = a;
            	a = temp;
            }
            //v = a*x + b*y ; x+y = n-1
            int x = n-1;
            int y = 0;
            HashSet<Integer> set = new HashSet<Integer>();
            while(x>=0){
                int v = a*x +b*y;
                if(!set.contains(v)){
                	System.out.print(v+" ");
                	set.add(v);
                }
               
                x--;
                y++;
            }
           
            System.out.println("");
        }
    }

}
