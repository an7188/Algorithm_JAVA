package day0819;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3109_빵집 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static char[][] map;
	static int R, C;
	static int[] di = { -1, 0, 1 };
	static int[] dj = { 1, 1, 1 };
	static int cnt = 0;
	static String Q;

	public static void main(String[] args) throws IOException {

		st = new StringTokenizer(br.readLine(), " ");

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];

		for (int i = 0; i < R; i++) {
			Q = br.readLine();
			map[i] = Q.toCharArray();

		}
		for (int i = 0; i < R; i++) {
			find(i, 0);
		}
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		System.out.println(cnt);
	}

	private static void find(int x, int y) {
		if (y == C - 1) {

			cnt++;

			return;
		}
		int check =cnt;
		for (int i = 0; i < 3; i++) {
			int X = 0;
			int Y = 0;
			X = x + di[i]; // { -1, 0, 1 };
			Y = y + dj[i]; // { 1, 1, 1 }; 
			if (X >= 0 && Y >= 0 && X < R && Y < C && map[X][Y] != 'x' && map[X][Y] != '-') {
				map[X][Y] = '-';

				find(X, Y);
				if (check!=cnt) break;
				
			}
			continue;

		}

	}

}
