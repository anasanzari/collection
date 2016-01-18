package implementation;

import java.util.Scanner;

public class palindrome_index {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tests =sc.nextInt();
		sc.nextLine();
		for(int t=0;t<tests;t++){
			String s = sc.nextLine();
			int index = -1;
			for(int i=0;i<s.length()/2;i++){
				if(s.charAt(i)!=s.charAt(s.length()-i-1)){
					System.out.println(""+s.charAt(i)+":"+s.charAt(s.length()-i-1));
					if(s.charAt(i)==s.charAt(s.length()-i-2)){
						index = s.length()-i-1;
					}else if(s.charAt(i+1)==s.charAt(s.length()-i-1)){
						index = i;
					}
					break;
				}
			}
			System.out.println(""+index);
		}
		
	}

}
