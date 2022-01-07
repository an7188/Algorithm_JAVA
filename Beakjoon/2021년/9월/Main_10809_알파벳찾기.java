package day0925;

import java.util.Arrays;
import java.util.Scanner;

public class Main_10809_알파벳찾기 {
	
	public static void main(String[] args) {
		
		char alp[]= {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		int arr[]= new int[26]; 
		Scanner sc= new Scanner(System.in);
		//System.out.println(Arrays.binarySearch(alp, 'c'));
		
		String st= sc.nextLine();
		
		for (int i = 0; i < arr.length; i++) {
			arr[i]= -1;
		}
		
		
		for (int i = 0; i < st.length(); i++) {
			//if(Arrays.binarySearch(alp, st.charAt(i))==-1)continue;
			if(arr[Arrays.binarySearch(alp, st.charAt(i))]>=0) continue;
			arr[Arrays.binarySearch(alp, st.charAt(i))]=i;
			
			
		}
		for (int i = 0; i < arr.length; i++) {

			System.out.print(arr[i]+" ");
		}
		
	}
}
