package lc.array;

import java.util.HashMap;
import java.util.Map;

public class N_repeteadElementInSize2NArr {

    //You are given an integer array nums with the following properties:
        //nums.length == 2 * n.
        //nums contains n + 1 unique elements.
        //Exactly one element of nums is repeated n times.
    //Return the element that is repeated n times.

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3};
        int[] nums2 = {2, 1, 2, 5, 3, 2};
        System.out.println(repeatedNTimes(nums));//3
        System.out.println(repeatedNTimes(nums2));//2

    }


    //S+T complexitate: O(n)
    public static int repeatedNTimes(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
            if (countMap.get(num) == nums.length / 2) { //pentru a obține n, trebuie să împărțim lungimea numerelor la 2
                return num;
            }
        }
        return 1;
    }

    //S+T complexitate: O(n)
    public static int repeatedNTimes2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        for (Integer n : map.keySet()) {
            if (map.get(n) == nums.length / 2) {
                return n;
            }
        }
        return Integer.MIN_VALUE;
    }

    //Alte variante:
        // sortare.
        // sum: toate elementele adunate - elementele unice adunate, impartim elementele ramase 9de cate ori apar)
            // {2, 1, 2, 5, 3, 2} = 15
            // {2, 1, 5, 3} = 11
            // 15-11 = 4
            // 4/2 (au ramas 2 de 2) = 2 -> e nr cautat  //S+T complexitate: O(n)

            // {9, 1, 9, 5, 3, 9} = 36
            // {9, 1, 5, 3} = 18
            // 36-18 = 18
            // 18/2 (avem 2 de 9 ramasi) = 9

}
