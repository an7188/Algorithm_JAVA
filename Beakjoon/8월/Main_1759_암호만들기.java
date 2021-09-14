package day0824;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1759_암호만들기 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int L, C;
	static char arr[];
	static char box[];
	static int ja, mo;

	public static void main(String[] args) throws IOException {

		st = new StringTokenizer(br.readLine(), " ");

		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char[C]; // 문잘열 담는 배열
		box = new char[L]; // 문자열중 L개를 뽑아 담는 배열

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < C; i++) {
			arr[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(arr);
		// System.out.println(Arrays.toString(arr));

		pe(0, 0);

	}

	private static void pe(int cnt, int idx) {
		if (cnt == L) {

			ja = 0;
			mo = 0;
			for (int i = 0; i < L; i++) {
				if (box[i] == 'a' || box[i] == 'e' || box[i] == 'i' || box[i] == 'o' || box[i] == 'u') {

					mo++;
					// System.out.println(mo);
				} else
					ja++;
				// System.out.println(ja);

			}

			if (mo >= 1 && ja >= 2) {

				for (int i = 0; i < L; i++) {
					System.out.print(box[i]);

				}
				System.out.println();

			}

			return;
		}

		for (int i = idx; i < C; i++) {
			box[cnt] = arr[i];

			pe(cnt + 1, i + 1);
		}

	}

}
