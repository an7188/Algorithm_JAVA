package day0817;

import java.util.Arrays;
import java.util.Scanner;

public class Main_1493 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] map = new int[20][200];

		int cnt = 1;
		for (int i = 1; i < 200; i++) {
			for (int j = 1; j <= i; j++) {
				map[j][i - j + 1] = cnt++;
			}

		}

		int T = sc.nextInt();
		for (int tc = 1; tc < T; tc++) {
			int p = sc.nextInt();
			int q = sc.nextInt();

			int a = 0, b = 0, c = 0, d = 0;
			for (int i = 1; i < 200; i++) {
				for (int j = 1; j <= 200; j++) {
					if (map[i][j] == p) {
						a = i;
						b = j;

					} if (map[i][j] == q) {
						c = i;
						d = j;
					}

				}
			}

			System.out.println((a +c)+ " " + (b + d) );
		}

	}

}
