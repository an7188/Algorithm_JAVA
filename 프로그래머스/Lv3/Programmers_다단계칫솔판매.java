package mon7;

import java.util.*;
class Solution {
    static Map<String,String> parent;
    static Map<String,Integer> result;
    static int[] answer;
    static int[] copy;
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        answer = new int[enroll.length];

        parent = new HashMap<>();
        result = new HashMap<>();
        for(int i=0 ; i<enroll.length ;i++){
            //키에는 자기 자신 값에는 부모 저장하기
            parent.put(enroll[i],referral[i]);
            result.put(enroll[i],i);
        }


        for(int i=0 ; i<seller.length ; i++){
            copy = new int[enroll.length];
            int sell = amount[i] * 100;
            find(seller[i],sell);
            System.out.println();
        }



        return answer;
    }

    static void find(String na , int sell){
        int Commission = sell / 10;  // 수수료
        int profit = sell - Commission; // 이익
        // sell이 0일때 계속 계산해줘서 시간초과! 문제 잘보기!!
        if(parent.get(na).equals("-") || sell ==0){
            answer[result.get(na)]+=profit;
            // System.out.println(na+" "+answer[result.get(na)]);
            return;
        }
        answer[result.get(na)]+=profit;
        // answer[result.get(parent.get(na))]+=Commission;
        // System.out.println(na+" "+answer[result.get(na)]+" "+parent.get(na)+" "+answer[result.get(parent.get(na))]);
        find(parent.get(na),Commission);

    }
}