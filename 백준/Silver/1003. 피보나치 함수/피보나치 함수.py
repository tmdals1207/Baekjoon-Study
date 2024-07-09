def fibonacci_dp(num):
    cnt_0 = [1, 0]
    cnt_1 = [0, 1]
    if num == 0:
        return cnt_0[0], cnt_0[1]
    elif num == 1:
        return cnt_1[0], cnt_1[1]
    for i in range(2, num + 1):
        cnt_0.append(cnt_0[i - 1] + cnt_0[i - 2])
        cnt_1.append(cnt_1[i - 1] + cnt_1[i - 2]) 
    return cnt_0[num], cnt_1[num]
n = int(input())
for _ in range(n):
    num = int(input())
    cnt_0, cnt_1 = fibonacci_dp(num)
    print(cnt_0, cnt_1)