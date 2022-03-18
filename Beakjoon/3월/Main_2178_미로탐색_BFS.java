import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 4 6 101111 101010 101011 111011
 **/

public class Main_2178_미로탐색_BFS {

	static int N, M;
	static int map[][];
	static int ar[][] = { { -1, 1, 0, 0 }, { 0, 0, -1, 1 } };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken()); // 행
		M = Integer.parseInt(st.nextToken());// 열

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			String string = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = string.charAt(j) - '0';
			}

		} // 입력 끝

		bfs(0, 0);

		
			
			System.out.println(map[N-1][M-1]);
		

	}

	private static void bfs(int k, int l) {

		Queue<Point> qu = new LinkedList<>();
		boolean check[][] = new boolean[N][M];
		qu.add(new Point(k, l));

		while (!qu.isEmpty()) {
			Point P = qu.poll();
			int x = P.x;
			int y = P.y;
			
			check[x][y] = true;

			for (int i = 0; i < 4; i++) {
				int X = x + ar[0][i];
				int Y = y + ar[1][i];
				if (X >= 0 && X < N && Y >= 0 && Y < M && !check[X][Y]) {
				
					if (map[X][Y] == 1) {
						map[X][Y] = map[x][y] + 1;

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
