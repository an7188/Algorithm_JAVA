package day0827;

import java.util.Scanner;

public class Main_2851_슈퍼마리오 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		int j = 0;
		int temp = 0;
		int[] arr = new int[10];
		for (int i = 0; i < 10; i++) {

			arr[i] = sc.nextInt();
		}

		while (j < 10) {
			sum = sum + arr[j];
			if (sum >= 100 || j==9) {
				break;
			}
			j++;

		}
//		System.out.println(sum);
//		System.out.println(arr[j]);
//		System.out.println(Math.abs(sum - arr[j] - 100));
//	
		if (Math.abs(sum - arr[j] - 100) < Math.abs(sum - 100)) {
			System.out.println(sum - arr[j]);
		} else {
			System.out.println(sum);
		}

	}

}
