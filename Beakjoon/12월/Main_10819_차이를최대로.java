package day1214;

import java.io.IOException;
import java.util.Scanner;

public class Main_10819_차이를최대로 {

	static int N;
	static int arr[];
	static int num[];
	static boolean isSelected[]; 
	static int sum;
	static int Max;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		num = new int[N];
		isSelected = new boolean[N];
		Max=Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		pe(0);
		System.out.println(Max);

	}

	private static void pe(int cnt) {
		sum =0;
		if (cnt == N) {
			for (int i = 0; i < N-1; i++) {
				sum= sum+Math.abs(num[i]-num[i+1]);
			}
			if(Max<sum) Max=sum;
			
			return;

		}

		for (int i = 0; i < N; i++) {
			if (isSelected[i])
				continue;

			num[cnt] = arr[i];
			isSelected[i] = true;

			pe(cnt + 1);
			isSelected[i] = false;

		}

	}

}
