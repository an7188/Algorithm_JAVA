import java.util.Arrays;

public class Programmers_1차비밀지도 {


    public static void main(String[] args) {
        int n=5;
        int[] arr1={9, 20, 28, 18, 11};
        int[] arr2={30, 1, 21, 17, 28};

        System.out.println(Solution(n,arr1,arr2));
    }

    private static String[] Solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for (int i = 0; i < arr1.length; i++) {

            String num = Integer.toBinaryString(arr1[i]);
            String num2 = Integer.toBinaryString(arr2[i]);

            char numa1[] = new char[n];
            char numa2[] = new char[n];

            while(num.length() < n){ // 주어진 n보다 작으면 앞에 0채우기!

                num = "0" + num;

            }
            numa1= num.toCharArray();

            while(num2.length() < n){

                num2 = "0" + num2;

            }

            numa2 = num2.toCharArray();

            String result ="";
            for (int j = 0; j <n ; j++) {
                if(numa1[j]=='1'|| numa2[j]=='1'){ // 둘중에 하나만이라도 1이면 # 넣기
                    result+='#';
                }else if(numa1[j]=='0' && numa2[j]=='0'){
                  result+=' ';
                }

                }

                answer[i]=result;





        }  System.out.println(Arrays.toString(answer));

        return answer;
    }
}
