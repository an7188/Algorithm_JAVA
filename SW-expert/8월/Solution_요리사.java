package day0818;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_요리사 {
	static Scanner sc = new Scanner(System.in);
	static int TC;
	static int N;
	static int[][] arr;
	static int[] box, box2;
	static int A, B;
	static boolean isSelected[];
	static int Min;

	public static void main(String[] args) {

		TC = sc.nextInt();

		for (int tc = 1; tc <= TC; tc++) {
			Min = Integer.MAX_VALUE;
			N = sc.nextInt();
			box = new int[N / 2];
			box2 = new int[N / 2];

			arr = new int[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}

			find(0, 0);
			System.out.println("#" + tc + " " + Min);

		}
	}

	private static void find(int cnt, int idx) {
		if (cnt == N / 2) {
			// System.out.println(Arrays.toString(box));
			isSelected = new boolean[N];
			int num = 0;

			for (int i = 0; i < N / 2; i++) {
				isSelected[box[i]] = true;

			}

			for (int i = 0; i < N; i++) {
				if (isSelected[i])
					continue;
				box2[num] = i;
				num++;
			}
//			System.out.println(Arrays.toString(box));
//			System.out.println(Arrays.toString(box2));
			A = 0;
			B = 0;
			for (int i = 0; i < N / 2; i++) {
				for (int j = 0; j < N / 2; j++) {
					A += arr[box[i]][box[j]];
					B += arr[box2[i]][box2[j]];
				}
			}

			// System.out.printf("%d %d", A,B);
			if (Min > Math.abs(A - B)) {

				Min = Math.abs(A - B);
			}

			return;
		}

		for (int i = idx; i < N; i++) {
			box[cnt] = i;

			find(cnt + 1, i + 1);

		}
	}

}
