package day1209;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_11866_요세푸스 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Queue<Integer> qu = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		
		int N = sc.nextInt();
		int K = sc.nextInt();

		sb.append("<");
		
		for (int i = 1; i <= N; i++) {
			qu.add(i);
		}
		
		int cnt=1;
		while(!qu.isEmpty()) {
			
			if(cnt%K==0) {
			
				sb.append(qu.poll());
				sb.append(", ");
				cnt++;
				continue;
			}
			
			qu.add(qu.poll());
			cnt++;
			
		}
		sb.setLength(sb.length() - 2);
		sb.append(">");
		
		System.out.println(sb.toString());
	}

}
