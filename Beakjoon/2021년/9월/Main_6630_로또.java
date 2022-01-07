  package day0920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_6630_로또 {
	
	static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int k, s; // k= s집합에 원소 개수 
	static int [] arr;
	static int [] box;
	
	
	public static void main(String[] args) throws IOException {
		
		
		while(true) {
			
			st= new StringTokenizer(br.readLine());
			k=Integer.parseInt(st.nextToken()); // 첫번째 칸은 원소의 개수 입력 
			
			
			if (k==0) break; // 0 을 입력 받으면 끝
			
			arr= new int [k];
			box= new int [6];
			
			for (int i = 0; i < k; i++) {
				arr[i]=Integer.parseInt(st.nextToken());
			}
			// 입력 끝
			
//			for (int i = 0; i < k; i++) {
//				System.out.print(arr[i]+" ");
//			}
			
			com(0,0);
			
			System.out.println();
			
			
		}
	}


	static void com(int idx, int cnt) {
		if (cnt==6) {
			for (int i = 0; i < 6; i++) {
				System.out.print(box[i]+" ");
			}
			System.out.println();
			return;
		}
		
		
		for (int i = idx; i < k; i++) {
			box[cnt]=arr[i];
			
			com(i+1,cnt+1);
			
		}
		
	}

}
