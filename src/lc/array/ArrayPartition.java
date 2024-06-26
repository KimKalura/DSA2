package lc.array;

import java.util.Arrays;

public class ArrayPartition {

    //Given an integer array nums of 2n integers, group these integers into n pairs (a1, b1), (a2, b2), ..., (an, bn)
    // such that the sum of min(ai, bi) for all i is maximized. Return the maximized sum.

    //Input: nums = [1,4,3,2]
    //Output: 4
    //Explanation: All possible pairings (ignoring the ordering of elements) are:
    //1. (1, 4), (2, 3) -> min(1, 4) + min(2, 3) = 1 + 2 = 3
    //2. (1, 3), (2, 4) -> min(1, 3) + min(2, 4) = 1 + 2 = 3
    //3. (1, 2), (3, 4) -> min(1, 2) + min(3, 4) = 1 + 3 = 4
    //So the maximum possible sum is 4.

    //Input: nums = [6,2,6,5,1,2]
    //Output: 9
    //Explanation: The optimal pairing is (2, 1), (2, 5), (6, 6). min(2, 1) + min(2, 5) + min(6, 6) = 1 + 2 + 6 = 9.


    public static void main(String[] args) {
        int[] nums = {1, 4, 3, 2};
        int[] nums2 = {6, 2, 6, 5, 1, 2};
        System.out.println(arrayPairSum(nums)); //4
        System.out.println(arrayPairSum(nums2)); //9
    }

    //1.sortare array ->ne asigurăm că cele mai mici elemente sunt poziționate unul lângă celălalt.Acest lucru ajută la formarea perechilor în care valoarea minimă
        // a fiecărei perechi este cât mai mare posibil.
    //2.formam perechi de cate 2: (1,2), (3,4)
        //În fiecare pereche (a, b) unde a este mai mic sau egal cu b, valoarea care contribuie la sumă va fi a. Prin sortare, ne asigurăm că a este cât mai mare
           // posibil pentru fiecare pereche.
    //3. adunam minimum: Deoarece array-ul este sortat, minimul fiecărei perechi (nums[i], nums[i+1]) este întotdeauna nums[i] pentru indicii pari i. Prin urmare,
        // însumând elementele la indicii pari ai array-ului sortat ne dă rezultatul dorit. (1,2), (3,4) -> 1+3=4

    //TC: O(nlogn): sortareO(nlogn) + iterareO(n), SC:O(logn): spatiu auxiliar pt sortare O(logn) + itarare si suma O(1)
    public static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int maxSum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            maxSum += nums[i];
        }
        return maxSum;
    }


}
