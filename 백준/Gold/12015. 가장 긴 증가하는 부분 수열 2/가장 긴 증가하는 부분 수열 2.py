from bisect import bisect_left

def longest_increasing_subsequence(arr):
    if not arr:
        return 0

    lis = []

    for num in arr:

        pos = bisect_left(lis, num)
        if pos == len(lis):
            lis.append(num)
        else:
            lis[pos] = num

    return len(lis)

n = int(input())
arr = [int(x) for x in input().split()]

result = longest_increasing_subsequence(arr)

print(result)