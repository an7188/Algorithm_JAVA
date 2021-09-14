package day0815;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_5215_햄버거다이어트 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int TC, N, cal;
	static int[][] arr;
	static boolean[] isSelected;
	static int Max, Maxcal;

	public static void main(String[] args) throws NumberFormatException, IOException {
		TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {
			Max = Integer.MIN_VALUE;
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken()); // 재료의 수
			cal = Integer.parseInt(st.nextToken()); // 칼로리의 기준
			Maxcal = 0;
			
			isSelected = new boolean[N];
			arr = new int[N][2];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
				//System.out.println(Arrays.toString(arr[i]));
			}
			
			pe(N, isSelected);
			
			System.out.println("#"+tc+" " +Maxcal);
		}

	}

	private static void pe(int cnt, boolean[] isSelected2) {
		if (cnt == 0) {
			paly(isSelected2);
			//System.out.println(Arrays.toString(isSelected2));
			return;
		}

		isSelected2[cnt - 1] = true;
		pe(cnt - 1, isSelected2);
		isSelected2[cnt - 1] = false;
		pe(cnt - 1, isSelected2);

	}

	private static void paly(boolean[] isSelected2) {
		int taste = 0;
		int cal2 = 0;
		
		
		boolean flag = false;
		for (int i = 0; i < N; i++) {
			if (!isSelected2[i])
				continue;

			flag = true;
			taste += arr[i][0];
			cal2 += arr[i][1];
			
		}

		if (flag == true && cal >= cal2 && Maxcal<taste) {
			//System.out.println(taste);
			//System.out.println(cal2);
			
			Maxcal = taste;
		}

	}

}
