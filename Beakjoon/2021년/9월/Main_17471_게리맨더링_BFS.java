package day1006;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17471_게리맨더링_BFS {

	static StringTokenizer st;
	static int N;
	static int people[], map[][];
	static boolean isSelected[];
	static int min;
	static int area1, area2;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		people = new int[N + 1]; // 인구 수 저장 배열

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i < N + 1; i++) {
			people[i] = Integer.parseInt(st.nextToken());

		} // 인구 수 입력 끝

		map = new int[N + 1][N + 1];

		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int con = Integer.parseInt(st.nextToken()); // 인접한 구역 수 입력
			for (int j = 1; j <= con; j++) {
				map[i][Integer.parseInt(st.nextToken())]++;

			}
		}
		min = Integer.MAX_VALUE;
		isSelected = new boolean[N + 1];
		pick(1);

		if (min == Integer.MAX_VALUE)// 최소 값이 초기값인경우 -1 출력 아니면 min 출력 
			System.out.println("-1");
		else
			System.out.println(min);

	}

	// 부분집합으로 구역 뽑는 메소드
	static void pick(int cnt) {
		area1 = 0;
		area2 = 0;

		if (cnt == N) {
			for (int i = 1; i < N + 1; i++) {
				if (isSelected[i]) {
					area1 = i;
					break;
				}
			}
			for (int i = 1; i < N + 1; i++) {
				if (!isSelected[i]) {
					area2 = i;
					break;
				}
			}

			if (check()) {
				peopleNum();
			}

			return;
		}
		isSelected[cnt] = true;
		pick(cnt + 1);

		isSelected[cnt] = false;
		pick(cnt + 1);
	}

	// 부분집합으로 뽑힌 구역이 이어져 있는지 확인하는 메소드
	static boolean check() {
		Queue<Integer> qu = new LinkedList<>();
		boolean visited[] = new boolean[N + 1];
		if (area1 == 0 || area2 == 0) {
			return false;
		}

		qu.add(area1); // 구역1의 bfs 
		visited[area1] = true;
		while (!qu.isEmpty()) {
			int x = qu.poll();

			for (int i = 1; i < N + 1; i++) {
				if (map[x][i] == 1 && !visited[i] && isSelected[i]) {
					visited[i] = true;
					qu.add(i);
				}
			}

		}

		qu.add(area2); //구역 2의 bfs
		visited[area2] = true;
		while (!qu.isEmpty()) {
			int x = qu.poll();

			for (int i = 1; i < N + 1; i++) {
				if (map[x][i] == 1 && !visited[i] && !isSelected[i]) {
					visited[i] = true;
					qu.add(i);
				}
			}

		}

		for (int i = 1; i < N + 1; i++) {
			if (!visited[i])
				return false;

		}
		return true;

	}

	
	// 정상적으로 나누어진 구역의 인구 차 구하는 메소드 
	private static void peopleNum() {
		int sum1 = 0;
		int sum2 = 0;
		for (int i = 1; i < N + 1; i++) {
			if (isSelected[i])
				sum1 += people[i];
			else
				sum2 += people[i];

		}

		min = Math.min(min, Math.abs(sum1 - sum2));

	}
}
