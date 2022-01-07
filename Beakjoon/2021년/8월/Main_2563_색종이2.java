package test;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_2563_색종이2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int TC = sc.nextInt(); //테스트 케이스
		for (int tc = 1; tc <= TC; tc++) {

			String qz = sc.next(); // 문자열 입력
			char[] arr = qz.toCharArray();
			int score =1, temp=0;
			
			
		for (int i = 0; i < arr.length; i++) {
			if (arr[i]=='O') {
				temp+=score;
				score++;
			}else if (arr[i]=='X') {
				score=1;
			}
		}

		
		
			System.out.println(temp);
		
		}

	}

}
