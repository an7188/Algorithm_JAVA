package day0822;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2669_직사각형네개의합집합 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int cnt=0;
		int[][] map = new int[100][100];

		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			for (int j = x1; j < x2; j++) {
				for (int k = y1; k < y2; k++) {
					if (map[j][k]!=1) {

						map[j][k] = 1;
					}
				}
			}
		}
//			for (int i = 0; i < map.length; i++) {
//				for (int j = 0; j < map.length; j++) {
//					System.out.print(map[i][j]);
//				}
//				System.out.println();
//			}
		
		
		
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (map[i][j]==1) {
					cnt++;
				}
			}
		}
		
		
		
		System.out.println(cnt);
	}

}
