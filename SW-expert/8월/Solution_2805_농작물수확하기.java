package day0804;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution_2805_농작물수확하기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine()); // 테스트 케이스 입력

		for (int tc = 1; tc <= TC; tc++) {// 입력받은 테스트케이스만큼 반복
			int N = Integer.parseInt(br.readLine()); // 배열의 크기 입력
			int[][] arr = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				String temp = br.readLine();
				for (int j = 0; j < N; j++) {
					arr[i][j] = temp.charAt(j) - '0'; // cha-> int형변환
//					System.out.print(arr[i][j] + " ");
				}
//				System.out.println();
			} // i

			int box = 0;

			for (int i = 0; i <= N/2; i++) {
				for (int j = (N / 2) - i; j <= (N / 2) + i; j++) {
					box += arr[i][j];
				}
			}
			
			for (int i = N/2+1, l=N-1; i < N; i++) {
				for (int j = Math.abs((N/2)-i); j < l; j++) {
					box+= arr[i][j];
				}
				l--;
			}
			
			
			 System.out.println("#" + tc + " " + box);
		} // tc
		
	}

}














//		Scanner sc = new Scanner(System.in);
//
//		int TC = sc.nextInt(); // 테스트 케이스 입력
//
//		for (int tc = 1; tc <= TC; tc++) {// 입력받은 테스트케이스만큼 반복
//
//			int N = sc.nextInt(); // 배열의 크기 입력
//			int[][] arr = new int[N][N];
//			
//			for (int i = 0; i < N; i++) {
//				String temp = sc.next();
//				for (int j = 0; j < N; j++) {
//					arr[i][j] = temp.charAt(j) - '0'; // cha-> int형변환
////					System.out.print(arr[i][j] + " ");
//				}
////				System.out.println();
//			} // i
//
//			int box = 0;
//
//			for (int i = 0; i <= N/2; i++) {
//				for (int j = (N / 2) - i; j <= (N / 2) + i; j++) {
//					box += arr[i][j];
//				}
//			}
//
//			
//			 System.out.println("#" + tc + " " + box);
//		} // tc

