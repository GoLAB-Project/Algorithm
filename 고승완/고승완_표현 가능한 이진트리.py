# 프로그래머스: 표현 가능한 이진트리(Level 3), https://school.programmers.co.kr/learn/courses/30/lessons/150367

# 2진수의 길이를 '2의 제곱 - 1'으로 맞추도록 앞에 더미 숫자를 추가해주는 함수
def setDummyNode(binary):
    lenOfBinary = len(binary)
    powNumber = 2
    
    while lenOfBinary >= powNumber: # 2. 이걸 >에서 >=로 바꾸고 통과
        powNumber *= 2
    
    return '0' * ((powNumber - 1) - lenOfBinary) + binary

# 주어진 10진수 숫자를 2진수로 변환하는 함수
def dex2Binary(dex):
    binary = []
    
    while dex:
        binary.append(str(dex % 2))
        dex //= 2
    binary.reverse() # 1. 이걸 안해줘서 1시간 날림
    
    return setDummyNode("".join(binary))

# 트리를 중위 순회하는 함수
def inOrderTraversal(binaryNumber):
    length = len(binaryNumber)
    if not length:
        return # 파이썬에서는 None을 반환함
    
    mid = length // 2
    
    if binaryNumber[mid] == '1': # 부모 노드가 더미 노드가 아닐 경우
        left = inOrderTraversal(binaryNumber[:mid]) # 왼쪽 자식 트리에 대한 중위 순회
        right = inOrderTraversal(binaryNumber[mid + 1:]) # 오른쪽 자식 트리에 대한 중위 순회

        # 두 자식 트리 중 부모 노드가 더미 노드이거나, 한 개의 이진 트리로 만들 수 없는 경우
        if left == False or right == False:
            return False
        else:
            return True
    else: # 부모 노드가 더미 노드일 경우
        # 자식 노드들이 모두 더미 노드인지 확인
        subTree = 0 if binaryNumber[:] == '' else int(binaryNumber[:])
        return True if subTree == 0 else False

def solution(numbers):
    answer = []
    
    for number in numbers:
        binaryNumber = dex2Binary(number)
        answer.append(1 if inOrderTraversal(binaryNumber) else 0)
    
    return answer
