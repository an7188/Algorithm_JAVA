import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16918_봄버맨 {

	static BufferedReader br;
	static StringTokenizer st;
	static int R, C, T;
	static char map[][];
	static boolean bomb[][];
	static int di[][] = { { -1, 1, 0, 0 }, { 0, 0, -1, 1 } };
	static Queue<Point> qu = new LinkedList<>();

	public static void main(String[] args) throws IOException {

		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");

		R = Integer.parseInt(st.nextToken()); // 행
		C = Integer.parseInt(st.nextToken()); // 열
		T = Integer.parseInt(st.nextToken()); // 시간

		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			String string = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = string.charAt(j);

			}

		} // 입력 끝

		// 처음 1초는 그냥 가만히 있기 때문에 1초는 패스!
		for (int t = 2; t <= T; t++) {

			if (t % 2 ==0) {// 1초 후 폭탄 채우기
				fill();
				

			} else if (t % 2 == 1) { // 폭탄을 채운 후 라면 1초 후 폭탄 터트리기

				explosion();
				resetarr();
				
			}

		}
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}

	}

	// bomb배열 리셋 해주기
	private static void resetarr() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				bomb[i][j]=false;
			}
		}

	}

	// 폭탄을 터트리는 메소드
	private static void explosion() {

		while (!qu.isEmpty()) {
			Point p = qu.poll();

			int x = p.x;
			int y = p.y;

			// 메인 폭탄 먼저 터트리기
			map[x][y] = '.';

			for (int i = 0; i < 4; i++) {
				int X = x + di[0][i];
				int Y = y + di[1][i];

				if (X >= 0 && X < R && Y >= 0 && Y < C) {
					if (bomb[X][Y] == true) {
						map[X][Y] = '.';
					}
				}
			}
		}

	}

	// 폭탄 채우는 메소드 (새로 생긴 폭탄이라면 bomb배열에 true로 설정)
	private static void fill() {
		bomb = new boolean[R][C];

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == '.') {
					map[i][j] = 'O';
					bomb[i][j] = true;

				} else if (map[i][j] == 'O') {
					qu.add(new Point(i, j));
				}
			}
		}

	}

	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

}
