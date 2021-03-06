package day0914;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_2667_단지번호붙이기 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static ArrayList<Integer> ar = new ArrayList<>();
	static int di[] = { 0, 1, 0, -1 }; // 우 하 좌 상
	static int dj[] = { 1, 0, -1, 0 };
	static int N; // 아파트 배열 수
	static int[][] map;
	static int dong; //아파트 단지 수 
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		int aptc=0;
		for (int i = 0; i < N; i++) {
			String apt = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = apt.charAt(j)-'0';
			}

		}

//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				System.out.print(map[i][j]);
//			}
//			System.out.println();
//		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1) {
					dong=1;
					find(i, j);
					aptc++;
					ar.add(dong);
				}

			}
		}
		
		Collections.sort(ar);
		System.out.println(aptc);
		for (int aa : ar) {
			System.out.println(aa);
		}
		
		
	
		
		
		
		

	}

	// 아파트 1을 찾아주는 메소드 
	private static int find(int i, int j) {
		map[i][j] = 0;
		for (int k = 0; k < 4; k++) {

			int X = i + di[k];
			int Y = j + dj[k];

			if (X >= 0 && Y >= 0 && X < N && Y < N && map[X][Y] == 1) {
				find(X,Y);
				dong++;
			}

		}
		
		return dong;

	}
	
	
	
	

}
