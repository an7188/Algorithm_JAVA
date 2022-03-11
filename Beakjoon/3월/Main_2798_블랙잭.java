package day03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/*
 * 220303
 * 조합으로 다시 풀기
 * */

public class Main_2798_블랙잭 {

	static BufferedReader br;
	static StringTokenizer st;
	static int N, M;
	static int arr[], box[];
	static int result=0;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		box = new int[3];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		P(0, 0);
		
		System.out.println(result);
	}

	private static void P(int cnt, int idx) {
		if (cnt == 3) { 
			int temp=0;
			for (int i = 0; i <3; i++) {
				temp+=box[i];
			}
			if(result<temp && temp<=M) { 
				result=temp;
			}
			return;
		}

		for (int i = idx; i < N; i++) {
			box[cnt] = arr[i];

			P(cnt + 1, i + 1);
		}
	}

}
