package com.example.LeetCode;

public class BestTimeToBuyStock {
    public static int solve(int[] prices) {
        int min = Integer.MAX_VALUE, profit = 0;
        for (int p : prices) {
            if (p < min) min = p;
            else profit = Math.max(profit, p - min);
        }
        return profit;
    }
}
