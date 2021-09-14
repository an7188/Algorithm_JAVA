import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class Main_3040_백설공주난쟁이 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[9];
		int  sum = 0, p=0, u=0;

		for (int i = 0; i < 9; i++) {
			int num = sc.nextInt();
			arr[i] = num;
			sum= sum+ arr[i];
		}
		
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (sum-arr[i]-arr[j]==100) {
					p=i;
					u=j;
				}
			}		
		}
		
		for (int i = 0; i < 9; i++) {
			if (i!=p && i !=u) {
				System.out.println(arr[i]);
			}
		}

		

	}

}
