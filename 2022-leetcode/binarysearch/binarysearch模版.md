### Binary Search 模版
#### Infinite loop只能存在于 left = mid这个情况！！！ 因为left < right 且 left 可以等于mid itself
#### 所以 一旦 left < right -1 那么就okay left right都可以直接等于mid

### BinarySearch first element in duplicates
#### 一直可以向左边挤压 first element
#### 也就是说 right = mid 可以成立
#### 所以 target <= nums[mid]

    def first_position(self, nums: List[int], target: int) -> int:
        # write your code here
        if (nums == None or len(nums) == 0):
            return -1
        left, mid, right = 0, 0, len(nums) - 1
        # get the first one that shows
        # we need to update left with log(n)
        while (left < right):
            mid = left + (right - left)//2
            if (target > nums[mid]):
                left = mid + 1 # 一定要 + 1
            else:  # target <= nums[mid]
                right = mid
        return left if (nums[left] == target) else -1

### BinarySearch  element in duplicates
#### 一直可以向右边挤压 last element
#### 也就是说 left = mid 可以成立
#### 所以 target >= nums[mid]
#### 但是会有infinite loop 因为left = mid
##### 解决方案？ left < right - 1
##### 最后查一查right left 然后结果 记住 先right！！！！
    def lastPosition(self, nums, target):
        if (nums == None or len(nums) == 0):
            return -1
        # last one, always want to continue go left

        left, mid, right = 0, 0, len(nums) - 1
        while (left < right - 1):
            mid = left + (right - left)//2
            if (target >= nums[mid]):
                left = mid
            else: # target < nums[right]
                right = mid - 1

        # Trick, always do right first
        if (nums[right] == target):
            return right
        elif (nums[left] == target):
            return left
        else:
            return -1

### Standard left < right - 1
###### 注意看 mid 的定义

    public int find(int[] nums, int target) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length-1;
        while (left + 1 < right) {
            int mid = left + (right-left)/2;
            if (target > nums[mid] ) { // target greater than mid, left can be mid
                left = mid ; //注意 这里直接=mid就可以了 不用担心无限循环 --》 因为 left + 1 < right!!!! 解决了 infinite loop的问题
            } else { // target <= nums[mid]
                right = mid;
            }
        }

        // could be left or right, make the decision here
        return nums[left] == target? left: right;
    }
