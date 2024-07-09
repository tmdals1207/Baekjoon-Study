expression = input()
parts = expression.split('-')
initial_sum = sum(map(int, parts[0].split('+')))
subsequent_sums = [sum(map(int, part.split('+'))) for part in parts[1:]]
result = initial_sum - sum(subsequent_sums)
print(result)