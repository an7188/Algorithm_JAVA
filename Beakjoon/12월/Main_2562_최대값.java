package day1209;

import java.util.Scanner;

public class Main_2562_최대값 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int arr[]= new int[9];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i]=sc.nextInt();
		}
		
		int N= arr[0];
		int cnt=1;
		for (int i = 1; i < arr.length; i++) {
			if(N<arr[i]) {
				N=arr[i];
				cnt=i+1;
			}
			
		}
		
		System.out.println(N);
		System.out.println(cnt);
	}

}
