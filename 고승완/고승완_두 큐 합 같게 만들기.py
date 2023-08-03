from collections import deque


def process(bigQueue, smallQueue, bigSum, smallSum):
    num = bigQueue.popleft()
    smallQueue.append(num)
    return (bigSum - num), (smallSum + num)


def solution(queue1, queue2):
    l = len(queue1)

    dq1 = deque()
    dq2 = deque()
    sum1 = 0
    sum2 = 0

    for i in range(l):
        dq1.append(queue1[i])
        sum1 += queue1[i]
        dq2.append(queue2[i])
        sum2 += queue2[i]

    if (sum1 + sum2) % 2 == 1:
        return -1

    answer = 0
    while sum1 != sum2:
        if sum1 > sum2:
            sum1, sum2 = process(dq1, dq2, sum1, sum2)
        else:
            sum2, sum1 = process(dq2, dq1, sum2, sum1)
        answer += 1

        if answer > l * 3:
            return -1

    return answer
