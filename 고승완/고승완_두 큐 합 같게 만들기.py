from collections import deque

def process(bigQueue, smallQueue, bigSum, smallSum):
    num = bigQueue.popleft()
    smallQueue.append(num)
    return (bigSum - num), (smallSum + num)

def solution(queue1, queue2):
    limit = len(queue1) * 2 + 2
    
    dq1 = deque(queue1)
    dq2 = deque(queue2)
    sum1 = sum(dq1)
    sum2 = sum(dq2)
    
    if (sum1 + sum2) % 2 == 1:
        return -1
    
    answer = 0
    while sum1 != sum2:
        if answer >= limit:
            return -1
        
        if sum1 > sum2:
            sum1, sum2 = process(dq1, dq2, sum1, sum2)
        else:
            sum2, sum1 = process(dq2, dq1, sum2, sum1)
        answer += 1
    
    return answer
