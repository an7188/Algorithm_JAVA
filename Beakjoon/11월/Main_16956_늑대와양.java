package day1109;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16956_늑대와양 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static char map[][]; // 맵 배열
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {

		st = new StringTokenizer(br.readLine(), " ");

		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		map = new char[R][C];

		for (int i = 0; i < R; i++) {
			String string = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = string.charAt(j);
				// System.out.print(map[i][j]);
			}
			// System.out.println();
		}
		boolean check = false;
		a: for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 'S') {
					for (int kk = 0; kk < 4; kk++) {
						int X = i + di[kk];
						int Y = j + dj[kk];

						if (X >= 0 && X < R && Y >= 0 && Y < C) {
							if (map[X][Y] == 'W') {
								check = true;
								break a;
							} else if (map[X][Y] == '.') {
								map[X][Y] = 'D';
							}
						}
					}
				}
			}
		}
		if (check) {
			System.out.println("0");
		} else {
			System.out.println("1");
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}

	}

}
