package day0806;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_2493_탑 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		Stack<Tower> stack = new Stack<>();

		StringTokenizer st = new StringTokenizer(br.readLine()); // 탑의 높이가 공백으로 구분되어 입력됨

		for (int n = 1; n <= N; n++) {
			int height = Integer.parseInt(st.nextToken()); // 지금 입장하는 탑이 높이

			while (!stack.isEmpty() && stack.peek().height <= height) {

				stack.pop();

			}
			if (stack.isEmpty()) {
				sb.append("0");
				sb.append(" ");
			} else
				sb.append(stack.peek().num + " ");

			stack.push(new Tower(height, n));

		}

		System.out.println(sb.toString());

	}

	static class Tower {
		int height; // 탑의 높이
		int num;// 탑의 번호

		Tower(int h, int n) {
			height = h;
			num = n;
		}
	}
}
