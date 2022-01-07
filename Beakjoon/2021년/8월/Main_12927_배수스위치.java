package day0825;

import java.util.Scanner;

public class Main_12927_배수스위치 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String sw = sc.next();
		char[] arr = new char[sw.length() + 1];
		int cnt = 0;
		int ch =0;
		for (int i = 1; i <= sw.length(); i++) {
			arr[i] = sw.charAt(ch);
			ch++;
		}

		for (int i = 1; i <= sw.length(); i++) {

			if (arr[i] == 'N') {
				continue;
			} else {
				arr[i] = 'N';
				cnt++;
				for (int j = i + 1; j <= sw.length(); j++) {
					if (j % i == 0) {
						if (arr[j] == 'N') {
							arr[j] = 'Y';

						} else {
							arr[j] = 'N';
						}
					}
				}

			}

		}

		System.out.println(cnt);

	}

}
