## Review Notes with Algorithms

### Binary Search
##### lower boundary search is the following:
	
	public int getLowerBoundary(int[] nums, target)
	{
		int left = 0;
		int right = nums.length-1;
		while (left < right) {
			int mid = left + (right-left)/2;
			if (nums[mid] < target) {
				left = mid + 1;
			} else { // nums[mid] >= target
			   right = mid; // 你每次都在挤压right 即使right这个index可能已经找到了target的value
			}
		}		
		
		return left; // left == right
	}

##### upper boundary search is the following
	public int getUpperBoundary(int[] nums, target)
	{
		int left = 0;
		int right = nums.length-1;
		while (left < right) {
			int mid = left + (right-left)/2;
			if (nums[mid] <= target
			    && left != right -1) { //必须+这个条件
				left = mid; 
			} else { // nums[mid] > target
			   right = mid - 1;  
			}
		}		
		
		// provided if the value must exist
		return nums[left] == target? left: right;
	}	
-