package day1214;

import java.util.Scanner;

public class Main_10872_팩토리얼 {

	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		
		int N= sc.nextInt();
		
		System.out.println(pe(N));
		
		
	}

	private static int pe(int n) {
		
		if(n<=1) {
			return 1;
		}
		
		return n*pe(n-1);
		
		
		
		
		
	}

}
