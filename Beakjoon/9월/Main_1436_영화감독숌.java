package day1009;

import java.util.Scanner;

public class Main_1436_영화감독숌 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int cnt = 0;
		for (int i = 666; i <= Integer.MAX_VALUE; i++) {
			String st = Integer.toString(i);

			if (st.contains("666")) {
				if ((N - 1) == cnt) {
					System.out.println(i);
					break;

				}
				cnt++;

			}

		}

	}

}
