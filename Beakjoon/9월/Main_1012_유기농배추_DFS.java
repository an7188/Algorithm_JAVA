package day0923;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1012_유기농배추_DFS {
	static BufferedReader br;
	static StringTokenizer st;
	static int[][] map;
	static int M, N, K, cnt; // 가로 ,세로 ,심어진 배추 개수, 배추 구역카운트 변수
	static int[] di = { 0, 1, 0, -1 }; // 상 하 좌 우
	static int[] dj = { 1, 0, -1, 0 };
	static boolean[][] check;

	public static void main(String[] args) throws NumberFormatException, IOException {

		br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine()); // 테케 입력

		for (int tc = 0; tc < T; tc++) {

			st = new StringTokenizer(br.readLine(), " ");
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			map = new int[M][N];
			check = new boolean[M][N];
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1; // 배추 좌표에 1값 넣기

			}
			cnt = 0;

			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 1) {
						dfs(i, j);

					cnt++;
					}
					
				}

			}

			System.out.println(cnt);

		}

	}

	static void dfs(int k, int l) {

		check[k][l] = true;
		map[k][l] = 0;

		for (int i = 0; i < 4; i++) {
			int X = k + di[i];
			int Y = l + dj[i];

			if (X >= 0 && X < M && Y >= 0 && Y < N && map[X][Y] == 1 && !check[X][Y]) {
				dfs(X, Y);
			}
		}

	}

}
