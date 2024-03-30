package 알고리즘연습.leetcode;

import java.util.HashMap;

public class LeetCode_992 {
    public int subarraysWithKDistinct(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0, left = 0, right = 0;

        while (right < nums.length) {
            while (map.size() < k && right < nums.length) {
                map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
                right++;
            }
            // if distinct elements count == k : (below)
            int maxEnd = right;
            while (maxEnd < nums.length && map.getOrDefault(nums[maxEnd], 0) != 0) {
                maxEnd++;
            }
            while (map.size() == k) {
                ans += maxEnd - right + 1;
                if (map.get(nums[left]) == 1) {
                    map.remove(nums[left]);
                } else {
                    map.put(nums[left], map.get(nums[left]) - 1);
                }
                left++;
            }
        }
        return ans;
    }
}
