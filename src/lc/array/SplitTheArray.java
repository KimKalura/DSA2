package lc.array;

import java.util.HashMap;
import java.util.Map;

public class SplitTheArray {

    //You are given an integer array nums of even length. You have to split the array into two parts nums1 and nums2 such that:
    //nums1.length == nums2.length == nums.length / 2.
    //nums1 should contain distinct elements.
    //nums2 should also contain distinct elements.
    //Return true if it is possible to split the array, and false otherwise.


    //Input: nums = [1,1,2,2,3,4] //true
    //Explanation: One of the possible ways to split nums is nums1 = [1,2,3] and nums2 = [1,2,4].

    //Input: nums = [1,1,1,1] //false
    //Explanation: The only possible way to split nums is nums1 = [1,1] and nums2 = [1,1]. Both nums1 and nums2 do not contain distinct elements. Therefore, we return false.


    //numaram frecventa elementelor [cream mapa]
    //verificam daca fiecare element apare mai mult de 2
    //numaram numerele care apar o sg data
    //verificam daca numerele distincte sunt de ajuns

    public static void main(String[] args) {
        int[] nums1 = {1, 1, 2, 2, 3, 4};
        int[] nums2 = {1, 1, 1, 1};
        System.out.println(isPossibleToSplit(nums1)); //TRUE -> nums1 = [1,2,3] and nums2 = [1,2,4].
        System.out.println(isPossibleToSplit(nums2)); //FALSE -> nums1 = [1,1] and nums2 = [1,1]
    }


    //S + T complexity: O(n)
    public static boolean isPossibleToSplit(int[] nums) {
        Map<Integer, Integer> frequencyMap = new HashMap<>(); //(O(n) timp
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }


        for (int count : frequencyMap.values()) {//O(n) timp [worst case]
            if (count > 2) {
                return false;
            }
        }

        int distinctCount = frequencyMap.size();  //O(1) timp- pt a verifica lungimea

        if (distinctCount >= nums.length / 2) {  //O(1) timp
            return true;
        } else {
            return false;
        }
    }


}
