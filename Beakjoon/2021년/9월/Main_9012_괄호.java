package day0925;

import java.util.Scanner;
import java.util.Stack;

public class Main_9012_괄호 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		Stack<Character> st= new Stack<>();
		
		int tc= sc.nextInt();
		for (int t = 0; t < tc; t++) {
			
			String p= sc.next();
			int sum=0;
			
			for (int i = 0; i < p.length(); i++) {
				if (p.charAt(i)=='(') {
					sum+=1;
				}else {
					if (sum==0) {
						sum=2;
						break;
					}
					sum-=1;
				}
			}
			if (sum==0) System.out.println("YES");
			else System.out.println("NO");
			
		}
		
	}

}
