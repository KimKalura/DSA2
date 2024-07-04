package lc.array;

import java.util.HashMap;
import java.util.Map;

public class DistinctDifferenceArray {
    //You are given a 0-indexed array nums of length n.
    //The distinct difference array of nums is an array diff of length n such that diff[i] is equal to the number of distinct
    // elements in the suffix nums[i + 1, ..., n - 1] subtracted from the number of distinct elements in the prefix nums[0, ..., i].

    //Return the distinct difference array of nums.

    //Note that nums[i, ..., j] denotes the subarray of nums starting at index i and ending at index j inclusive. Particularly,
    // if i > j then nums[i, ..., j] denotes an empty subarray.

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int[] result = distinctDifferenceArray(nums);
        for (int i : result) {
            System.out.print(i + " "); //-3 -1 1 3 5
        }

        System.out.println(" ");
        int[] nums2 = {3, 2, 3, 4, 2};
        int[] result2 = distinctDifferenceArray(nums2);
        for (int i : result2) {
            System.out.print(i + " "); //-2 -1 0 2 3
        }
    }

    //T + S complexity: O(n)
    public static int[] distinctDifferenceArray(int[] nums) {
        Map<Integer, Integer> prefix = new HashMap<>();
        prefix.put(nums[0], 1);

        Map<Integer, Integer> suffix = new HashMap<>();
        for (int i = 1; i < nums.length; i++) {
            suffix.put(nums[i], suffix.getOrDefault(nums[i], 0) + 1);
        }

        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = prefix.size() - suffix.size();
            if (i + 1 < nums.length) {
                int next = nums[i + 1];
                prefix.put(next, prefix.getOrDefault(next, 0) + 1);
                if (suffix.containsKey(next) && suffix.get(next) == 1) {
                    suffix.remove(next);
                } else {
                    suffix.put(next, suffix.get(next) - 1);
                }
            }
        }
        return result;
    }

}
