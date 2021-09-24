package day0914;

import java.util.Scanner;

public class Main_1463_1로만들기_dp {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] d = new int[N + 1];

		d[0] = 0;
		d[1] = 0;

		for (int i = 2; i <= N; i++) {
			d[i] = d[i - 1] + 1;

			if (i % 2 == 0) {
				d[i] = Math.min(d[i / 2] + 1, d[i]);
			}
			if(i%3==0) {
				d[i] = Math.min(d[i / 3] + 1, d[i]);
			}

		}
		System.out.println(d[N]);

	}
	


}
