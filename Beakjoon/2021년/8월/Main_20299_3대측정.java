package test;

import java.util.Scanner;

public class Main_20299_3대측정 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder()
				
				;
		int TC = sc.nextInt();
		int K = sc.nextInt();
		int L= sc.nextInt();
		int sum =0,cnt=0; 
		
		
		for (int tc = 0; tc < TC; tc++) {
		int x1 = sc.nextInt();
		int x2= sc.nextInt();
		int x3 = sc.nextInt();
		
		sum = x1+x2+x3;
		
		if (sum>=K && x1>=L && x2>=L && x3>=L) {
			sb.append(x1+" "+x2+" "+x3+" ");
			cnt++;
		}	
			
			
		}
		
		System.out.println(cnt);
		System.out.println(sb.toString());

		
		
	}

}
