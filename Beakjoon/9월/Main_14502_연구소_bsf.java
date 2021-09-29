package day0929;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * 풀이 : 땅(0) 을 리스트에 담아 리스트중 3개를 골라 뽑는 조합 메소드를 만든후 bfs로 돌려
 *       안전지역을찾아
 * */

public class Main_14502_연구소_bsf {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M; // 배열의 가로 세로 변수
	static int[][] map; // 지도 배열
	static List<int[]> list = new ArrayList<>(); // 벽을 세울 공간 좌표 리스트

	static int di[] = { -1, 0, 1, 0 }; // 상 좌 하 우
	static int dj[] = { 0, 1, 0, -1 };
	static int max = 0; // 안전지역 수
	static int Now = 0; // 현재안전 지역 수

	public static void main(String[] args) throws IOException {

		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				if (map[i][j] == 0) {
					int arr[] = { i, j };
					list.add(arr);
				}

			}
		} // 입력 끝

		com(0, 0);

		System.out.println(max);

	}

	static List<int[]> list2 = new ArrayList<>();

	private static void com(int idx, int cnt) { // map배열에 0값에벽을 세우는 조합
		if (cnt == 3) {


			bfs();
			return;

		}
		for (int i = idx; i < list.size(); i++) {

			list2.add(list.get(i)); // 천체 좌표중 3개의 좌표를 뽑아서 리스트에 저장

			com(i + 1, cnt + 1);

			list2.remove(cnt);

		}

	}

	static boolean check[][]; // 방문체크
	static boolean[][] virus; // 바이러스

	static void bfs() {
		Queue<Point> qu = new LinkedList<>(); // 바이러스 좌표 저장 큐

		virus = new boolean[N][M];
		check = new boolean[N][M];
		Now = 0;
		map[list2.get(0)[0]][list2.get(0)[1]] = 1;
		map[list2.get(1)[0]][list2.get(1)[1]] = 1;
		map[list2.get(2)[0]][list2.get(2)[1]] = 1;


		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j]==2) qu.add(new Point(i,j));
			}
		}
		while (!qu.isEmpty()) {

			Point now = qu.poll();
			virus[now.i][now.j] = true;
			check[now.i][now.j] = true;
			for (int d = 0; d < 4; d++) {
				int X = now.i + di[d];
				int Y = now.j + dj[d];

				if (X >= 0 && X < N && Y >= 0 && Y < M && map[X][Y] == 0 && !check[X][Y]) {
					virus[X][Y] = true;
					qu.offer(new Point(X, Y));

				}
			}

		}


		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0 && !virus[i][j])
					Now++;

			}
		}
//
		if (max < Now) {
			max = Now;
		}
		map[list2.get(0)[0]][list2.get(0)[1]] = 0;
		map[list2.get(1)[0]][list2.get(1)[1]] = 0;
		map[list2.get(2)[0]][list2.get(2)[1]] = 0;

	}

	static class Point {

		int i, j;

		public Point(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}
	}

}