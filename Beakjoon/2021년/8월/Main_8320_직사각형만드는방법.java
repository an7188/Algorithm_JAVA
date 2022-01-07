package day0828;

import java.util.Scanner;

public class Main_8320_직사각형만드는방법 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		boolean ch[][]= new boolean [num+1][num+1] ;
		int cnt =0;
		
		for (int i = 1; i <= num; i++) {
			for (int j = 1; j <= num; j++) {
				if (ch[i][j]==false && i*j<=num) {
					cnt++;
					ch[i][j]=true;
					ch[j][i]=true;
							
				}
			}
		}
		
		System.out.println(cnt);
		
		
		
		
	}

}
