package day0923;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_4963_섬의개수_DFS {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] map; // 지도 배열
	static boolean[][] check;
	static int w, h,cnt; // 지도 너비와 높이
	static int[] di = { -1, 1, 0, 0, -1, -1, 1, 1 }; // 위 ,아래 ,왼 ,우, 좌상 ,우상, 좌하 ,좌우
	static int[] dj = { 0, 0, -1, 1, -1, 1, -1, 1 };

	public static void main(String[] args) throws IOException {
		
		while(true) {
		st = new StringTokenizer(br.readLine(), " ");
		w = Integer.parseInt(st.nextToken()); // 열 
		h = Integer.parseInt(st.nextToken()); // 행 
		if(w==0 && h==0) break;
		
		map= new int [h][w];
		check = new boolean [h][w];
		for (int i = 0; i < h; i++) {
			st= new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < w; j++) {
				map[i][j]= Integer.parseInt(st.nextToken());
			}
		} //입력 끝
		
		
		cnt=0;
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if (map[i][j]==1) {
					dfs(i,j);
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
		
		}

	}

	static void dfs(int k, int l) {
		check[k][l] = true;
		map[k][l] = 0;
		
		for (int i = 0; i < 8; i++) {
			int X = k + di[i];
			int Y = l + dj[i];
			
			if (X >= 0 && X < h && Y >= 0 && Y < w && map[X][Y] == 1 && !check[X][Y]) {
				dfs(X, Y);
			}

		}
		
		
		
	}

}
