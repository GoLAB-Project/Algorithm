import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};
        int tdate = getDate(today); //오늘 날짜
        StringTokenizer st;
        Map<String, Integer> map = new HashMap<>(); //약관 이름, 기간
        
        for(String t:terms){ //약관들 map에 넣기
            st = new StringTokenizer(t);
            map.put(st.nextToken(), Integer.parseInt(st.nextToken()) * 28);
        }
        
        ArrayList<Integer> tempList = new ArrayList<>();
        for(int i =0;i<privacies.length;i++){
            st = new StringTokenizer(privacies[i]," ");
            int pdate = getDate(st.nextToken());
            if(pdate + (map.get(st.nextToken()))<= tdate) {
                tempList.add(i+1);
            }
        }
        
        answer = new int[tempList.size()];
        for(int i=0;i<tempList.size();i++){
            answer[i] = tempList.get(i);
        }
        
        return answer;
    }
    
    public int getDate(String date){
        StringTokenizer st = new StringTokenizer(date,".");
        int year = Integer.parseInt(st.nextToken());
        int month = Integer.parseInt(st.nextToken());
        int day = Integer.parseInt(st.nextToken());
        
        return (year * 12 * 28) + (month*28)+day;
    }
}
