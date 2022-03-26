package day03;

import java.util.Scanner;

public class Main_10870_피보나치수5_memo {

	static int memo [];
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		if(N==0) {
			System.out.println(0);
		}else {
		memo= new int[N+1];
		memo[0]=1;
		memo[1]=1;
		
		fibo(N);
		
		System.out.println(memo[N-1]);
		}
	}

	private static int fibo(int n) {
		if(n>=2 && memo[n]==0) {
			memo[n]=fibo(n-1)+fibo(n-2);
		}
		
		return memo[n];
		
	}

}
