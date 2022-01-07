package day0827;

import java.util.Arrays;
import java.util.Scanner;

public class Main_2309_일곱난쟁이 {
	static int[] nine = new int[9];
	static int[] seven = new int[7];
	static int[] ans = new int[7]; //답이 여러개일 경우 하나마 출력하기 위해서 정답 함수 만듬
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < 9; i++) {
			nine[i] = sc.nextInt();
		}
		Arrays.sort(nine);

		pe(0, 0);
		
		for (int i = 0; i < 7; i++) {
			System.out.println(ans[i]);
		}
	}

	private static void pe(int i, int j) {
		if (i == 7) {
			int sum=0;
			for (int j2 = 0; j2 < 7; j2++) {	
				 sum = sum+seven[j2];
			}
			
			if (sum==100) {
				for (int j2 = 0; j2 < 7; j2++) {
					ans[j2]=seven[j2];
				}
				
			}
			return;
		}

		for (int j2 = j; j2 < 9; j2++) {
			seven[i] = nine[j2];
			
			pe(i+1,j2+1);
		}

	}

}
