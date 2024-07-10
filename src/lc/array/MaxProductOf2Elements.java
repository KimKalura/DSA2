package lc.array;

public class MaxProductOf2Elements {


    //Given the array of integers nums, you will choose two different indices i and j of that array. Return the maximum value of (nums[i]-1)*(nums[j]-1).

    //Input: nums = [3,4,5,2]   // 12
    //Explanation: If you choose the indices i=1 and j=2 (indexed from 0), you will get the maximum value, that is, (nums[1]-1)*(nums[2]-1) = (4-1)*(5-1) = 3*4 = 12.

    //Input: nums = [1,5,4,5]    // 16
    //Explanation: Choosing the indices i=1 and j=3 (indexed from 0), you will get the maximum value of (5-1)*(5-1) = 16.

    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 2};
        int[] nums2 = {1, 5, 4, 5};
        System.out.println(maxProduct(nums));
        System.out.println(maxProduct(nums2));
    }

    //(nums[i]-1)*(nums[j]-1)
    // iteram prin array pt a aflla cele 2 nr max
    // calculam si returnam valoarea maxima
    //TC: O(n), SC:O(1)
    public static int maxProduct(int[] nums) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;

        for (int num : nums) {
            if (num > max1) {
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max2 = num;
            }
        }
        return (max1 - 1) * (max2 - 1);
    }

}
