package day03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.StringTokenizer;

public class Programmers_오픈채팅방 {

	public static void main(String[] args) {

		String record[] = { "Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo",
				"Change uid4567 Ryan" };

		Solution(record);
	}

	private static void Solution(String[] record) {
		ArrayList<String> Action = new ArrayList<>();
		ArrayList<String> ID = new ArrayList<>();
		Map<String, String> user = new HashMap<String, String>();

		for (int i = 0; i < record.length; i++) {
			StringTokenizer st = new StringTokenizer(record[i], " ");
			if (st.countTokens() == 2) { // 채팅방을 떠나는 경우
				String action = st.nextToken();
				String id = st.nextToken();
//				System.out.println(action+ " "+id);
				Action.add(action);
				ID.add(id);
				
				
			} else { // 닉넴임을 바꾸거나 들어온 경우
				String action = st.nextToken();
				String id = st.nextToken();
				String nickname = st.nextToken();
//				System.out.println(action+ " "+id+" "+nickname);

				if (action.equals("Enter")) {
					Action.add(action);
					ID.add(id);
					user.put(id, nickname);

				} else if (action.equals("Change")) {
					user.put(id, nickname);
				}

			}

		}

		String[] answer = new String[Action.size()];
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < ID.size(); i++) {
			if(Action.get(i).equals("Enter")) {
				answer[i]= user.get(ID.get(i))+"님이 들어왔습니다.";
//				sb.append(user.get(ID.get(i))+"님이 들어왔습니다.");
			}else {
				answer[i]= user.get(ID.get(i))+"님이 나갔습니다.";
			}
		}
		
		System.out.println(Arrays.toString(answer));

	}

}
