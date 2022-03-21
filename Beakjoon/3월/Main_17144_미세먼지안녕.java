package day03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17144_미세먼지안녕 {

	static BufferedReader br;
	static StringTokenizer st;
	static int R, C, T; // 행,열,시간
	static int map[][], copy[][];
	static Queue<Integer> cleaner = new LinkedList<>(); // 미세먼지 위치 저장
	static Queue<Point> dust = new LinkedList<>(); // 크기가 5보다 큰 미세먼지 저장
	static int ad[][] = { { 0, 0, -1, 1 }, { 1, -1, 0, 0 } };
	static int sum = 0;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");

		R = Integer.parseInt(st.nextToken()); // 행
		C = Integer.parseInt(st.nextToken()); // 열
		T = Integer.parseInt(st.nextToken()); // 시간

		map = new int[R][C];
		copy = new int[R][C];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == -1)
					cleaner.add(i); // 공기청정기 위치 저장
				else if (map[i][j] > 0) {
					dust.add(new Point(i, j)); // 5 이상인 먼지들 위치 저장( 확산 )
				}
			}
		} // 입력 끝

		for (int t = 0; t < T; t++) {

			// 미세먼지 확산
			DustFind();
			//공기 청정기 작동
			AirCleaner();

			//복사 했던 배열 다시 복구
			ArrayCopy();

			//큐에 먼지들 다시 집어넣기
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (map[i][j] > 0) {
						dust.add(new Point(i, j));
					}
				}
			}
		}

		System.out.println(sum);
	}

	private static void ArrayCopy() {
		sum = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				map[i][j] = copy[i][j];
				copy[i][j] = 0;
				if (map[i][j] != -1)
					sum += map[i][j];
			}
		}

	}

	private static void AirCleaner() {

		// 위쪽 공기청정기 반시계 방향으로 돌기
		int UX = cleaner.poll();
		for (int i = UX - 1; i > 0; i--)
			copy[i][0] = copy[i - 1][0];
		for (int i = 0; i < C - 1; i++)
			copy[0][i] = copy[0][i + 1];
		for (int i = 0; i < UX; i++)
			copy[i][C - 1] = copy[i + 1][C - 1];
		for (int i = C - 1; i > 0; i--)
			copy[UX][i] = copy[UX][i - 1];

		
		// 아래쪽 공기청정기 시계방향으로 돌기
		cleaner.add(UX);
		int DX = cleaner.poll();
		for (int i = DX + 1; i < R - 1; i++)
			copy[i][0] = copy[i + 1][0];
		for (int i = 0; i < C - 1; i++)
			copy[R - 1][i] = copy[R - 1][i + 1];
		for (int i = R - 1; i > DX; i--)
			copy[i][C - 1] = copy[i - 1][C - 1];
		for (int i = C - 1; i > 0; i--)
			copy[DX][i] = copy[DX][i - 1];
		cleaner.add(DX);
		copy[DX][1] = 0;
		copy[UX][1] = 0;
		copy[DX][0] = -1;
		copy[UX][0] = -1;
		// 이게 문제.. 공기청정기 자리를 빼버렸음 공청 자리 다시 넣어주기

	}

	private static void DustFind() {
		int size = dust.size();
		boolean check[][] = new boolean[R][C];
		while (size > 0) {

			Point P = dust.poll();

			int x = P.x;
			int y = P.y;

			check[x][y] = true;
			int aa = map[x][y] / 5; // 확산되는 양
			int count = 0;

			for (int i = 0; i < 4; i++) {
				int X = x + ad[0][i];
				int Y = y + ad[1][i];

				if (X >= 0 && Y >= 0 && X < R && Y < C) {
					if (map[X][Y] == -1) {
						copy[X][Y] = -1;
					} else {
						copy[X][Y] += aa; // copy배열에 확산된 양만큼 저장

						count++;
					}
				}

			}

			int bb = map[x][y] - (aa * count); // 남는 미세먼지양
			copy[x][y] += bb; // 현재 남은 미세먼지 양 현재 위치에 저장
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
