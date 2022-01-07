package day0929;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_5656_벽돌깨기_시뮬_bfs {

	/*
	 * [중복 순열 , 완탐, bfs] 1. 구슬을 0열부터 W-1열까지 시도 2. 구슬이 떨어졌을때 처음 만나는 벽돌 찾기 3. 함께 제거딜
	 * 벽돌을 식별(탐색) 4. 부서진 벽돌 정리( 벽돌 내리기) 5. 다음 구슬 시도
	 */

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int TC, N, W, H, min;

	static int[] di = { -1, 1, 0, 0 }; // 상,하, 좌, 우
	static int[] dj = { 0, 0, -1, 1 }; // 상,하, 좌, 우

	public static void main(String[] args) throws NumberFormatException, IOException {

		TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {
			st = new StringTokenizer(br.readLine(), " ");

			N = Integer.parseInt(st.nextToken()); // 쏠수 있는 횟수
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());

			int[][] map = new int[H][W];

			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			min = Integer.MAX_VALUE;

			go(0, map);
			System.out.println("#" + tc + " " + min);

		} // 테케

	}

	// 중복 순열로 구슬을 던짐
	private static void go(int cnt, int[][] map) {
		if (cnt == N) {// 구슬을 다 던짐
			// 남아있는 벽돌 수 카운트 최소값 갱신
			int result= getRemain(map);
			
			min = Math.min(result, min);
			return;
		}
		int[][] newMap = new int[H][W];
		for (int c = 0; c < W; c++) { // 0열부터 마지막 열까지 시도
			// c열에 구슬이 던져졌을때 위에서 처음 만나는 벽돌을 찾기

			int r = 0;
			while (r < H && map[r][c] == 0) r++;

			if (r == H) { // 구슬을 던졌지만 맞은 벽돌이 없는 경우(행당 열레 모두 빈칸)
				go(cnt + 1, map); // 다음 구슬 던지기

			} else { // 맞은 벽돌이 있는 경우
				// 이전 cnt까지 map 초기 상태를 복사해서 사용
				copy(map, newMap);

				// 맞은 벽돌 및 주벽 벽돌 함께 제거 처리(연쇄적 처리)
				boom(newMap, r, c);

				// 제거된 벽돌들 내리기
				down(newMap);

				// 다음 구슬 던지기
				go(cnt + 1, newMap);
			}

		}

	}

	private static int getRemain(int[][] map) {
		int count =0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				
				if (map[i][j]>0) {
					count++;
				}
			}
			
		}
		return count;
	}

	private static void down(int[][]map) {
		for (int c = 0; c < W; c++) {
			int r = H - 1;

			while (r > 0) {
				if (map[r][c] == 0) {// 빈칸이면 벽돌 내리
					int nr = r - 1; // 자신의 직전 행부터 탐색
					while(nr>0 && map[nr][c]==0) nr--;
					
					map[r][c]= map[nr][c];// 현태 빈칸에는 자신의 위쪽으로 처음 만나는 벽돌로 내리기
					map[nr][c]=0; // 내린 벽돌 자리는 빈칸으로 
					
					
					
				}
				--r;
			}
		}

	}

	private static void boom(int[][]map, int r, int c) {
		Queue<Point> qu = new LinkedList<Point>();
		if (map[r][c] > 1) { // 벽돌의 숫자가 1보다 클때만 주변 벽돌 연쇄 처리
			qu.offer(new Point(r, c, map[r][c]));
		}
		// 0으로 마킹하여 방문 처리
		map[r][c] = 0; // 벽돌을 제거하고 빈칸을 채우기

		Point p = null;

		while (!qu.isEmpty()) {
			p = qu.poll();
			for (int d = 0; d < 4; d++) {
				int nr = p.r;
				int nc = p.c;

				for (int k = 1; k < p.cnt; k++) {
					nr += di[d];
					nc += dj[d];
					if (nr >= 0 && nr < H && nc >= 0 && nc < W && map[nr][nc] != 0) {
						if (map[nr][nc] > 1) { // 벽돌의 숫자가 1보다 클때만 주변 벽돌 연쇄 처리
							qu.offer(new Point(nr, nc, map[nr][nc]));
						}
						map[nr][nc] = 0;
					}
				}
			}

		}

	}

	static void copy(int[][] map, int[][] newMap) {
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				newMap[i][j] = map[i][j];
			}
		}

	}

	static class Point {
		int r, c, cnt; // 행 , 열 , 벽돌숫자

		public Point(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}

	}

}
