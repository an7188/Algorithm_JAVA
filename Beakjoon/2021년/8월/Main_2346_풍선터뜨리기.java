package day0819;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main_2346_풍선터뜨리기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Deque<Integer> de = new ArrayDeque<>();
		Deque<Integer> de2 = new ArrayDeque<>();
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();

		for (int i = 1; i < N + 1; i++) {
			de.add(sc.nextInt());
			de2.add(i);
		}
		int num = de.pollFirst();
		sb.append(de2.pollFirst());
		sb.append(" ");
		while (!de.isEmpty()) {

			if (num > 0) {
				for (int i = 0; i < num - 1; i++) {
					de.addLast(de.pollFirst());
					de2.addLast(de2.pollFirst());
				}
				num = de.pollFirst();
				sb.append(de2.pollFirst());
				sb.append(" ");
				continue;

			} else if (num < 0) {
				for (int i = 0; i < Math.abs(num) - 1; i++) {
					// System.out.println(Math.abs(num) - 1);
					de.addFirst(de.pollLast());
					de2.addFirst(de2.pollLast());
				}
				num = de.pollLast();
				sb.append(de2.pollLast());
				sb.append(" ");
			}
			continue;
		}
		System.out.println(sb);
	}

}
