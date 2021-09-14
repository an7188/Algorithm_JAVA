package day0828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main_14696_딱지놀이 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N= 0;
		int R= Integer.parseInt(st.nextToken()); //라운드 횟수 입력
		
		for (int r = 0; r < R; r++) {
			int Arr[]= new int[5];
			int Brr[]= new int[5];
			
			st = new StringTokenizer(br.readLine()," ");
			
			int A= Integer.parseInt(st.nextToken());  //A의 카드 갯수 담
			
			for (int i = 0; i < A; i++) {  //카드의 수 만큼 배열을 돌린 후 배열 순서에 카드값을 넣
				Arr[Integer.parseInt(st.nextToken())]+=1;
			}
			
			st= new StringTokenizer(br.readLine()," ");
			int B = Integer.parseInt(st.nextToken());
			
			for (int i = 0; i < B; i++) {
				Brr[Integer.parseInt(st.nextToken())]+=1;
			}
			
			
			for (int i = 4; i >= 0; i--) {
			
				if (Arr[i]==Brr[i]) {
					continue;
					
				}
				else if (Arr[i]>Brr[i]) {
					N=i;
					break;
				}else if (Arr[i]<Brr[i]) {
					N=i;
					break;
				}
					
		}
			if (Arr[N]>Brr[N]) {
				System.out.println("A");
			}else if (Arr[N]<Brr[N]) {
				System.out.println("B");
			}else {
				System.out.println("D");
			}
			
			
			
			
			
			
			
			
			
			
		}
	}

}
