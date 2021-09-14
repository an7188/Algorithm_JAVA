package day0815;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_9229_한빈이spotmart {
	static StringBuilder sb = new StringBuilder();
	static BufferedReader br;
	static StringTokenizer st;
	static int N, M, TC, max;
	static int[] arr;
	static int[] box;

	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));

		TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {
			max = Integer.MIN_VALUE;
			st = new StringTokenizer(br.readLine(), " ");

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			arr = new int[N];
			box = new int[2];
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {

				arr[i] = Integer.parseInt(st.nextToken());

			}
			// System.out.println(Arrays.toString(arr));

			pe(0, 0);

			if (0 < max) {
				System.out.println("#" + tc + " " + max);
			} else {
				System.out.println("#" + tc + " " + "-1");
			}

		}

	}

	private static void pe(int cnt, int idx) {
		if (cnt == 2) {
			// System.out.println(Arrays.toString(box));
			if (max < box[0] + box[1] && M >= box[0] + box[1]) {
				max = box[0] + box[1];
			}

			return;
		}

		for (int i = idx; i < N; i++) {

			box[cnt] = arr[i];

			pe(cnt + 1, i + 1);
		}
	}

}
