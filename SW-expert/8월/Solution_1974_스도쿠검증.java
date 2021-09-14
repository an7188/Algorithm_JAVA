package day0813;

import java.util.Scanner;

public class Solution_1974_스도쿠검증 {
	//static int[] cc = new int[9];

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int TC = sc.nextInt();
		

		
		for (int tc = 1; tc <= TC; tc++) {
			boolean ch = false;
			int[][] arr = new int[9][9];
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					int num = sc.nextInt();
					arr[i][j] = num;
				}
			}

			xx: for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					for (int j2 = 1; j2 < 9; j2++) {
						if (j != j2) {
							if (arr[i][j] == arr[i][j2]) {
								ch = true;
								break xx;
							}
						}
					}

				}

			}

			if (ch) {
				System.out.println("#" + tc + " " + "01");
				continue;
			} else if (ch == false) {

				yy: for (int i = 0; i < 9; i++) {
					for (int j = 0; j < 9; j++) {
						for (int j2 = 1; j2 < 9; j2++) {
							if (j != j2) {
								if (arr[j][i] == arr[j2][i]) {
									ch = true;
									break yy;
								}
							}
						}
					}
				}
			}
			
			

			if (ch) {
			System.out.println("#" + tc + " " + "0");
			continue;
		} else if (ch == false) {
			cc: for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					int[] cc = new int[9];
					
					for (int s1 = i; s1 < i + 3; s1++) {
						for (int s2 = j; s2 < j + 3; s2++) {
							cc[arr[s1][s2]-1] ++;
		
							if (cc[arr[s1][s2]-1] >=2) {
								ch = true;
								break cc;
							}
						}
						
					}
					j = +2;
				}
				i = +2;
			}
			
		}
			
			
			
			
			if (ch) {
				System.out.println("#" + tc + " " + "0");
			} else if (ch == false) {
				System.out.println("#" + tc + " " + "1");
			}


		}

	}

}










//
//if (ch) {
//	System.out.println("#" + tc + " " + "0");
//	continue;
//} else if (ch == false) {
//	cc: for (int i = 0; i < 9; i++) {
//		for (int j = 0; j < 9; j++) {
//			int[] cc = new int[9];
//			
//			for (int s1 = i; s1 < i + 3; s1++) {
//				for (int s2 = j; s2 < j + 3; s2++) {
//					cc[arr[s1][s2]-1] ++;
//
//					if (cc[arr[s1][s2]-1] >=2) {
//						ch = true;
//						break cc;
//					}
//				}
//			}
//			j = +2;
//		}
//		i = +2;
//	}
//	
//}
