
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // First, I'm going to sort the array. This is super important because it lets us 
        // use the two-pointer approach and easily skip duplicates.
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            // If the current number is greater than zero, there's no way the sum can be zero 
            // since the array is sorted and all following numbers will also be positive.
            if (nums[i] > 0) break;

            // This line is key for the 'no duplicates' rule. If this number is the same 
            // as the previous one, we just skip it so we don't find the same triplet again.
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            // Now I'll set up two pointers for the rest of the array.
            int l = i + 1;
            int r = nums.length - 1;

            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];

                if (sum > 0) {
                    // Sum is too big, so we need a smaller number. Move the right pointer in.
                    r--;
                } else if (sum < 0) {
                    // Sum is too small, so we need a bigger number. Move the left pointer in.
                    l++;
                } else {
                    // We found a triplet! Let's add it to our results list.
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    
                    // Now we need to move the pointers, but we also have to skip any 
                    // duplicate values for 'l' so we don't get the same triplet again.
                    l++;
                    while (nums[l] == nums[l - 1] && l < r) {
                        l++;
                    }
                }
            }
        }
        return res;
    }
}
