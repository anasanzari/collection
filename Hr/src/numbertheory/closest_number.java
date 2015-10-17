package numbertheory;

import java.util.Scanner;

public class closest_number {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tests = sc.nextInt();
	   
		for(int t=0;t<tests;t++){
			int a = sc.nextInt();
			int b = sc.nextInt();
			int x = sc.nextInt();
			if(b<0&&a!=1){
				System.out.println("0");
				continue;
			}
			long pow = (long) Math.pow(a,b);
			long rem = pow%x;
			if(rem>(x/2)){
				System.out.println(pow+x-rem);
			}else{
				System.out.println(pow-rem);
			}
		}
	}

}
