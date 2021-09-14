package day0815;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_15650_N과M2 {
	//조합

	static BufferedReader br;
	static StringTokenizer st;
	static int N, M;
	static int[] arr;
	static int[] box;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		box = new int[M];

		

		for (int i = 0; i < N; i++) {
			arr[i] =i+1;
		}
		

		pe(0, 0);

		System.out.println(sb.toString());

	}

	private static void pe(int cnt, int idx) {
		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				sb.append(box[i] + " ");
			}
			sb.append("\n");
			return;
		}

		for (int i = idx; i < N; i++) {

			box[cnt] = arr[i];

			pe(cnt + 1, i + 1);

		}
	}

}
