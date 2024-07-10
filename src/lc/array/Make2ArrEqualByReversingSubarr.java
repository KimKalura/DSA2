package lc.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Make2ArrEqualByReversingSubarr {

    //You are given two integer arrays of equal length target and arr. In one step, you can select any non-empty subarray of arr and reverse it.
    // You are allowed to make any number of steps.
    //Return true if you can make arr equal to target or false otherwise.

    //Input: target = [1,2,3,4], arr = [2,4,1,3]   -> true
    //Input: target = [7], arr = [7]   -> true
    //Input: target = [3,7,9], arr = [3,7,11]  -> false

    public static void main(String[] args) {

        int[] target = {1, 2, 3, 4};
        int[] arr = {2, 4, 1, 3};
        System.out.println(canBeEqual(target, arr));//t
        System.out.println(canBeEqual2(target, arr));//t

        int[] target2 = {3, 7, 9};
        int[] arr2 = {3, 7, 11};
        System.out.println(canBeEqual(target2, arr2));//f
        System.out.println(canBeEqual2(target2, arr2));//f

    }

    // S+T complexity O(n)
    public static boolean canBeEqual(int[] target, int[] arr) {
        if (target.length != arr.length) {  //O(1)
            return false;
        }

        Map<Integer, Integer> targetCount = new HashMap<>();
        Map<Integer, Integer> arrCount = new HashMap<>();

        for (int num : target) {
            targetCount.put(num, targetCount.getOrDefault(num, 0) + 1); //iterare O(n) timp; O(n) spatiu
        }

        for (int num : arr) {
            arrCount.put(num, arrCount.getOrDefault(num, 0) + 1); //iterare O(n) timp;  O(n) spatiu
        }

        /*if (targetCount.equals(arrCount)) { // O(n) worst case
            return true;
        } else {
            return false;
        }*/
        return targetCount.equals(arrCount);
    }

    // TC:O(n); SC:O(1)
    public static boolean canBeEqual2(int[] target, int[] arr) {
        int[] freq = new int[1001]; // todo: cu ce se poate modifica-> https://leetcode.com/problems/make-two-arrays-equal-by-reversing-subarrays/description/

        for (int i : target) {
            freq[i]++;
        }

        for (int i : arr) {
            freq[i]--;
        }

        for (int f : freq) {
            if (f != 0) {
                return false;
            }
        }

        return true;
    }



    public boolean canBeEqual3(int[] target, int[] arr) {
        if (target.length != arr.length) {
            return false;
        }

        // sortarea fiecarui array O(nlogn) timp
        Arrays.sort(target);
        Arrays.sort(arr);

        // comparare O(1) spatiu
        for (int i = 0; i < target.length; i++) {
            if (target[i] != arr[i]) {
                return false;
            }
        }

        return true;
    }
}
