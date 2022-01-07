package day1209;

import java.util.Arrays;
import java.util.Scanner;

public class Main_1546_평균 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		float arr[]= new float[sc.nextInt()];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i]=sc.nextInt();
		}
		Arrays.sort(arr);
		
		float max = arr[arr.length-1];

		float sum =0;
		for (int i = 0; i < arr.length; i++) {
			arr[i]= arr[i]/max*100;
			
			sum=sum+arr[i];
		}
		
		System.out.println(sum/arr.length);
		
	
	}

}
