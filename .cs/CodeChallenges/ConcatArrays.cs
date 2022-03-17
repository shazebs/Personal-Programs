/* my submission (faster than online searched) */ 
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


/* after submitting, online searched version solution (slower than my submission) */ 
public class Solution 
{
    public int[] GetConcatenation(int[] nums) 
    {
        return nums.Concat(nums).ToArray(); 
    }
}
