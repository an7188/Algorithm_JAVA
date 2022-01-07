package day0824;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main_1592_영식이와친구들 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		int L = sc.nextInt();
		int[] arr = new int[N + 1];
		int cnt=0;
		int index = 1;
		
		 arr[1]=1;
		while(true) {
			
			if (arr[index]%2!=0) {
				if (N<index+L) index=index+L-N;
				else index=index+L;
				
				arr[index]=arr[index]+1;
				//System.out.println(index+"홀");
				
			}else if (arr[index]%2==0) {
				if (0>=index-L) index=index-L+N;
				else index=index-L;
				
				arr[index]=arr[index]+1;
				//System.out.println(index+"짝");
			}
			cnt++;
			if (arr[index]==M) {
				break;
			}
			
			
		}
//		for (int i = 1; i < N+1; i++) {
//			System.out.println(arr[i]);
//		}
//		
		System.out.println(cnt);

		

	}

}
