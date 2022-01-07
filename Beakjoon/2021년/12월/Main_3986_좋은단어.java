package day1214;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_3986_좋은단어 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int c = 0;
		int cnt=0;
		while (c < N) {
			Stack<Character> st = new Stack<>();
			Stack<Character> st2 = new Stack<>();
			
			String string = br.readLine();
			
			for (int i = 0; i < string.length(); i++) {
				st.add(string.charAt(i));
				
			}
			
			st2.push(st.pop());
			while(!st.isEmpty()) {
				
				if(st2.isEmpty()) {
					st2.push(st.pop());
				}
				
				if(st.isEmpty()) {
					break;
				}
			
				if( st.peek()==st2.peek()) {
					st.pop();
					st2.pop();
				}else {
					st2.push(st.pop());
				}
				
			}
			
			if(st2.isEmpty()) {
				
				cnt++;
			}
			c++;
		}
		System.out.println(cnt);
	}

}
