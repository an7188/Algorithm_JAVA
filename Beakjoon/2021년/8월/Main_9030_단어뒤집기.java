package day0828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_9030_단어뒤집기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		 Stack<Character> st = new Stack<>();
		int T= Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			StringBuilder sb = new StringBuilder();
			String ch = br.readLine();
			
			for (int i = 0; i < ch.length(); i++) {
				if (ch.charAt(i)!=' ') { // 공백을 뺴고 스택에 집어넣음..
					
					st.push(ch.charAt(i));
				}
				if (ch.charAt(i)==' ') { // 공백을 만났을때 pop함
					while(!st.isEmpty()) {
						sb.append(st.pop()); 
					}
					sb.append(' '); //공백을 빼고 넣어서 다시 넣어줌
				}
			}
			
			while(!st.isEmpty()) {
				sb.append(st.pop());
			}
			
			
			
			System.out.println(sb.toString());
			
			
			
			
			
			
		}
	}

}
