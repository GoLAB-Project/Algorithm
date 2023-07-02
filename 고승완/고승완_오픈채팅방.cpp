#include <string>
#include <sstream>
#include <vector>
#include <map>
using namespace std;

typedef pair<string, int> psi; // <ID, in(0)/out(1)>

map<string, string> idToNickname;
vector<psi> output;
char* notices[2] = {"님이 들어왔습니다.", "님이 나갔습니다."};

vector<string> solution(vector<string> record) {
    vector<string> answer;
    
    // record 파싱
    for(auto rec : record) {
        stringstream ss(rec);
        string inout, id, nickname;
        
        if(rec[0] == 'L') {
            ss >> inout >> id;
            output.push_back(psi(id, 1));
            continue;
        }
        
        // Enter or Change
        ss >> inout >> id >> nickname;
        idToNickname[id] = nickname; // 삽입 or 수정
        if(inout == "Enter") output.push_back(psi(id, 0));
    }
    
    // 출력 생성
    for(auto out : output) {
        string ans = idToNickname[out.first] + notices[out.second];
        answer.push_back(ans);
    }
    
    return answer;
}