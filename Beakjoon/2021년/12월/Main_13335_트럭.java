package day1214;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_13335_트럭 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken()); // 트럭 개수
		int w = Integer.parseInt(st.nextToken()); // 다리 길이
		int l = Integer.parseInt(st.nextToken()); // 트럭 무게

		Queue<Integer> truck = new LinkedList<>();
		Queue<Integer> dari = new LinkedList<>();

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			truck.add(Integer.parseInt(st.nextToken()));
		}

		for (int i = 0; i < w; i++) { // 현재 다리길이만큼 0으로 채움
			dari.add(0);

		}

		int now = 0; // 현재 다리에 있는 무게
		int time = 0; // 시간
		while (!dari.isEmpty()) {
			time++;
			now -= dari.poll(); // 빠져나간 트럭의 무게를 뺀 현재무게

			if (!truck.isEmpty()) {
				if (now + truck.peek() <= l) {
					now += truck.peek(); // 최대 하중 무게보다 작으면 현재 무게에 더하기
					dari.add(truck.poll()); // 현재 다리에 트럭 보내기
				} else {
					dari.add(0); // 아니면 0으로 보내기
				}

			}

			// 보낼트럭이 없다면 나머지 다리에 있는 트럭 모두내보내고 끝내기

		}

		System.out.println(time);

	}

}
