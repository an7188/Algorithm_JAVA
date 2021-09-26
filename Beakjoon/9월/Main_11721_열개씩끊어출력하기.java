package day0925;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_11721_열개씩끊어출력하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String st= br.readLine();
		
		for (int i = 1; i <= st.length(); i++) {
			if (i%10==0) {
				System.out.println(st.charAt(i-1));
			}
			
			else System.out.print(st.charAt(i-1));
		}
	}

}
