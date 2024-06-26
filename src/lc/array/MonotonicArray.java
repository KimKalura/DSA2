package lc.array;

public class MonotonicArray {

    //monotonic array = daca array-ul creste sau descreste
    //monoton increasing: 1, 2 ,3, 3, 4
    //monoton decreasing: 4, 3, 3, 2, 1

    //Given an integer array nums, return true if the given array is monotonic, or false otherwise.
    //nums = [1,2,2,3] TRUE
    //nums = [6,5,4,4] TRUE
    //nums = [1,3,2] FALSE

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3};  //T
        int[] nums2 = {6,5,4,4};    //T
        int[] nums3 = {1,3,2};      //F
        int[] nums4 = {1,1,1};      //T

        System.out.println(isMonotonic(nums));
        System.out.println(isMonotonic(nums2));
        System.out.println(isMonotonic(nums3));
        System.out.println(isMonotonic(nums4));

    }

    //TC: O(n); timp linear
    public static boolean isMonotonic(int[] nums) {
        boolean increase = true;
        boolean decrease = true;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                increase = false;  //pt ca array-ul nu creste
            }
            if (nums[i] < nums[i + 1]) {
                decrease = false;  //pt ca array-ul nu descreste
            }
        }
        return increase || decrease;
    }


}
