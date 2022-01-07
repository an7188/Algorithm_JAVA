package day1209;

import java.util.Scanner;

public class Main_2577_숫자의개수 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		int A= sc.nextInt();
		int B= sc.nextInt();
		int C= sc.nextInt();
		
		int result = A*B*C;
		int arr[]= new int[10];
		int aa= 100000000;
		
		while(result/aa==0) {
			
			aa= aa/10;
//			System.out.println(aa);
		}
		
		
		while(aa!=0) {
			arr[result/aa]++;
			result= result%aa;
			aa=aa/10;
			
			
			
		}
		
		
		for (int i = 0; i < 10; i++) {
			System.out.println(arr[i]);
		}
		
	}

}
