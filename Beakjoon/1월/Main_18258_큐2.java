import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_18258_큐2 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		Queue<Integer> qu = new LinkedList<>();

		int last = 0; // 마지막 숫자 넣을 변
		int N = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < N; tc++) {

			st = new StringTokenizer(br.readLine(), " ");
			String ss = st.nextToken();

			////////// push인경우////////////
			if (ss.equals("push")) {
				int in = Integer.parseInt(st.nextToken());
				qu.add(in);
				last=in;
			}

			////////// pop인경우////////////
			else if (ss.equals("pop")) {
				if (qu.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(qu.poll());
				}
			}

			////////// size인경우////////////
			else if (ss.equals("size")) {
				System.out.println(qu.size());

			}

			////////// empty인경우////////////
			else if (ss.equals("empty")) {
				if (qu.isEmpty()) {
					System.out.println(1);
				} else {
					System.out.println(0);
				}

			}

			////////// front인경우////////////
			else if (ss.equals("front")) {
				if (!qu.isEmpty()) {
					System.out.println(qu.peek());
				} else {
					System.out.println(-1);
				}
			}

			////////// back인경우////////////
			else if (ss.equals("back")) {
				if (!qu.isEmpty()) {
					System.out.println(last);
				} else {
					System.out.println(-1);
				}
			}
		}
	}

}
