package mon6;

import java.util.Arrays;

public class Programmers_정수삼각현 {
    public static void main(String[] args) {
        int[][] triangle ={{7}, {3, 8}, {8, 1, 0},{2, 7, 4, 4}, {4, 5, 2, 6, 5}};

        System.out.println(Solution(triangle));
    }

    private static int Solution(int[][] triangle) {
        int dp [][] = new int[triangle.length][triangle[triangle.length-1].length]; // 최대값만 저장하는 배열

        dp[0][0]= triangle[0][0];
        int max=0;
        for (int i = 0; i < triangle.length-1; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                int num = dp[i][j];
//                triangle[i+1][j]= Math.max(triangle[i+1][j],triangle[i+1][j]+num);
//                triangle[i+1][j+1]= Math.max(triangle[i+1][j+1],triangle[i+1][j+1]+num);

                dp[i+1][j]= Math.max(dp[i+1][j],triangle[i+1][j]+num); // 아래 왼쪽에 있는 칸 계산
                dp[i+1][j+1]= Math.max(dp[i+1][j+1],triangle[i+1][j+1]+num); // 아래 오른쪽에 있는 칸 계산

                max= Math.max(max,dp[i+1][j]);
                max= Math.max(max,dp[i+1][j+1]);
//                System.out.println(dp[i+1][j]+" "+dp[i+1][j+1]);

            }

        }

        for (int i = 0; i < triangle.length; i++) {

            System.out.println(Arrays.toString(dp[i]));
        }
        return max;
    }
}
