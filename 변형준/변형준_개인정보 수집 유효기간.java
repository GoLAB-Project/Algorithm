import java.util.*;

class Solution {
    public int getDays(String date){
        StringTokenizer st = new StringTokenizer(date,".");
        int year = Integer.parseInt(st.nextToken());
        int month = Integer.parseInt(st.nextToken());
        int day = Integer.parseInt(st.nextToken());
        int days = (year-1)*12*28 + (month-1)*28 + day;
        return days;
    }
    
    public int[] solution(String today, String[] terms, String[] privacies) {
        //today
        int days = getDays(today);
        StringTokenizer st;

        //약관
        Map<String, Integer> termsMap = new HashMap<>();
        for(int i=0;i<terms.length;i++){
            st = new StringTokenizer(terms[i]);
            termsMap.put(st.nextToken(), Integer.parseInt(st.nextToken())*28); //key : 약관종류, value : 개월 수 * 28일
        }

        //유효기간
        ArrayList<Integer> answerList = new ArrayList<>();
        int cnt = 1;
        for(String privacy:privacies){
            st = new StringTokenizer(privacy," ");
            int edays = getDays(st.nextToken());
            if(days-edays >= termsMap.get(st.nextToken())) answerList.add(cnt);
            cnt++;
        }
        
        //answer
        int[] answer = new int[answerList.size()];     
        
        for(int i=0; i<answerList.size();i++){
            answer[i] = answerList.get(i);
        }
        
        return answer;
    }
}
