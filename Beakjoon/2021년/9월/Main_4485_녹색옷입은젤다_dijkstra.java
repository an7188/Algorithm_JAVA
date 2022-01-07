package day0929;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_4485_녹색옷입은젤다_dijkstra {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N; // 맵의 크기N
	static int[][] map;
	static int[][] ds;
	static int di[] = { 0, 1, 0, -1 }; // 우, 하 , 좌, 상
	static int dj[] = { 1, 0, -1, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		int cnt = 1;
		while (true) {
			N = Integer.parseInt(br.readLine());
			if (N == 0)
				break;
			map = new int[N][N];
			ds = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					ds[i][j] = Integer.MAX_VALUE;
				}
			} // 입력 끝

			bfs();

			System.out.println("Problem " + cnt + ": " + ds[N - 1][N - 1]);
			cnt++;

		}

	}

	static void bfs() {
		Queue<Point> qu = new LinkedList<>();
		qu.add(new Point(0, 0));
		ds[0][0] = map[0][0];

		while (!qu.isEmpty()) {

			Point p = qu.poll();
			int x = p.x;
			int y = p.y;
			for (int i = 0; i < 4; i++) {// 우하좌상
				int X = x + di[i];
				int Y = y + dj[i];

				if (X >= 0 && X < N && Y >= 0 && Y < N) { // 좌표가 이동했을때 범위 안에 있고 땅인 경우
					if (ds[X][Y] > map[X][Y] + ds[x][y]) {
						ds[X][Y] = map[X][Y] + ds[x][y];
						qu.add(new Point(X, Y));
					}
					

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
