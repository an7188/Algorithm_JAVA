package day0813;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;



public class Main_1158_요세푸스 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<Integer> q = new LinkedList<>(); //큐 선
		StringBuilder sb = new StringBuilder();
		
		
		int num = sc.nextInt();
		int N = sc.nextInt();
		int s= 1;
		
		for (int i = 1; i <=num; i++) {
			q.offer(i);
		}
		
		sb.append("<");
		
		
		
		while (q.size()!=1) {
			
			
			for (int i = 0; i < N-1; i++) {
				q.offer(q.poll());
			}
			sb.append(q.poll()+", ");
			
			
		}
		sb.append(q.poll()+">");
		
		
		
		System.out.print(sb.toString());
		
		
		
	}
	
	

}
