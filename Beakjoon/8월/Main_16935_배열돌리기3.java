package day0813;

import java.net.StandardSocketOptions;
import java.util.Scanner;

public class Main_16935_배열돌리기3 {

	static int N;
	static int M;
	static int R;
	static int RN;
	static int[][] arr;
	static int C ;
	static int Y ;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		R = sc.nextInt();
		arr = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int num = sc.nextInt();
				arr[i][j] = num;
			}
		}

		RN = sc.nextInt();
		for (int i = 0; i < R; i++) {

			if (RN == 1) {
				ud();

			} else if (RN == 2) {
				rl();

			} else if (RN == 3) {
				rtn();
			} else if (RN == 4) {
				ltn();
			} else if (RN == 5) {
				rm();
			} else if (RN == 6) {

			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}

	}

	// 상하 반전
	static void ud() {
		int[][] box = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				box[N - i - 1][j] = arr[i][j];

			}
		}
		arr = box;
	}

	// 좌우 반전
	static void rl() {
		int[][] box = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				box[i][M - j - 1] = arr[i][j];
			}
		}
		arr = box;

	}

	// 90도 회전
	static void rtn() {
		int[][] box = new int[M][N];
		int temp = 0;
		for (int i = 0; i < M; i++) {

			for (int j = 0; j < N; j++) {

				box[i][N - j - 1] = arr[j][i];
				// System.out.print(box[i][N-j-1]);
			}
			// System.out.println();
		}
		temp = N;
		N = M;
		M = temp;
		arr = box;
	}

	static void ltn() {
		int[][] box = new int[M][N];
		int temp = 0;
		for (int i = 0; i < M; i++) {

			for (int j = 0; j < N; j++) {

				box[M-i-1][j] = arr[j][i];
				// System.out.print(box[i][N-j-1]);
			}
			// System.out.println();
		}
		temp = N;
		N = M;
		M = temp;
		arr = box;
	}
	
	
	static void rm () {
		C = N/2;
		Y =M/2;
		int [][] temp = new int [C][Y];
		
		//2번 그룹 잠시 뺴놓기
		for (int i = 0; i < 3; i++) {
			for (int j = 4; j < 8; j++) {
				temp[i][j] = arr[i][j];
				System.out.print(temp);
			}
			System.out.println();
		}
		
		
		
		
		
		
		
	}

}
