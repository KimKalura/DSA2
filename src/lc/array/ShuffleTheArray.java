package lc.array;

public class ShuffleTheArray {

    //Given the array nums consisting of 2n elements in the form [x1,x2,...,xn,y1,y2,...,yn].
    //Return the array in the form [x1,y1,x2,y2,...,xn,yn].

    //Input: nums = [2,5,1,3,4,7], n = 3
    //Output: [2,3,5,4,1,7]
    //Explanation: Since x1=2, x2=5, x3=1, y1=3, y2=4, y3=7 then the answer is [2,3,5,4,1,7].

    public static void main(String[] args) {
        int[] nums1 = {2, 5, 1, 3, 4, 7};
        int n1 = 3;
        int[] shuffled1 = shuffle(nums1, n1);
        System.out.println(java.util.Arrays.toString(shuffled1)); // [2, 3, 5, 4, 1, 7]

        int[] nums2 = {1, 2, 3, 4, 4, 3, 2, 1};
        int n2 = 4;
        int[] shuffled2 = shuffle(nums2, n2);
        System.out.println(java.util.Arrays.toString(shuffled2)); // [1, 4, 2, 3, 3, 2, 4, 1]
    }


    //initializam un array nou de marimea 2*n [0, 0, 0, 0, 0, 0]
    //mergem in acelasi timp cu i  (in prima jumatate - xi) si i+n (in a2a jumatate - yi)

    //TC: O(n); SC: O(n)
    public static int[] shuffle(int[] nums, int n) {
        int[] result = new int[2 * n]; //O(n)
        for (int i = 0; i < n; i++) { //O(n) - ruleaza de n ori, si fiecare iterare efectuează operații în timp constant
            result[2 * i] = nums[i];         //2,5,1
            result[2 * i + 1] = nums[i + n]; //3,4,7
        }
        return result; // O(1)
    }
}
