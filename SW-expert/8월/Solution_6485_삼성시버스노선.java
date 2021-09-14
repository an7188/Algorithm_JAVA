package test;

import java.util.Scanner;

public class Solution_6485_삼성시버스노선 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		
		for (int tc = 1; tc <= TC; tc++) {
			
			int N = sc.nextInt();
			int [][]arr = new int [N][2];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < 2; j++) {
					arr[i][j]=sc.nextInt();
					System.out.println(arr[i][j]);
				}
				
			}
			
			
			
			
			
		}
		
	}

}
