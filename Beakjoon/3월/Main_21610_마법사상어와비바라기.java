import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_21610_마법사상어와비바라기 {

	static BufferedReader br;
	static StringTokenizer st;
	static int N, M, D, S, sum = 0; // 맵의 크기, 이동 횟수,이동방향, 이동칸수
	static int da[][] = { { 0, -1, -1, -1, 0, 1, 1, 1 }, { -1, -1, 0, 1, 1, 1, 0, -1 } }; // 좌,좌상, 상, 우상, 우,우하, 하, 좌하
	static int ca[][] = { { -1, -1, 1, 1 }, { -1, 1, 1, -1 } };
	static int map[][];
	static Queue<Point> cloud = new LinkedList<>();
	static boolean check[][];

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken()); // 맵의 크기
		M = Integer.parseInt(st.nextToken()); // 이동 횟수

		map = new int[N][N];
		check = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

			}
		}

		cloud.add(new Point(N - 1, 0));
		cloud.add(new Point(N - 1, 1));
		cloud.add(new Point(N - 2, 0));
		cloud.add(new Point(N - 2, 1)); // 초기 4칸의 구름 위치 저장

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			D = Integer.parseInt(st.nextToken());
			S = Integer.parseInt(st.nextToken());

			cloudmove();

//			for (int k = 0; k < N; k++) {
//
//				System.out.println(Arrays.toString(map[k]));
//			}
//			System.out.println();

		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sum = sum += map[i][j];
			}
		}

		System.out.println(sum);

	}

	// 1. 구름 이동 후 +1 해주는 메소드
	private static void cloudmove() {

		int size = cloud.size();
		while (size > 0) {

			Point P = cloud.poll(); // 일단 구름이 있는 애들 하나씩 빼내서 비바라기시작
			int x = P.x;
			int y = P.y;

			for (int i = 0; i < S; i++) {// 8방으로 이
				x = x + da[0][D - 1];
				y = y + da[1][D - 1];

				if (x < 0)
					x = N - 1;
				if (x >= N)
					x = 0;
				if (y < 0)
					y = N - 1;
				if (y >= N)
					y = 0;

			}

			map[x][y] += 1; // 구름 위에 있는 애들은 +1 해줌
			check[x][y] = true; // 구름 위 애들은 true 체크 해주기
			cloud.add(new Point(x, y)); //다시 집어넣어줌

			size--;

		}
		diagonal();
		change();
//		for (int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(check[i]));
//		}
		check = new boolean[N][N];

	}

	// 주문이 끝난 후 2 이상의 구름 체인지 (원래구름 있던 자리는 패스, -2만큼 또해줌 )
	private static void change() {
		sum = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] >= 2 && !check[i][j]) { // 크기가 2 이상이고 원래 구름 자리가 아닌경우
					cloud.add(new Point(i, j)); // 다시 큐에 넣고
					map[i][j] -= 2; // -2해줌

				}

			}
		}
	}

	// 2. 해당 비구름 위치에서 물이 담겨 있는 수만큼 해당 비구름 위치 +해주는 메소드
	private static void diagonal() {
int size = cloud.size();
		while (size>0) 
		{
			Point P= cloud.poll();
			int x=P.x;
			int y=P.y;
//		System.out.print(x+" ");
//		System.out.println(y);
			for (int i = 0; i < 4; i++) {
				int X = x + ca[0][i];
				int Y = y + ca[1][i];
				if (X >= 0 && Y >= 0 && X < N && Y < N) {
					if (map[X][Y] > 0) {
//					System.out.print(X+" ");
//					System.out.println(Y);
						map[x][y] += 1;
					}
				}
				
			}
			
//		System.out.println();
			size--;
			
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
