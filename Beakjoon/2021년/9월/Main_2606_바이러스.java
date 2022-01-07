package day1009;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2606_바이러스 {
	static StringTokenizer st;
	static int com, connect;
	static int map[][];
	static int result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		com = Integer.parseInt(br.readLine());
		connect = Integer.parseInt(br.readLine());
		map = new int[com + 1][com + 1];

		for (int i = 0; i < connect; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			map[r][c] = 1;
			map[c][r] = 1;
			
		}

		
		result=0;
		bfs();
		System.out.println(result);
	}

	static void bfs() {
		Queue<Integer> qu = new LinkedList<>();

		qu.add(1);
		boolean check[] = new boolean[com + 1];	
		check[1]=true;
		while (!qu.isEmpty()) {
			int X = qu.poll();

			for (int i = 1; i < com + 1; i++) {

				if (map[X][i] == 1 && !check[i]) {
					qu.add(i);
					check[i] = true;
					result++;
				}
			}

		}

	}

}
