def getDestroyDate(date, vaild):
    year, month, day = date
    
    if day == 1:
        if month == 1:
            year -= 1
            month = 12
        else:
            month -= 1
        day = 28
    else:
        day -= 1

    month += vaild
    if month > 12:
        year += (month // 12)
        month %= 12
        if month == 0:
            year -= 1
            month = 12
    
    return [year, month, day]
        
def solution(today, terms, privacies):
    today = list(map(int, today.split(".")))

    vaildMonth = {}
    for term in terms:
        kind, vaild = term.split()
        vaildMonth[kind] = int(vaild)
    
    answer = []
    for i in range(len(privacies)):
        privacy = privacies[i].split()
        
        date = list(map(int, privacy[0].split(".")))
        kind = privacy[1]
        
        if today <= getDestroyDate(date, vaildMonth[kind]): continue
        answer.append(i + 1)

    return answer

''' 기존 풀이법
def cmpDate(day1, day2):
    if day1[0] < day2[0]:
        return True
    elif day1[0] == day2[0]:
        if(day1[1] < day2[1]):
            return True
        elif day1[1] == day2[1]:
            if(day1[2] <= day2[2]):
                return True
            else:
                return False
        else:
            return False
    else:
        return False
    
def calcDate(inDay, inMonth):
    year, month, day = inDay
    
    day -= 1
    if day == 0:
        day = 28
        month -= 1
    if month == 0:
        year -= 1
        month = 12
        
    month += inMonth
    if month > 12:
        year += month // 12
        month %= 12
    if month == 0:
        year -= 1
        month = 12
    
    return [year, month, day]

def solution(today, terms, privacies):
    answer = []
    
    today = list(map(int, today.split('.')))
    customTerms = {}
    for t in terms:
        t = list(t.split(' '))
        customTerms[t[0]] = int(t[1])
    
    customPrivacies = []
    for p in privacies:
        p = list(map(str, p.split(' ')))
        customPrivacies.append([list(map(int, p[0].split('.'))), p[1]])
    
    for i in range(len(customPrivacies)):
        p = customPrivacies[i]
        convDate = calcDate(p[0], customTerms[p[1]])
        print(convDate)
        if not cmpDate(today, convDate):
            answer.append(i+1)
    
    
    return answer
'''