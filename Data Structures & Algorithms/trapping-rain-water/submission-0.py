class Solution:
    def trap(self, height: List[int]) -> int:
        # The goal is to find how much water each bar can hold.
        # A bar can hold water up to the height of the shorter of the two tallest bars to its left and right.
        if not height:
            return 0

        # We use two pointers starting from both ends
        left, right = 0, len(height) - 1
        left_max, right_max = height[left], height[right]
        res = 0

        while left < right:
            # We always move the pointer pointing to the smaller height
            # because the water level is limited by the shorter wall.
            if left_max < right_max:
                left += 1
                # Update the max height seen from the left so far
                left_max = max(left_max, height[left])
                # Water trapped at current index is (max_height - current_height)
                res += left_max - height[left]
            else:
                right -= 1
                # Update the max height seen from the right so far
                right_max = max(right_max, height[right])
                res += right_max - height[right]
        
        return res
