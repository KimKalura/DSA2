package lc.array;

public class SpecialArray {

    //[2,1,4]  => (2,1) and (1,4)


    public static void main(String[] args) {
        int[] nums1 = {1};
        int[] nums2 = {2, 1, 4};
        int[] nums3 = {4, 3, 1, 6};

        System.out.println(isArraySpecial(nums1)); // true
        System.out.println(isArraySpecial(nums2)); // true
        System.out.println(isArraySpecial(nums3)); // false
    }
    //verificam daca arrayul are 0 sau 1 elemente
    // in timp ce verificam paritatea [daca se imparte la 2] retinem numerele
    // verificam daca numerele sunt diferite [par+impar] -> num[i] !=num[i+1] ->true
    // formam array-uri

    //TC: O(n); SC: O(1)
    public static boolean isArraySpecial(int[] nums) {
        if (nums.length <= 1) {
            return true;
        }

        for (int i = 0; i < nums.length - 1; i++) {
            if ((nums[i] % 2) == (nums[i + 1] % 2)) {
                return false;
            }
        }
        return true;
    }

}
