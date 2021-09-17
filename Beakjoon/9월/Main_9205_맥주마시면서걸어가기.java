package day0916;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


// 플루이드 와샬로 구현 
public class Main_9205_맥주마시면서걸어가기 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int map[][];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		
		int T= Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
		
			int N = Integer.parseInt(br.readLine()); // 편의점 수 
			map= new int [N+2][N+2];
			
			List <int []> list = new ArrayList<>();
			
			for (int i = 0; i < N+2; i++) {
				
				st = new StringTokenizer(br.readLine());
				int x= Integer.parseInt(st.nextToken()); // x좌표 
				int y= Integer.parseInt(st.nextToken()); // y좌표 
				int arr[]= {x,y};
				list.add(arr);
				// list.add( new int [] {x,y});
				
				
			}
			
			
			for (int i = 0; i < N+2; i++) {
				for (int j = 0; j < N+2; j++) {
					int [] arr1 = list.get(i);
					int [] arr2 = list.get(j);
					
					map[i][j]= Math.abs(arr1[0]-arr2[0])+Math.abs(arr1[1]-arr2[1]);
					if (map[i][j]>1000) {
						map[i][j]=-1;
					}
					
				}
			}
			
//			for (int i = 0; i < N+2; i++) {
//				for (int j = 0; j < N+2; j++) {
//					System.out.print(map[i][j]);
//				}
//				System.out.println();
//			}
		
			
			for (int k = 0; k < N+2; k++) { //경로 
				for (int i = 0; i < N+2; i++) { //출발 
					for (int j = 0; j < N+2; j++) { //도착 
						if (map[i][k]==-1 || map[k][j]==-1) continue;
						
						map[i][j]= 1;
						
					}
				}
			}
			
			if (map[0][N+1]==-1) {
				System.out.println("sad");
			}else {
				System.out.println("happy");
			}
			
			
			
			
			
		}
	
		
	}

}
