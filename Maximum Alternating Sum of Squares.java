class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        for(int i= 0;i<nums.length;i++){
        if(nums[i]<0){
               nums[i] = -nums[i];
            }
        }
        Arrays.sort(nums);
        long ps = 0;
        for(int i = 0; i<n/2;i++){
            ps+= (long) nums[i]*nums[i];
        }   
        long as = 0;
        for(int i = n/2;i<n;i++){
            as+= (long) nums[i]*nums[i];
        } 
        long ans = as-ps;
        return ans;
         
    }
}
