package numerical.exchangeWithMinimumCoins;

import java.util.List;

public class ExchangeWithMinimumCoins {
    public static void exchangeWithMinimumCoins(
            List<Integer> coins, int cash) {
        int count = 0;
        for (int i = coins.size() - 1; i >= 0; i--) {
            count += cash / coins.get(i);
            cash = cash % coins.get(i);
        }
        System.out.println(count);
    }

}