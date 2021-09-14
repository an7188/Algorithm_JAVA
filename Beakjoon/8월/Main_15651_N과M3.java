package day0815;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_15651_N과M3 {
	static BufferedReader br;
	static int[] arr;
	static int[] box;
	static boolean[] isSelected;
	static int N;
	static int M;
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	
	public static void main(String[] args) throws IOException {
		br= new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		box = new int[M];
		isSelected = new boolean[M];

		for (int i = 0; i < N; i++) {
			arr[i] = i+1;
			
		}
		
		 pe(0);
		 System.out.println(sb.toString());
	}

	private static void pe(int cnt) {
		if (cnt ==M) {
			for (int i = 0; i < M; i++) {
				sb.append(box[i]+ " ");
			}
			sb.append("\n");
			
			return;
		}
		for (int i = 0; i < N; i++) {
			box[cnt]=arr[i];
			
			
			pe(cnt+1);
			
			
		}
		
		
		
		
	}

}
