package day0916;

import java.util.Scanner;

class Solution_3307_최장증가부분수열 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			int N = sc.nextInt(); // 수열의 길이
			int[] arr = new int[N];
			int[] LIS = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();

			}

			int max = 0;
			for (int i = 0; i < N; i++) {
				LIS[i] = 1;

				for (int j = 0; j < i; j++) {
					if (arr[j] < arr[i] && LIS[i] < LIS[j] + 1) {
						LIS[i] = LIS[i] + 1;
					}
				}
				if (max < LIS[i])
					max = LIS[i];
			}
			System.out.println("#"+tc+" "+max);

		}

	}

}
