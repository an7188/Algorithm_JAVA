package day0824;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_2810_컵홀더 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		Queue<Character> qu = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		String seat = br.readLine();

		int cnt = 1;
		int person = 0;
		for (int i = 0; i < seat.length(); i++) {
			qu.add(seat.charAt(i));
			// System.out.println(seat.charAt(i));
		}

		while (!qu.isEmpty()) {

			if (qu.peek() == 'S') {
				qu.poll();
				cnt += 1;
				person++;

			} else if (qu.peek() == 'L') {
				qu.poll();
				qu.poll();

				cnt += 1;
				person += 2;
			}
		}

		if (cnt <= person) {
			System.out.println(cnt);
		} else if (cnt > person) {
			System.out.println(person);
		}

	}

}
