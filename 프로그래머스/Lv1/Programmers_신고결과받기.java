package day03;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Programers_신고결과받기 {

	public static void main(String[] args) {
		String[] id_list = { "muzi", "frodo", "apeach", "neo" };
		String[] report = { "muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi" };

		int k = 2;

		int[] answer = solution(id_list, report, k);
		System.out.println(Arrays.toString(answer));
	}

	private static int[] solution(String[] id_list, String[] report, int k) {

		HashMap<String, Integer> eamil_list = new HashMap<>();
		HashMap<String, HashSet<String>> reported_list = new HashMap<>();

		for (int i = 0; i < id_list.length; i++) {
			eamil_list.put(id_list[i], 0);
			reported_list.put(id_list[i], new HashSet());
		}

		// 신고 받은 사람 카운트 하기
		for (int i = 0; i < report.length; i++) {
			StringTokenizer st = new StringTokenizer(report[i], " ");
			String reporter = st.nextToken(); // 신고자
			String reported = st.nextToken(); // 신고 당한 사람

			// 신고 당한 사람 뒤에 신고자들 줄 세우기
			reported_list.get(reported).add(reporter);

		}

		for (String key : reported_list.keySet()) {
			// 나를 신고한 사람들을 email hashse에다가 넣기
			HashSet<String> email = reported_list.get(key);

			// 나를 신고한 사람의 수가 k이상이면
			if (email.size() >= k) {
				// 신고자 순서대로
				for (String string : email) {
					// 이메일 발송 email_list에 신고자에게 카운트
					eamil_list.put(string, eamil_list.get(string) + 1);
				}
			}
		}
		
		// 신고자 수와 같은 배열 만들어
		int arr[] = new int[id_list.length];
		for (int i = 0; i < arr.length; i++) {
			// 배열로 반환 할 수 있게 저장
			arr[i] = eamil_list.get(id_list[i]);
		}

		return arr;
	}

}
