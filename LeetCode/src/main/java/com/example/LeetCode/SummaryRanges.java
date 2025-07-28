package com.example.LeetCode;

import java.util.*;

public class SummaryRanges {
    public static List<String> solve(int[] nums) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < nums.length; ) {
            int start = i, end = i;
            while (end + 1 < nums.length && nums[end + 1] == nums[end] + 1) end++;
            if (start == end) res.add(String.valueOf(nums[start]));
            else res.add(nums[start] + "->" + nums[end]);
            i = end + 1;
        }
        return res;
    }
}
