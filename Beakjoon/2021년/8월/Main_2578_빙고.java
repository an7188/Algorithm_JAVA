package day0827;

import java.util.Arrays;
import java.util.Scanner;

public class Main_2578_빙고 {
	static int[][] map = new int[5][5];
	static int cnt=0;
	static int co=0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				map[i][j] = sc.nextInt();

			}
		}

		 for (int i = 0; i < 25; i++) {
			int num = sc.nextInt();

			for (int j = 0; j < 5; j++) {
				for (int k = 0; k < 5; k++) {
					if (map[j][k] == num) {
						map[j][k] = 0;

					}continue;

				}
			}
				rcheck(); // 행 검사
				ccheck(); // 열 검사
				leftcheck(); // 왼쪽 대각선 검사
				rightcheck(); // 오른쪽 대각선 검사
				co++;
				if (cnt >= 3) {
					System.out.println(co);
					break ;
				
			}
				cnt=0;
				
				

		}


	}

	private static void rcheck() {
		for (int i = 0; i < 5; i++) {
			int zero = 0;
			for (int j = 0; j < 5; j++) {
				if (map[i][j] == 0) {
					zero++;
				}

			}
			if (zero == 5) {
				
				cnt++;
			}
			

		}

	}

	private static void ccheck() {
		for (int i = 0; i < 5; i++) {
			int zero = 0;
			for (int j = 0; j < 5; j++) {
				if (map[j][i] == 0) {
					zero++;
				}

			}
			if (zero == 5) {
				cnt++;
			}

		}

	}

	private static void leftcheck() {
		int zero = 0;
		for (int i = 0; i < 5; i++) {
			if (map[i][i] == 0) {
				zero++;
			}
		}

		if (zero == 5) {

			cnt++;
		}

	}

	private static void rightcheck() {

		int zero = 0;
		for (int i = 0; i < 5; i++) {
			if (map[i][4 - i] == 0) {
				zero++;
			}
		}

		if (zero == 5) {

			cnt++;
		}
	}

}
