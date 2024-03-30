package 알고리즘연습.leetcode;

import java.util.Arrays;

public class LeetCode_2962 { // Count Subarrays Where Max Element Appears at Least K Times
    public long countSubarrays(int[] nums, int k) {
        int maxVal = Arrays.stream(nums).max().getAsInt();

        int left = 0;
        int right = 0;
        int count = 0;
        long ans = 0;
        while (right < nums.length || left > right) {
            if (nums[right] == maxVal) {
                count++;
            }
            while (count >= k) {
                ans += nums.length - right;
                if (nums[left] == maxVal) {
                    count--;
                }
                left++;
            }
            right++;
        }
        return ans;
    }
}
