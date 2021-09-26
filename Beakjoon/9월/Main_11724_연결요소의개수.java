package day0925;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_11724_연결요소의개수 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M, u, v; // 정점의 개수 , 간선의 개수
	static int[][] map;
	static boolean check[];

	public static void main(String[] args) throws IOException {

		st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken()); // 정점의 개수
		M = Integer.parseInt(st.nextToken()); // 간선의 개수
		map = new int[N][N];
		check = new boolean[N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());

			map[u - 1][v - 1] = 1;
			map[v - 1][u - 1] = 1;// 양방향이니까똑같이

		}

		int cnt = 0;
		for (int i = 0; i < N; i++) {
			int sum=0;
			for (int j = 0; j < N; j++) {
				sum+=map[i][j];
			}
			if (sum==0) cnt++;
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1) {
					bfs(i, j);

					cnt++;
				}
			}
		}

		System.out.println(cnt);

	}

	static Queue<Integer> qu = new LinkedList<>();

	private static void bfs(int k, int l) {
		map[k][l] = 0;
		map[l][k] = 0;
		qu.add(k);
		qu.add(l);

		while (!qu.isEmpty()) {

			int a = qu.poll();
			for (int i = 0; i < N; i++) {
				if (map[a][i] == 1 && !check[a]) {
					map[a][i] = 0;
					map[i][a] = 0;
					qu.add(i);

				}
			}
			check[a] = true;

		}

	}

}
