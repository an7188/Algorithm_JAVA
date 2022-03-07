import java.util.Scanner;

public class Main_2231_분해합 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int num = N;
		int result = Integer.MAX_VALUE;
		while (num > 0) {
			num = num - 1;
			int sum = num;
			String st = Integer.toString(num);

			for (int i = 0; i < st.length(); i++) {
				sum += st.charAt(i) - '0';
			}
//			System.out.println(sum);

			if (sum == N && result > num) {
				result = num;
			}

		}

		if (result == Integer.MAX_VALUE) {
			System.out.println(0);
		} else {
			System.out.println(result);
		}
	}

}