package lc.array;

public class ContatenationOfArray {

    //Given an integer array nums of length n, you want to create an array ans of length 2n where ans[i] == nums[i] and ans[i + n] == nums[i] for 0 <= i < n (0-indexed).
    //Specifically, ans is the concatenation of two nums arrays.
    //Return the array ans.

    //Input: nums = [1,2,1]
    //Output: [1,2,1,1,2,1]

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int[] nums2 = {1,3,2,1};
        int[] result = getConcatenation(nums);
        int[] result2 = getConcatenation(nums2);

        for (int i : result) {
            System.out.print(i + " ");
        }
        System.out.println(" ");
        for (int i : result2) {
            System.out.print(i + " ");
        }
    }

    //S+T complexity: O(n)
    public static int[] getConcatenation(int[] nums) {
        int[] ans = new int[2 * nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = nums[i]; // 1 0 0 0 0 0
            ans[i + nums.length] = nums[i]; // 1 0 0 1 0 0
        }
        return ans;
    }

}
