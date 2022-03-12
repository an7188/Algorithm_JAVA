
public class programmers_신규아이디추천 {

	public static void main(String[] args) {

		String new_id = "...!@BaT#*..y.abcdefghijklm";
		System.out.println(Solution(new_id));
		 new_id = "z-+.^.";
		System.out.println(Solution(new_id));
		 new_id = "=.=";
		System.out.println(Solution(new_id));
		  new_id = "123_.def";
		System.out.println(Solution(new_id));
		 new_id = "abcdefghijklmn.p";
		System.out.println(Solution(new_id));
	}

	private static String Solution(String new_id) {

		String answer;

		// 1단계 : 대문자 -> 소문자 변경

		String st1 = new_id.toLowerCase();

//		System.out.println("1단계" + st1);
		// 2단계 : 소문자, 숫자, 빼기, 밑줄, 마침표를 제외한 문자 제거
		char arr2[] = st1.toCharArray();
		StringBuilder sb2 = new StringBuilder();

		for (int i = 0; i < arr2.length; i++) {
			char aa = arr2[i];
			if ((aa >= 'a' && aa <= 'z') || (aa >= '0' && aa <= '9') || aa == '-' || aa == '_' || aa == '.') {
				sb2.append(aa);
			}
		}

		// 3단계 : 마침표가 2번 이상 연속된 부분을 하나로 치환
		String st3 = sb2.toString();
//		System.out.println("2단계" + st3);
		while (st3.contains("..")) {
			st3 = st3.replace("..", ".");
		}

//		System.out.println("3단계" + st3);

		// 4단계 : 마침표 위치 수정
		StringBuilder sb4 = new StringBuilder();
		if (st3.length() == 1 && st3.equals(".")) {
			sb4.append(" ");
		} else {
			if (st3.charAt(0) == '.') {

				for (int i = 1; i < st3.length(); i++) {
					sb4.append(st3.charAt(i));
				}
				
				if (st3.charAt(st3.length() - 1) == '.') {
					sb4.setLength(sb4.length()-1);
				}
			}else if(st3.charAt(st3.length()-1)=='.') {
				for (int i = 0; i < st3.length()-1; i++) {
					sb4.append(st3.charAt(i));
				}
			}
			 else {
				for (int i = 0; i < st3.length(); i++) {
					sb4.append(st3.charAt(i));
				}
			}
		}
		// 5단계 : 빈문자열이라면 a로 채우기
		String st5 = sb4.toString();
//		System.out.println("4단계" + st5);

		if (st5.equals(" ")) {
			st5 = "a";
		}
//		System.out.println("5단계" + st5);
		// 6단계 : 길이 제한(3이상 15이하)
		StringBuilder sb6 = new StringBuilder();

		if (st5.length() < 3) {
			int num = st5.length();

			for (int i = 0; i < st5.length(); i++) {
				sb6.append(st5.charAt(i));
			}

			int num2 = 3 - st5.length();
//			System.out.println(num2);
			for (int i = 0; i < num2; i++) {
				sb6.append(st5.charAt(num - 1));
			}

		} else if (st5.length() > 15) {
			for (int i = 0; i < 15; i++) {
				if (i == 14 && st5.charAt(i) == '.') {
					break;
				}
				sb6.append(st5.charAt(i));

			}

		} else {
			for (int i = 0; i < st5.length(); i++) {
				sb6.append(st5.charAt(i));

			}

		}

		answer = sb6.toString();

		return answer;

	}

}
