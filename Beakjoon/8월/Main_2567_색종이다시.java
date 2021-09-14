package day0827;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class Main_2567_색종이다시 {
	static int map[][];
	static int[] dr = { -1, 1, 0, 0 }; // 행
	static int[] dc = { 0, 0, -1, 1 }; // 열

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		map = new int[100][100];

		int N = sc.nextInt();

		for (int i = 0; i < N; i++) {
			int R = sc.nextInt();
			int C = sc.nextInt();

			for (int j = R; j <= R + 9; j++) {
				for (int j2 = C; j2 <= C + 9; j2++) {
					if (map[j][j2] != 1)
						map[j][j2] = 1;
				}
			}

		}

//	      for (int i = 0; i < 100; i++) {
//	         System.out.println(Arrays.toString(map[i]));
//	      }

		int temp = 0;

		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {

				for (int d = 0; d < 4; d++) {

					int ni = i + dr[d];
					int nj = j + dc[d];

					if (map[i][j] == 1) { // 현재 탐색하는 위치가 직사각형부분이다.

						if (ni >= 0 && nj >= 0 && ni < 100 && nj < 100 && map[ni][nj] == 0) { // 4방향을 확인했을 때
							temp++;
						} else if (ni < 0 || ni >= 100 || nj < 0 || nj >= 100)
							temp++;
					}
				}

			}

		}

		System.out.println(temp);

	}

}