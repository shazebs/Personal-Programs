public class Solution 
{
    public int[] GetConcatenation(int[] nums) 
    {
        int n = nums.Length;
        int[] ans = new int[2*n]; 
        for (var i = 0; i < nums.Length; i++){
            ans[i] = nums[i]; 
            ans[i+n] = nums[i]; 
        }
        return ans;
    }
}
