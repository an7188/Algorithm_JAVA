package day1209;

import java.util.Scanner;

public class Main_2747_피보나치수 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int a = 0;
		int b = 1;
		int sum = 0;
		if (N == 1) {
			System.out.println(1);
		} else {
			for (int i = 1; i < N; i++) {

				sum = a + b;
				a = b;
				b = sum;

			}
			System.out.println(sum);
		}

	}

}
