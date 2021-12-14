package day1209;

import java.math.BigInteger;
import java.util.Scanner;

public class Main_1914_하노이탑 {

	/**
	 * 하노이탑 문제 1. 원판을 세 번째로 모두 옮겨 놓아야 한다. 2. 원판을 옮길때는 반드시 한번에 한개씩 옮길 수 있고 두 번째 기둥을
	 * 이용할 수 있다. 3. 옮기는 관정에서 절대로 큰 원판이 작은 원판 위에 놓이지 않아야한다.
	 * 
	 * 옮기 수는 2의 n제곱 -1
	 * 
	 **/

	static void hanoi(int n, int start, int temp, int dest) {

		if (n == 0)
			return;

		// 자신의 위쪽의 n-1개 원판 들어내기: 임시 기둥으로 옮기기
		hanoi(n - 1, start, dest, temp);

		// 자신의 원판 옮기기 : 목적 기둥
		System.out.println(start + " " + dest);

		// 들어냈던 임시기둥의 n-1개 원판 자신 위에 쌓기 : 목적 기둥으로 옮기기

		hanoi(n - 1, temp, start, dest);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		BigInteger big = new BigInteger("1");
		
		if (num <= 20) {
			int n = (int) (Math.pow(2, num)-1);
			System.out.println(n);
			hanoi(num, 1, 2, 3);
	
		}else {
			
			for (int i = 0; i < num; i++) {
				big= big.multiply(new BigInteger("2"));
				
			}
			big = big.subtract(new BigInteger("1"));
			System.out.println(big);
		}

	}

}
