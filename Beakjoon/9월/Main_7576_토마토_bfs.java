package day0924;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7576_토마토_bfs {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int M, N; // 상자의 크기를 나타내는 가로 세로
	static int zero, day;
	static int box[][];
	static boolean check[][];
	static int[] di = { -1, 0, 1, 0 }; // 상 우 하 좌
	static int[] dj = {  0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {

		st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		box = new int[N][M];
		check = new boolean[N][M];
		int zero2=0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
				if (box[i][j] == 0)
					zero++;

			}
		} // 입력 끝
		if (zero == 0) {
			System.out.println("0");
		} else {
			
			bfs();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(box[i][j]==0) zero2++;
						
				}
			}if(zero2>0) System.out.println("-1");
			else System.out.println(day-1);
		}

	}

	static void bfs() {
		Queue<Point> qu = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (box[i][j] == 1) {

					qu.add(new Point(i, j));
				}
			}

		}
		while (!qu.isEmpty()) {
			int qs = qu.size();
			for (int i = qs; i > 0; i--) {

				Point p = qu.poll();

				box[p.x][p.y] = 1;
				for (int j = 0; j < 4; j++) {
					int X = p.x + di[j];
					int Y = p.y + dj[j];
					if (X >= 0 && X < N && Y >= 0 && Y < M && box[X][Y] == 0) {
						if (!check[X][Y]) {
							check[X][Y] = true;
							qu.offer(new Point(X, Y));
						}

					}

				}
			}
			
			day++;

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
