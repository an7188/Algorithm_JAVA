package day03;

import java.util.Scanner;

public class Main_2748_피보나치수2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		long dp[] = new long[N + 1];
		if (N == 0) {
			System.out.println(0);
		} else {

			dp[0] = 1;
			dp[1] = 1;

			for (int i = 2; i < dp.length; i++) {
				dp[i] = dp[i - 1] + dp[i - 2];
			}

			System.out.println(dp[N - 1]);
		}

	}

}
