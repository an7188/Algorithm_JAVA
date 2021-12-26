import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7569_토마토 {

	static int di[] = { 0, 0, -1, 1, 0, 0 }; // 좌 우 상 하 앞 뒤
	static int dj[] = { -1, 1, 0, 0, 0, 0 }; // 좌 우 위 아래 앞 뒤
	static int db[] = { 0, 0, 0, 0, 1, -1 };

	static int arr[][][];
	static int H, M, N;
	static boolean check[][][];

	static Queue<point> qu = new LinkedList<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 열
		M = Integer.parseInt(st.nextToken()); // 행
		H = Integer.parseInt(st.nextToken()); // 높이

		arr = new int[H][M][N];
		check = new boolean[H][M][N];

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < M; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int k = 0; k < N; k++) {
					arr[i][j][k] = Integer.parseInt(st.nextToken());
					if (arr[i][j][k] == 1) {
						qu.add(new point(i, j, k));
					}

				}
			}
		}

		bfs();

		int day = Integer.MIN_VALUE;
		w: for (int i = 0; i < H; i++) {
			for (int j = 0; j < M; j++) {
				for (int k = 0; k < N; k++) {
					if (arr[i][j][k] == 0) {
						day = -1;
						break w;
					} else {

						day = Math.max(day, arr[i][j][k]);
					}
				}
			}
		}
		if (day == -1) {
			System.out.println(day);
		} else
			System.out.println(day - 1);

	}

	private static void bfs() {

		while (!qu.isEmpty()) {
//			for (int i = 0; i < H; i++) {
//				for (int j = 0; j < M; j++) {
//					System.out.println(Arrays.toString(arr[i][j]));
//				}
//
//			}
// 			System.out.println();
			point p = qu.poll();

			int x = p.x;
			int y = p.y;
			int z = p.z;

			for (int i = 0; i < 6; i++) {
				int PX = x + di[i];
				int PY = y + dj[i];
				int PZ = z + db[i];

				if (PX >= 0 && PY >= 0 && PZ >= 0 && PX < H && PY < M && PZ < N) {
					if (arr[PX][PY][PZ] == 0) {
						qu.add(new point(PX, PY, PZ));

						arr[PX][PY][PZ] = arr[x][y][z] + 1;

					}
				}
			}

		}

	}

	static class point {
		int x; // 행
		int y; // 열
		int z; // 상자

		public point(int x, int y, int z) {
			super();
			this.x = x;
			this.y = y;
			this.z = z;
		}

	}

}
