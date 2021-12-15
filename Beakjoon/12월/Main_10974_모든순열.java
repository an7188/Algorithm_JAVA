package day1214;

import java.util.Arrays;
import java.util.Scanner;

public class Main_10974_모든순열 {

	
	static int N;
	static boolean[] isSelected;
	static int[] number;
	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		
		N = sc.nextInt();
		
		isSelected = new boolean[N+1]; 
		number = new int [N];
		
		pe(0);
		
	}

	private static void pe(int cnt) {
		if(cnt==N){
			
			for (int i = 0; i < N; i++) {
				System.out.print(number[i]+" ");
			}
			System.out.println();
			return;
			
		}
		
		for (int i = 1; i <=N; i++) {
			if(isSelected[i]) continue;
			
			number[cnt] =i;
			isSelected[i]=true;
			
			//다음 자리로 옮김
			pe(cnt+1);
			isSelected[i]=false;
			
			
		}
	}

}
