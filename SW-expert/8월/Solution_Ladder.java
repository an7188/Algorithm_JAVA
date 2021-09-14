package day0804;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution_Ladder {

	static int[][] map;
	static int ans;
	static int[] di = { 0, 0, -1, };
	static int[] dj = { 1, -1, 0, };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int tc = 0; tc < 10; tc++) {
			int tcNum = Integer.parseInt(br.readLine());

			map = new int[100][100];
			ans = -1;

			int nowi = 99;
			int nowj = -1;

			for (int i = 0; i < 100; i++) { // 0 0 0 1 0 0 0 0 0 1 0 0 0 1 0
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {

					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 2) {
						nowj = j;
					}
				}

				while (true) {
					map[nowi][nowj]=9;

					if (nowi == 0) {
						ans = nowj;
						break;

					}
					for (int d = 0; d < 3; d++) { // 사다리 올라가는 방향 왼쪽, 오른쪽, 위 0,0,-1 
						int nexti = nowi + di[d]; //                             1,-1,0
						int nextj = nowj + dj[d];
						
						if (nextj<0 || nextj >=100) continue; // 사다리 범위를 넘어가는 경우 넘어감
						
						if (map[nexti][nextj]==1) {
							nowi=nexti;
							nowj=nextj;
							break; // 이동한 후에는 for 넘어감
						}
					}
				}
				System.out.println("#" + tc + " " + ans);
			}
		}
		
		
	}

}
