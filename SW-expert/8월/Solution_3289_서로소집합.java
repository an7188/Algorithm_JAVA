package day0824;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_3289_서로소집합 {

	static Scanner sc = new Scanner(System.in);
	static StringBuilder sb;
	static int TC, n, m; // 테케와 점접과 간선
	static int yi, a, b;
	static int[] parent; // 부모 배열

	public static void main(String[] args) {

		TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) { // 테스트 케이스
			sb = new StringBuilder();
			sb.append("#" + tc + " ");
			n = sc.nextInt();
			m = sc.nextInt();
			parent = new int[n + 1];

			// Make set
			for (int i = 1; i < n + 1; i++) {
				parent[i] = i;
			}

			for (int i = 0; i < m; i++) {
				yi = sc.nextInt();
				a = sc.nextInt();
				b = sc.nextInt();

				if (yi == 0) { // 앞에가 0이면 union으로 합집합 연산

					Union(a, b);

				} else if (yi == 1) { // 앞이 1이면 어떤 집합에 속해있는지 findSet으로 판단
					if (findSet(a) == findSet(b)) // 같은 부모가 있는지 확인
						sb.append("1"); // 같은 부모가 있으면 1
					else
						sb.append("0"); // 같은 부모를 갖고 있지 않으면 2
				}

			}

			System.out.println(sb.toString());
		}

	}

	// FindSet
	private static int findSet(int x) {
		if (parent[x] == x) {
			return x;
		}
		return parent[x] = findSet(parent[x]);

	}

	// Union
	private static void Union(int a, int b) {
		int a2 = findSet(a);
		int b2 = findSet(b);

		if (a2 != b2) {
			if (a2 < b2)
				parent[b2] = a2;

		}

	}

}
