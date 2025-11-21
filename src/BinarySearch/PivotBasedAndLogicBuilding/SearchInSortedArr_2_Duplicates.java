package BinarySearch.PivotBasedAndLogicBuilding;

public class SearchInSortedArr_2_Duplicates {

        public static void main(String[] args) {
            int[] nums = {4, 5, 6, 7, 7, 0, 1, 2, 3};
            System.out.println(search(nums, 6));   // true
            System.out.println(search(nums, 7));   // true (duplicate case)
            System.out.println(search(nums, 10));  // false
        }

        public static boolean search(int[] nums, int target) {
            int pivot = findPivot(nums);

            if (pivot == -1) {
                return binarySearch(nums, target, 0, nums.length - 1) != -1;
            }

            if (nums[pivot] == target) return true;

            // if target >= first element, search left half
            if (nums[0] <= target) {
                return binarySearch(nums, target, 0, pivot - 1) != -1;
            }

            // otherwise search right half
            if(nums[0] >= target) {
                return binarySearch(nums, target, pivot + 1, nums.length - 1) != -1;
            }

            return false;
        }


        // Modified pivot finder: supports duplicates
        public static int findPivot(int[] nums) {
            int start = 0;
            int end = nums.length - 1;

            while (start <= end) {
                int mid = start + (end - start) / 2;

                // Case 1
                if (mid < end && nums[mid] > nums[mid + 1]) {
                    return mid;
                }

                // Case 2
                if (mid > start && nums[mid] < nums[mid - 1]) {
                    return mid - 1;
                }

                // --- Duplicate Handling ---
                if (nums[start] == nums[mid] && nums[mid] == nums[end]) {
                    start++;
                    end--;
                    continue;
                }

                // Case 3: Left part is unsorted OR mid is in the rotated section
                if (nums[start] > nums[mid] || (nums[start] == nums[mid] && nums[mid] > nums[end])) {
                    end = mid - 1;
                }
                // Case 4: Left part is sorted
                else {
                    start = mid + 1;
                }
            }
            return -1;
        }


        public static int binarySearch(int[] nums, int target, int start, int end) {
            while (start <= end) {
                int mid = start + (end - start) / 2;

                if (target > nums[mid]) {
                    start = mid + 1;
                } else if (target < nums[mid]) {
                    end = mid - 1;
                } else {
                    return mid;
                }
            }
            return -1;
        }
    }