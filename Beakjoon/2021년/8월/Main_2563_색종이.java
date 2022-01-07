package day0813;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class Main_2563_색종이 {
	static int map[][];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		map = new int[100][100];
		// Arrays.fill(map, 0); //100 100배열 안에 0으로 초기

		int N = sc.nextInt();

		for (int i = 0; i < N; i++) {
			int R = sc.nextInt();
			int C = sc.nextInt();

			for (int j = R; j <= R + 9; j++) {
				for (int j2 = C; j2 <= C + 9; j2++) {
					if (map[j][j2] != 1)
						map[j][j2] = 1;
					else
						continue;

				}
			}

		}

		int temp = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (map[i][j] == 1) {
					temp += 1;
				}

			}
		}
		
		
		System.out.println(temp);

	}

}