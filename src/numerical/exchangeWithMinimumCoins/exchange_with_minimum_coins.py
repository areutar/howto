def exchange_with_minimum_coins(coins, cash):
    count = 0
    for i in range(len(coins) - 1, - 1, -1):
        count += cash // coins[i]
        cash %= coins[i]
    print(count)
