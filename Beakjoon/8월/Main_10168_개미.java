package day0827;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10168_개미 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int w = Integer.parseInt(st.nextToken()); // 가로 길이
		int h = Integer.parseInt(st.nextToken()); // 세로 길이
		int map[][] = new int[w][h];

		st = new StringTokenizer(br.readLine(), " ");
		int p = Integer.parseInt(st.nextToken()); // 개미의 초기값 위치
		int q = Integer.parseInt(st.nextToken());
		int cnt = 0; // 시간 카운트
		int t = Integer.parseInt(br.readLine()); // 시간

		int di[] = { -1, -1, 1, 1 }; // 행 상우, 상좌 , 하좌, 하우
		int dj[] = { 1, -1, -1, 1 };

		aa: for (int i = 0; i < 4; i++) {

			while (true) {
				int X = di[i] + p;
				int Y = dj[i] + q;

				if (X < 0 || Y < 0 || X > w || Y > h) {
					break;
				}
				
				p = X;
				q = Y;
				System.out.println(p+" "+q);
				cnt++;
				if (cnt == t) {
					break aa;
				}

			}

		}
		
		System.out.println(p+" "+q);

	}

}
