import java.util.*;

//프로그래머스_오픈채팅방
//https://school.programmers.co.kr/learn/courses/30/lessons/42888
class Solution {
    public String[] solution(String[] record) {

        //채팅을 담을 배열 list
        ArrayList<String> chat = new ArrayList<>();
        //userId와 닉네임을 담을 hashmap
        HashMap<String, String> nickMap = new HashMap<>();
        
        for(String msg : record){
            StringTokenizer st = new StringTokenizer(msg);
            String command = st.nextToken();
            String userId = st.nextToken();
            String nickname = "";
            
            //leave인 경우는 닉네임 x
            if(!command.equals("Leave")) nickname = st.nextToken();
            
            switch(command){
                case "Enter":
                    nickMap.put(userId, nickname);
                    chat.add(userId + "님이 들어왔습니다.");
                    break;
                case "Leave":
                    chat.add(userId + "님이 나갔습니다.");
                    break;
                case "Change":
                    nickMap.put(userId, nickname);
                    break;
            }
        }
        
        String[] answer = new String[chat.size()];
        int idx = 0;
        
        for(String str : chat){
            int endOfId = str.indexOf("님");
            String id = str.substring(0, endOfId); // 채팅에서 아이디 부분
            answer[idx++] = str.replace(id, nickMap.get(id)); // 닉네임으로 교체
        }
        
        return answer;
    }
}
