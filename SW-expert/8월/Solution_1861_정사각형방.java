package day0806;

import java.util.Scanner;


public class Solution_1861_정사각형방 {
	static int num, N;
	static int[][] map;
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };
	static int kk;
	static int cnt, max = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int TC = sc.nextInt();

		for (int tc = 1; tc <= TC; tc++) {
			N = sc.nextInt();
			map = new int[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					num = sc.nextInt();
					map[i][j] = num;
					// System.out.print( map[i][j]+" ");
				}

			}
			// 배열안에 숫자 넣음

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					solve(i, j);
					if (max < cnt) {
						max = cnt;
					}
				}
			}
			System.out.println(cnt);
		}
		
	}

	// 위치 움직임
	static void solve(int i, int j) {
		cnt = 1;
		for (int k = 0; k < 4; k++) {
			int xd = i + di[k];
			int yd = j + dj[k];

			if (xd >= 0 && yd >= 0 && xd < N && yd < N && map[xd][yd] - map[i][j] == 1) {
				cnt++;
				solve(xd, yd);
				

			}

		}

	}

}
