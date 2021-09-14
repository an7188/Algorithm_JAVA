package day0805;

import java.util.Scanner;

public class Solution_1225_암호생성기 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int[] arr = new int[8];
		int temp = 0;
		for (int TC = 1; TC < 11; TC++) {
			int tc = sc.nextInt();

			for (int i = 0; i < 8; i++) {
				arr[i] = sc.nextInt();
				System.out.print(arr[i] + " ");
			}

			while (true) {
				if (arr[7]!=0) {

					for (int k = 1; k < 6; k++) {

						temp = arr[0];

						for (int i = 0; i < 7; i++) {
							arr[i] = arr[i + 1];
						}

						arr[7] = temp - k;
						

					}
					continue;
				}
				else if (arr[7] == 0) {
					break;
				}

			}

			System.out.print("#" + TC + " ");
			for (int i = 0; i < 8; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();

		}

	}

}
