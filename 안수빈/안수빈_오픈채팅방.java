import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.ArrayList;

class Solution {
    public String[] solution(String[] record) {
        StringTokenizer st;
        Map<String,String> idMap = new HashMap<>(); //id-닉네임
        ArrayList<String> tempList = new ArrayList<>();
        
        for(int i=0;i<record.length;i++){
            st = new StringTokenizer(record[i]);
            String act = st.nextToken();
            String uid = st.nextToken();
            String nickname = "";
            
            //leave 일때는 nickname이 없다
            if(!act.equals("Leave")){
                nickname = st.nextToken();
            }
            
            switch(act){
                case "Enter":
                    idMap.put(uid,nickname);
                    tempList.add(uid+"님이 들어왔습니다.");
                    break;
                case "Change":
                    idMap.put(uid,nickname);
                    break;
                case "Leave":
                    tempList.add(uid+"님이 나갔습니다.");
                    break;
            }
        }
        
        //"문자열에 특정 문자 찾기" 검색해서 "indexOf" 찾아서 사용함
        
        String[] answer = new String[tempList.size()];
        int i=0;
        for(String str:tempList){
            String uid = str.substring(0,str.indexOf("님"));
            //uid부분을 닉네임으로 바꿔서 answer에 저장
            answer[i++] = str.replace(uid,idMap.get(uid));
        }
        return answer;
    }
}
