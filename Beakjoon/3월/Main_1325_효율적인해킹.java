package day03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_1325_효율적인해킹 {
	static BufferedReader br;
	static StringTokenizer st;
	static boolean check[];
	static int N, M;
	static ArrayList<Integer>[] list;
	static int result[];

	public static void main(String[] args) throws NumberFormatException, IOException {

		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 컴퓨터 수
		M = Integer.parseInt(st.nextToken()); // 신뢰 개수

		list = new ArrayList[N];
		result = new int[N];
		for (int i = 0; i < N; i++) {
			list[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			list[B - 1].add(A - 1); // 신뢰하는 곳 1로 표시

		}
//		int Max = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			check = new boolean[N];
			dfs(i, i);
			
//			Max = Math.max(result[i], Max);
//			System.out.println(result[i]+"씨잫"+i);
		}
		int max=0;
		for (int i = 0; i < N; i++) {
			if(result[i]>max) {
				max=result[i];
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			if (result[i] == max) {
				sb.append(i + 1+" ");

			}
		}

		System.out.println(sb.toString());
	}

	private static void dfs(int i, int start) {

		check[i] = true;
		for(int tmp : list[i]) {
			if(!check[tmp]) {
				result[start]++;
				dfs(tmp,start);
			}
		}
		
		
//		for (int j = 0; j < list[i].size(); j++) {
//			if (!check[j] ) {
//				System.out.print(i+ " "+list[i].get(j)+" 씨발");
//				result[start]++;
//				dfs(list[i].get(j), start);
//			}
//		}
//		System.out.println();

	}

}
