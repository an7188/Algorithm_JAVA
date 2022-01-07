package day1209;

import java.util.Scanner;

public class Main_2747_피보나치수_재귀 {
	static int n;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();

		System.out.println(fibo(n));
		

	}

	private static int fibo(int num) {
		if (num <=1)
			return num;
		
		
		return fibo(num-2)+fibo(num-1);
		
		
		
	
	}
}
