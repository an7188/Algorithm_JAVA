package day0828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_13300_방배정 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());// 학생 수
		int K = Integer.parseInt(st.nextToken());  //한 방에 최대 인원 수
		int arr[][] = new int [6][2];
		int B =0; // 바
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int S= Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());
			
			arr[Y-1][S]++; //성별과 학년을 배열로 만들어서 ++
			
			
		}
		
//		
//		for (int i = 0; i < 6; i++) {
//			System.out.println(Arrays.toString(arr[i]));
//		}
		
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 2; j++) {
				if (arr[i][j]<=K && arr[i][j]>0) {
					B++;
				}else if(arr[i][j]!=0) {
					int bang =arr[i][j];
					while(true) {
						B++;
						
						if (bang<=K) {
							break;
						}
						bang-=K;
						
						
					}
					
					
				}
				
				
			}
		}
		
			System.out.println(B);

	}

}
