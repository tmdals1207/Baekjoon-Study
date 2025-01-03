def fibonacci(n):
    fib = [0] * (n + 1)
    fib[1] = 1
    if n > 1:
        fib[2] = 1
    for i in range(3, n + 1):
        fib[i] = fib[i - 1] + fib[i - 2]
    return fib


def can_partition(N):
    fib = fibonacci(N)
    total_sum = sum(fib[1:N + 1])

    if total_sum % 2 != 0:
        return "impossible"

    target = total_sum // 2
    A = []
    B = []
 
    for i in range(N, 0, -1):
        if target >= fib[i]:
            A.append(i)
            target -= fib[i]
        else:
            B.append(i)
 
    result = ['B'] * N
    for a in A:
        result[a - 1] = 'A'
 
    return ''.join(result)
 
T = int(input())
for _ in range(T):
    N = int(input())
    result = can_partition(N)
    print(result)