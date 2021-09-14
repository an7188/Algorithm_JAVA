import java.util.Arrays;
import java.util.Scanner;

public class Main_15649_N과M1 {

	static Scanner sc = new Scanner(System.in);
	static int N; //N개의 숫자 중에서 M개를 뽑는 순열
	static int M; 
	static int [] arr; // N개의 숫자를 담을 배열
	static int [] box; // N개중에 M개를 뽑아서 담을 배열
	static boolean isSelected[]; // 사용중인지 확인하는 배열
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		
		N= sc.nextInt();
		M= sc.nextInt();
		isSelected = new boolean[N+1];
		arr = new int [N+1];
		box = new int[M];
		
		for (int i = 1; i <= N; i++) {
			arr[i]= i;
		}
		
		
		
		pe(0);
		
		
		
	}

	private static void pe(int cnt) {
		if (cnt==M) {
			for (int i = 0; i < M; i++) {
				System.out.print(box[i]+" ");
			}
			System.out.println();
			return;
		}
		
		for (int i = 1; i <= N; i++) {
			if(isSelected[i]) continue;
			
			box[cnt]=arr[i];
			isSelected[i]= true;
			
			
			pe(cnt+1);
			isSelected[i]= false;
			
		}
	}

}
