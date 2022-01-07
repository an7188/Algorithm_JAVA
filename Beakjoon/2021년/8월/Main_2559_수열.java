package day0828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2559_수열 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken()); // 연속적인 날짜
		int[] arr = new int[N]; // N개의 숫자를 담을 배열
		st = new StringTokenizer(br.readLine(), " ");

		int Max = Integer.MIN_VALUE;

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		
		for (int j = 0; j <= N-K; j++) {
			int sum = 0;
			for (int i = j; i < K+j; i++) {
				sum += arr[i];
			}
			if (Max<sum) {
				Max=sum;
			}
		}
		
		System.out.println(Max);
		
		
		
		
	}

}
