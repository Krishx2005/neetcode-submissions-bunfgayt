class Solution {
    public int trap(int[] height) {
        // If the array is empty, we can't trap any water
        if (height == null || height.length == 0) return 0;

        int left = 0;
        int right = height.length - 1;
        int leftMax = height[left];
        int rightMax = height[right];
        int totalWater = 0;

        // We use two pointers to meet in the middle
        while (left < right) {
            // We always move the pointer pointing to the shorter wall
            // because the water level is limited by the shorter side
            if (leftMax < rightMax) {
                left++;
                // Update the max height seen from the left so far
                leftMax = Math.max(leftMax, height[left]);
                // The water trapped at this index is the difference between 
                // the max wall and the current floor
                totalWater += leftMax - height[left];
            } else {
                right--;
                // Same logic for the right side
                rightMax = Math.max(rightMax, height[right]);
                totalWater += rightMax - height[right];
            }
        }

        return totalWater;
    }
}
