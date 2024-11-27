word = input()
total = 0

for char in word:
    if char in 'ABC': total += 3
    elif char in 'DEF': total += 4
    elif char in 'GHI': total += 5
    elif char in 'JKL': total += 6
    elif char in 'MNO': total += 7
    elif char in 'PQRS': total += 8
    elif char in 'TUV': total += 9
    elif char in 'WXYZ': total += 10

print(total)