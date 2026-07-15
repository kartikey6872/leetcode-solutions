class Solution {
    public int minPatches(int[] nums, int n) {
        long miss = 1;
        int i = 0, ans = 0;

        while (miss <= n)
            if (i < nums.length && nums[i] <= miss) miss += nums[i++];
            else { ans++; miss += miss; }

        return ans;
    }
}
