
public int[] TwoSum(int[] nums, int target){

        int rep = 0; 

        int el1 = 0, 

            el2 = 0;

        while(rep != nums.Length){

            el1 = nums[rep]; 

            for(var n = rep+1; n < nums.Length; n++){

                if (n == null) break; 

                el2 = nums[n];

                if (nums[rep] + nums[n] == target){

                    return new int[] {rep , n};

                    break; } }

            rep++; }

        return new int[]{0}; } }
