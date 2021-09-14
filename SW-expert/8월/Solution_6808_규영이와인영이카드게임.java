package day0815;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_6808_규영이와인영이카드게임 {

	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int T, N, num;
	static int gu[], in[];
	static int z;
	static boolean[] check; // 규영이가 가지고 있는 카드 확인
	static int win, lose;
	static int[] box;
	static boolean[] isSelected;

	public static void main(String[] args) throws IOException {

		br = new BufferedReader(new InputStreamReader(System.in));

		// st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(br.readLine());

		for (int i = 1; i <= T; i++) {
			win = 0;
			lose = 0;
			gu = new int[9];
			in = new int[9];
			check = new boolean[19];
			isSelected = new boolean[9];
			box = new int[9];
			num = 0;
			st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < 9; j++) {
				gu[j] = Integer.parseInt(st.nextToken());
				check[gu[j]] = true;
			}

			for (int j = 1; j <= 18; j++) {
				if (check[j])
					continue;

				in[num] = j;
				num++;

			}
//			System.out.println(Arrays.toString(gu));
//			System.out.println(Arrays.toString(in));
			pe(0);

			sb.append("#").append(i + " ").append(win).append(" ").append(lose).append("\n");

		}
		System.out.println(sb.toString());
	}

	private static void pe(int cnt) {

		if (cnt == 9) {
			int a = 0;
			int b = 0;
			for (int i = 0; i < 9; i++) {
				if (gu[i] > box[i]) {
					a = a + gu[i] + box[i];
				} else if (gu[i] < box[i]) {
					b = b + gu[i] + box[i];
				}

			}

			if (a > b)
				win++;
			else
				lose++;

			return;
		}
		for (int i = 0; i < 9; i++) {
			if (isSelected[i])
				continue;

			box[cnt] = in[i];
			isSelected[i] = true;
			pe(cnt + 1);
			isSelected[i] = false;

		}

	}

}
