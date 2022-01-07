package day0817;

import java.util.Scanner;

public class Main_2839설탕배달 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		int bj1 = 3;
//		int bj2 = 5;

		int kg = sc.nextInt();
		int num = 0;
		
		
		while(true) {
			if (kg%5==0) {
				System.out.println(kg/5+num);
				break;
			}else if (kg<=0) {
				System.out.println("-1");
				break;
			}
			
			kg=kg-3;
			num++;
			
		}
	}

}
