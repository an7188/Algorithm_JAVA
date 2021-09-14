package day0803;

import java.util.Scanner;

public class Solution_Flatten {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int[] arr = new int[100];

		for (int tc = 1; tc < 11; tc++) { // 테스트 케이스 10번

			int dum = sc.nextInt(); // 덤프값 입력

			for (int i = 0; i < 100; i++) { // 가로길이에 숫자 입력
				int num = sc.nextInt();
				arr[i] = num;
				// System.out.print(arr[i]+" ");
			}

			int temp = 0;
			for (int i = 99; i > 0; i--) {
				for (int j = 0; j < i; j++) {

					if (arr[j] > arr[j + 1]) {
						temp = arr[j];
						arr[j] = arr[j + 1];
						arr[j + 1] = temp;
					}
				}
			}

			
		
			for (int i = 0; i < dum; i++) {

				arr[99] = arr[99] - 1; // 제일 큰 숫자에서 하나빼기
				arr[0] = arr[0] + 1; // 제일 작은 숫자에서 하나 빼기

				
				for (int j = 0; j < 99; j++) {
					if (arr[j]>arr[j+1]) {
						temp=arr[j];
						arr[j]=arr[j+1];
						arr[j+1]=temp;
					}
					
				}
				
				
				
				
				for (int j = 0; j < 99; j++) {
					if (arr[99-j]<arr[99-(j+1)]) {
						temp=arr[99-j];
						arr[99-j]=arr[99-(j+1)];
						arr[99-(j+1)]=temp;
					}
				}
				

			}
			
			System.out.printf("#%d %d \n" , tc , arr[99]-arr[0]);
		}
		

	}

}
