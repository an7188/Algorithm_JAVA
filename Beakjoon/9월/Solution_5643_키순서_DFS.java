package day0929;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_5643_키순서_DFS {
	/*
	 * 정점 : 학생 , 간선 :학생간의 키 비교 결과 완전그래프 => 하나의 정점에서 다른 모든 정점과 연결되어 있는 그래 그래프 한점 출발
	 * 인접한 정점 계속 따라서 탐색 => 그래프의 연결성 확인
	 * 
	 */

	static int N, M, adj[][];
	static int gtCnt, ltCnt;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine()); // 테케 입력

		for (int tc = 1; tc <= T; tc++) {

			N = Integer.parseInt(br.readLine()); // 학생 수
			M = Integer.parseInt(br.readLine()); // 간선정보 수
			adj = new int[N + 1][N + 1];

			StringTokenizer st = null;

			for (int m = 0; m < M; m++) {
				st = new StringTokenizer(br.readLine(), " ");
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				adj[from][to] = 1;
			}

			int ans = 0;
			for (int i = 1; i <= N; i++) {
				gtCnt = ltCnt = 0;
				gtDFS(i, new boolean[N + 1]);
				ltDFS(i, new boolean[N + 1]);
				if (gtCnt + ltCnt == N - 1)
					++ans;

			}
			System.out.println("#" + tc + " " + ans);

		}

	}

	// 자신 보다 큰 학생따라 탐색
	static void gtDFS(int cur, boolean[] visited) {
		visited[cur] = true;
		for (int i = 1; i <= N; i++) {
			if (!visited[i] && adj[cur][i] == 1) {
				++gtCnt;
				gtDFS(i, visited);
			}

		}
	}

	// 자신 보다 작 학생따라 탐색
	static void ltDFS(int cur, boolean[] visited) {
		visited[cur] = true;
		for (int i = 1; i <= N; i++) {
			if (!visited[i] && adj[cur][i] == 1) {
				++ltCnt;
				ltDFS(i, visited);
			}

		}
	}
}
