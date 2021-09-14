package test;

import java.util.Scanner;

public class Solution_5356_의석이세로로말해요 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		
		
		for (int TC = 1; TC <= tc; TC++) {
			String box ="";
			char [][] arr = new char[5][15];
			
			for (int i = 0; i < 5; i++) {
				String st= sc.next();
				for (int j = 0; j < st.length(); j++) {
					arr[i][j] = st.charAt(j);
				}
			}
			
			  for (int j = 0; j < 15; j++) {
				for (int i = 0; i < 5; i++) {
					if (arr[i][j]!=0) {
						box =  box+ arr[i][j];
					}
					
	
				}
			}
			
			System.out.println("#"+ TC +" "+box);
			
			
		}
		
	}

}


//#1 Aa0FfBb1GgCc2HhDd3IiEe4Jj
//#2 Aa0aPAf985Bz1EhCz2W3D1gkD6x