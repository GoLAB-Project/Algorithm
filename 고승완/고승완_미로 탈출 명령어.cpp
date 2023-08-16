#include <string>
#include <cmath>

using namespace std;

const char s[4] = {'d', 'l', 'r', 'u'};
const int dx[4] = {+1, +0, +0, -1};
const int dy[4] = {+0, -1, +1, +0};

// 맨해튼 거리(1)
int getM(int x, int y, int r, int c) {
    return abs(r - x) + abs(c - y);
}

bool inRange(int x, int y, int r, int c) {
    return 0 < x && x <= r && 0 < y && y <= c;
}

string dfs(int n, int m, int x, int y, int r, int c, int k, int cnt, string ans) {
    if (x == r && y == c) {
        if ((k - cnt) % 2 == 1) return "impossible";  // 남은 거리에 도착지로 돌아올 수 없음
        if (cnt == k) return ans;
    }
    
    for (int i = 0; i < 4; ++i) {
        int nx = x + dx[i];
        int ny = y + dy[i];
        
        if (!inRange(nx, ny, n, m)) continue;
        if (getM(nx, ny, r, c) + cnt + 1 > k) continue; // 갈 수 있는지 여부 확인(2)
        return dfs(n, m, nx, ny, r, c, k, cnt + 1, ans + s[i]);
    }
    
    return "impossible";
}

string solution(int n, int m, int x, int y, int r, int c, int k) {
    return dfs(n, m, x, y, r, c, k, 0, "");
}