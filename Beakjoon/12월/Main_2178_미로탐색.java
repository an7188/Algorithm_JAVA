import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2178_미로탐색 {

	static int N, M;
	static int map[][];
	static int di[] = { 0, 0, -1, 1 }; // 좌 우 상 하
	static int dj[] = { -1, 1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken()); // 행
		M = Integer.parseInt(st.nextToken()); // 열

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			String string = br.readLine();
			for (int j = 0; j < M; j++) {

				map[i][j] = string.charAt(j) - '0';
			}
		} // 입력

		bfs(0, 0);

		System.out.println(map[N - 1][M - 1]);
	}

	private static void bfs(int n, int m) {

		Queue<Point> qu = new LinkedList<>();
		qu.add(new Point(n, m));
		boolean check[][] = new boolean[N][M];
		while (!qu.isEmpty()) {

			Point p = qu.poll();

			int x = p.X;
			int y = p.Y;

			check[x][y] = true;

			for (int i = 0; i < 4; i++) {
				int X = x + di[i];
				int Y = y + dj[i];

				if (X >= 0 && Y >= 0 && X < N && Y < M) {
					if (map[X][Y] == 1 && check[X][Y] == false) {
						map[X][Y] = map[x][y] + 1;
						qu.add(new Point(X, Y));
					}
				}
			}

		}

	}

	static class Point {
		int X, Y;

		public Point(int x, int y) {
			super();
			X = x;
			Y = y;
		}

	}
}
