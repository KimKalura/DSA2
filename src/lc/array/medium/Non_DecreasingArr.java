package lc.array.medium;

public class Non_DecreasingArr {

    //Given an array nums with n integers, your task is to check if it could become non-decreasing by modifying at most one element.

    //We define an array is non-decreasing if nums[i] <= nums[i + 1] holds for every i (0-based) such that (0 <= i <= n - 2).

    //Input: nums = [4,2,3] //true
    //Explanation: You could modify the first 4 to 1 to get a non-decreasing array.

    //Input: nums = [4,2,1]  //false
    //Explanation: You cannot get a non-decreasing array by modifying at most one element.

    public static void main(String[] args) {
        int[] nums = {4, 2, 3};
        int[] nums2 = {4, 2, 1};
        System.out.println(checkPossibility(nums));
        System.out.println(checkPossibility(nums2));
    }

    public static boolean checkPossibility(int[] nums) {

        int pos = -1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                if (pos != -1) {
                    return false;
                }
                pos = i; //mutam pozitia la index
            }

        }

        return pos == -1 || pos == 0 || pos == nums.length - 2 || nums[pos - 1] <= nums[pos + 1] || nums[pos] <= nums[pos + 2];
    }
}
