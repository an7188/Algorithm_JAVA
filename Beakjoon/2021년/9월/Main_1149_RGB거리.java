package day0914;

import java.util.Scanner;

public class Main_1149_RGB거리 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N= sc.nextInt();
		int dp[][]= new int [N+1][3];
		
		for (int i = 1; i <= N; i++) {
			
			dp[i][0] = sc.nextInt()+Math.min(dp[i-1][1],dp[i-1][2]);
			dp[i][1] = sc.nextInt()+Math.min(dp[i-1][0],dp[i-1][2]);
			dp[i][2] = sc.nextInt()+Math.min(dp[i-1][0],dp[i-1][1]);
			
			
		}
		
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < 3; i++) {
			if (min>dp[N][i]) {
				min=dp[N][i];
			}
			
			
		}
		
		System.out.println(min);
		
		
	}

}
