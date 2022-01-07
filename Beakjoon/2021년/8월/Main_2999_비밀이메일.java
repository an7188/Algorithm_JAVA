package day0825;

import java.util.Scanner;

public class Main_2999_비밀이메일 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String em = sc.next();
		char [] arr = new char [em.length()];
	
		int len = em.length();
		int R=0,C=0;
		for (int i = 0; i < len; i++) {
			arr[i]=em.charAt(i);
		}
		
		for (int i = 1; i <= len ; i++) {
			if (len%i==0) {
				if (len/i>=i) {
					 R = len/i;
					 C = i;
				}else break;
				
			}
			
		}	
		char [][] map= new char[R][C] ;
		
		
		if (R==1 &&C==1) {
			System.out.println(em);
		}else {
			int cnt=0;
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					map[i][j]=arr[cnt];
					cnt++;
					
				}
			}
			
			
			
			for (int i = 0; i < C; i++) {
				for (int j = 0; j < R; j++) {
					System.out.print(map[j][i]);
				}
			}
			
		}
		
		
		

	
		
		
		
	}

}
