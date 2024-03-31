package 알고리즘연습.leetcode;

import java.io.IOException;
import java.util.TreeMap;

public class LeetCode_2444 {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int minI = -1, maxI = -1, left = -1, right = 0;
        long count = 0;
        while(right < nums.length){
            if(nums[right] < minK || nums[right] > maxK){
                minI = right;
                maxI = right;
                left = right;
            }
            minI = nums[right] == minK ? right : minI;
            maxI = nums[right] == maxK ?  right : maxI;
            count += Math.min(minI, maxI) - left;
            right++;
        }
        return count;
    }
}
