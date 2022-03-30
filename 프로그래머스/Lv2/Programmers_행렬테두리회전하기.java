package day03;

import java.util.Arrays;

public class Programmers_행렬테두리회전하기 {

	public static void main(String[] args) {
		int rows =6;
		int columns= 6;
		int[][] queries= {{2,2,5,4},{3,3,6,6},{5,1,6,3}};

		System.out.println(Arrays.toString(Solution(rows,columns,queries)));
	
	}

	private static int[] Solution(int rows, int columns, int[][] queries) {
		 int[] answer = new int [queries.length];
		 
		 int map[][]= new int[rows+1][columns+1];
		 
		 int num =1;
		 for (int i = 1; i < rows+1; i++) {
			for (int j = 1; j < columns+1; j++) {
				map[i][j]=num;
				num++;
			}
		}
		 
//		 for (int i = 0; i < map.length; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
		 
		 for (int i = 0; i < queries.length; i++) {
			
			 int topR= queries[i][0];
			 int topC= queries[i][1];
			 int BottR= queries[i][2];
			 int BottC= queries[i][3];
			 
//			 System.out.println(topR+" "+topC+" "+BottR+" "+BottC);
			 
			 //맨 위 왼쪽에서 오른쪽으로 가기
			 int temp = map[topR][BottC];
			 int min=temp;
			 for (int j = BottC; j > topC; j--) {
				map[topR][j]=map[topR][j-1];
				min = Math.min(min, map[topR][j]);
			}
			 
			 //왼쪽 밑에 위로 가기
			 for (int j = topR; j <BottR; j++) {
				map[j][topC]=map[j+1][topC];
				min = Math.min(min, map[j][topC]);
			}
			 
			 //아래쪽 오른쪽에서 왼쪽으로 가기
			 for (int j = topC; j < BottC; j++) {
				map[BottR][j]=map[BottR][j+1];
				min = Math.min(min, map[BottR][j]);
			}
			 
			 //오른쪽 위에서 아래로 보내기
			 for (int j = BottR; j >topR+1; j--) {
				map[j][BottC]= map[j-1][BottC];
				min = Math.min(min, map[j][BottC]);
			}
			 map[topR+1][BottC]=temp;
			
			 answer[i]=min;
		}
		 
	        return answer;
	}

}
