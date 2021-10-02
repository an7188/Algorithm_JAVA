package day1001;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4013_특이한자석_시뮬 {
	static StringTokenizer st;
	static int T, k;
	static int arr[][];
	static int rotation[];

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine()); // 테케입력

		for (int tc = 1; tc <= T; tc++) {
			arr = new int[5][8]; // 4개의 자석의 8개의 날

			k = Integer.parseInt(br.readLine()); // T의 테케 입력

			for (int i = 1; i <= 4; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < 8; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			} // 입력끝

			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				rotation = new int[5];
				int N = Integer.parseInt(st.nextToken()); // 자석 번호
				int D = Integer.parseInt(st.nextToken()); // 방향

				rotation[N] = D;

				// 기준 자석 번호에서 오른 쪽 확인
				for (int j = N; j < 4; j++) {
					if (arr[j][2] == arr[j + 1][6])
						break;

					if (rotation[j] == 1)
						rotation[j + 1] = -1;
					else
						rotation[j + 1] = 1;

				}

				// 기준 자석 번호에서 왼쪽 확인
				for (int j = N; j > 1; j--) {
					if (arr[j][6] == arr[j - 1][2])
						break;

					if (rotation[j] == 1)
						rotation[j - 1] = -1;
					else
						rotation[j - 1] = 1;
				}

				for (int j = 1; j <= 4; j++) {
					if (rotation[j] == 0)
						continue;
					else if (rotation[j] == -1) {

						int temp = arr[j][0];
						for (int k = 0; k < 7; k++) {
							arr[j][k] = arr[j][k + 1];
						}
						arr[j][7] = temp;

					} else if (rotation[j] == 1) {
						int temp = arr[j][7];
						for (int k = 7; k > 0; k--) {
							arr[j][k] = arr[j][k - 1];
						}
						arr[j][0] = temp;

					}

				}

			}

			int sum = 0;
			int h = 1;
			for (int i = 1; i <= 4; i++) {
				// System.out.println(arr[i][0]);
				if (arr[i][0] == 1) {
					sum += h;
				}
				h *= 2;

			}

			System.out.println("#" + tc + " " + sum);

		} // 테케

	}

}
