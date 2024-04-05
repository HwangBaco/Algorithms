package 알고리즘연습.leetcode;

public class LeetCode_twosum {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        int l = nums.length - 1;
        for (int i = 0; i <= l; i++) {
            for (int j = i+1; j <= l; j++) {
                if (i == j) {
                    continue;
                }
                int sum = nums[i] + nums[j];
                if (sum == target) {
                    ans[0] = i;
                    ans[1] = j;
                    return ans;
                }
                sum = nums[l-i] + nums[l-j];
                if (sum == target) {
                    ans[0] = l - i;
                    ans[1] = l - j;
                    return ans;
                }
            }
        }
        return ans;
    }
}
