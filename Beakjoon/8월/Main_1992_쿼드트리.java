package day0815;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

//쿼드트리
public class Main_1992_쿼드트리 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static String Q;
	static char[][] map;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {

		N = Integer.parseInt(br.readLine());
		map = new char[N][N];

		for (int i = 0; i < N; i++) {
			Q = br.readLine(); // 여기서 문자열 한줄을 받아와서
			map[i] = Q.toCharArray();
		}

//		 for (int i = 0; i < N; i++) {
//			 for (int j = 0; j < N; j++) {
//				System.out.print(map[i][j]);
//			}
//			 System.out.println();
//		}

		nanu(0, 0, N);

		 System.out.println(sb.toString());
	}

	private static void nanu(int r, int c, int n) {

		if (check(r, c, n)) {
			sb.append(map[r][c]);
			return;
		} else {
			sb.append("(");
			int na = n / 2;
			nanu(r, c, na);
			nanu(r, c + na, na);
			nanu(r + na, c, na);
			nanu(r + na, c + na, na);
			sb.append(")");
		}
	}

	private static boolean check(int r, int c, int n2) {

		for (int i = r; i < r+n2; i++) {
			for (int j = c; j < c+n2; j++) {
				if (map[r][c] != map[i][j])
					return false;

			}
		}
		return true;
	}

}
