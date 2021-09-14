package day0825;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;

public class Main_10026_적록색약 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int di[] = { 0, 1, 0, -1 }; //행 좌 하 우 
	static int dj[] = { 1, 0, -1, 0 };
	static int num;
	static int cnt = 0,cnt2=0;// 볼수 있는구역 수 저장
	static char[][] arr;
	static char[][] arr2;

	public static void main(String[] args) throws NumberFormatException, IOException {
		num = Integer.parseInt(br.readLine()); // 그림의 크기 정수로 받음
		arr = new char[num][num]; // 받아온 정수의 크기만큼 배열의 크기 지정
		arr2 = new char[num][num];
		for (int i = 0; i < num; i++) {
			String pic = br.readLine();
			for (int j = 0; j < num; j++) {
				arr[i][j] = pic.charAt(j);
				arr2[i][j]=pic.charAt(j);
			}
		}
//		for (int i = 0; i < num; i++) {
//			System.out.println(Arrays.toString(arr[i]));
//		}

		for (int i = 0; i < num; i++) {
			for (int j = 0; j < num; j++) {
				if (arr[i][j] != '*') {

					cnt++;

					find(arr[i][j], i, j);
					

				}

			}
		}
		for (int i = 0; i < num; i++) {
			for (int j = 0; j < num; j++) {
				if (arr2[i][j]=='R') {
					arr2[i][j]='G';
				}
				//System.out.print(arr2[i][j]);
			}
			//System.out.println();
		}
		
		
		
		for (int i = 0; i < num; i++) {
			for (int j = 0; j < num; j++) {
				if (arr2[i][j] != '*') {

					cnt2++;

					find2(arr2[i][j], i, j);
//					for (int j2 = 0; j2 < num; j2++) {
//						for (int k = 0; k < num; k++) {
//							System.out.print(arr2[j2][k]);
//						}
//						System.out.println();
//					}
				}

			}
		}
		
		System.out.println(cnt);
		System.out.println(cnt2);

	}

	

	private static void find2(char c, int i, int j) {
		// TODO Auto-generated method stub
		arr2[i][j]='*';
		for (int k = 0; k < 4; k++) {
			int x= di[k]+i;
			int y= dj[k]+j;
			
			if (x>=0 && y>=0 && x<num && y <num && arr2[x][y]==c) {
				arr2[x][y]='*';
				find2(c, x, y);
			}
			
			
		}
		
	}



	private static void find(char c, int i, int j) {
		arr[i][j]='*';
		
			for (int k = 0; k < 4; k++) {
				int x= di[k]+i;
				int y= dj[k]+j;
				
				if (x>=0 && y>=0 && x<num && y <num && arr[x][y]==c) {
					arr[x][y]='*';
					find(c, x, y);
				}
				
				
			}
				
			
		

	}

}
