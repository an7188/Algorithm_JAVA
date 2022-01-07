package day0920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_4963_섬의개수 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int w, h; // 지도 너비와 높이
	static int ip; // 땅, 바다 입력 변수
	static int[][] map; // 지도 배열
	static int[] di = { -1, 1, 0, 0, -1, -1, 1, 1 }; // 위 ,아래 ,왼 ,우, 좌상 ,우상, 좌하 ,좌우
	static int[] dj = { 0, 0, -1, 1, -1, 1, -1, 1 };

	public static void main(String[] args) throws IOException {

		while (true) {
			st = new StringTokenizer(br.readLine(), " ");
			w = Integer.parseInt(st.nextToken()); // 열
			h = Integer.parseInt(st.nextToken()); // 행

			if (w == 0 && h == 0)
				break;
			map = new int[h][w];
			int cnt = 0; // 섬의 개수 저장 변수

			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {

					if (map[i][j] == 1) {

						bfs(i, j);
						cnt++;
//						for (int j2 = 0; j2 < h; j2++) {
//							for (int k = 0; k < w; k++) {
//								System.out.print(map[j2][k]);
//							}
//							System.out.println();
//						}

					}
				}

			}
			System.out.println(cnt);

		}

	}

	// 섬을 찾는 메소드
	static void bfs(int i, int j) {
		Queue<Point> qu = new LinkedList<>();
		boolean check[][] = new boolean[h][w];
		qu.add(new Point(i, j));

		while (!qu.isEmpty()) {
			Point p = qu.poll();
			map[p.x][p.y] = 0;
			int x = p.x;
			int y = p.y;

			for (int k = 0; k < 8; k++) {
				int X = x + di[k];
				int Y = y + dj[k];

				if (X >= 0 && X < h && Y >= 0 && Y < w && map[X][Y] == 1) { // 좌표가 이동했을때 범위 안에 있고 땅인 경우
					if (!check[X][Y]) {

						qu.add(new Point(X, Y));
						check[X][Y] = true;
					}
				}

			}

		}

	}

	// 섬의 좌표 저장 클래스
	static class Point {
		int x, y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

}
