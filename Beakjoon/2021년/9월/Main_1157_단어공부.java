package day0925;

import java.util.Scanner;

public class Main_1157_단어공부 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int []arr= new int[26]; //알파벳 배열
		
		
		String st= sc.next().toUpperCase(); //대문자로 입력 
		
		int max =-1;
		char a = ' ';
		
		for (int i = 0; i < st.length(); i++) {
			arr[st.charAt(i)-65]++;
			if (max<arr[st.charAt(i)-65]) {
				max=arr[st.charAt(i)-65];
				a=st.charAt(i);
			}
			else if(max==arr[st.charAt(i)-65]) a='?';
		}
		
		System.out.println(a);
	}

}
