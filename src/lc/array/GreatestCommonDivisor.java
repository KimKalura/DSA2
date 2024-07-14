package lc.array;

public class GreatestCommonDivisor {

    //Given an integer array nums, return the greatest common divisor of the smallest number and largest number in nums.
    //The greatest common divisor of two numbers is the largest positive integer that evenly divides both numbers.

    public static void main(String[] args) {
        int[] nums = {2,5,6,9,10};  //2
        int[] nums2 = {7,5,6,8,3}; //1

        System.out.println(findGCD(nums));
        System.out.println(findGCD(nums2));
    }


    //TC: O(n) -liniar; SC:O(1) -constant
    private static int findGCD(int[] nums) {
        //Arrays.stream(nums).min().orElse(Integer.MAX_VALUE); //TC: O(n)
        //Arrays.stream(nums).max().orElse(Integer.MIN_VALUE); //TC: O(n)
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int n : nums){
            min = Math.min(min, n);
            max = Math.max(max,n);
        }
        return gcd(min, max);
    }

    //sc:O(log(min)) -> avem recursititate
    public static int gcd (int a, int b){
        if (b == 0){
            return a;
        }
        return gcd(b, a % b);
    }

}
