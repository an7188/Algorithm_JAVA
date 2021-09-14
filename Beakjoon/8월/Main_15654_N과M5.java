package day0815;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_15654_N과M5 {
	static StringBuilder sb = new StringBuilder();
	static BufferedReader br;
	static int[] arr; //N개의 숫자를 담는 배열
	static int[] box; // N개의 숫자 중 M개를 담는 배열 
	static boolean[] isSelected; // 중복이 있는지 확인 하는 배열 
	static int N; 
	static int M;
	static StringTokenizer st,st2;
	
	
	public static void main(String[] args) throws IOException {
		br= new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine()," ");
		st2 = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr= new int [N];
		box = new int[M];
		isSelected= new boolean[N];
		
		for (int i = 0; i < N; i++) {
			arr[i]= Integer.parseInt(st2.nextToken());
			
		}
		Arrays.sort(arr);
		
		pe(0);
		System.out.println(sb.toString());
	}


	private static void pe(int cnt) {
		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				sb.append(box[i] + " ");
			}
			sb.append("\n");
			return;
			
		}
		
		
		for (int i = 0; i < N; i++) {
			if(isSelected[i]) continue;
			
			
			box[cnt]=arr[i];
			isSelected[i]=true;
			
			
			pe(cnt+1);
			isSelected[i]= false;
		}
		
	}

}
