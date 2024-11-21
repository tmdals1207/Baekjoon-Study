def maximize_prize(cards, swap_count):
    max_value = 0
    n = len(cards)
    visited = set()

    def dfs(depth):
        nonlocal max_value
        if depth == swap_count:
            max_value = max(max_value, int("".join(cards)))
            return

        for i in range(n):
            for j in range(i + 1, n):
                cards[i], cards[j] = cards[j], cards[i]
                state = (tuple(cards), depth + 1)
                if state not in visited:
                    visited.add(state)
                    dfs(depth + 1)
                cards[i], cards[j] = cards[j], cards[i]

    dfs(0)
    return max_value


T = int(input())
for t in range(1, T + 1):
    number, k = input().split()
    k = int(k)
    cards = list(number)
    result = maximize_prize(cards, k)
    print(f"#{t} {result}")