package lc.array;

import java.util.HashMap;
import java.util.Map;

public class DivideArray {

    public static void main(String[] args) {
        int[] nums1 = {3, 2, 3, 2, 2, 2};
        System.out.println(divideArray(nums1)); // true

        int[] nums2 = {1, 2, 3, 4};
        System.out.println(divideArray(nums2)); // false
    }


    //aflam prima data frecventa elementelor
    //verificam dacă fiecare element apare de un număr par de ori. Dacă toate elementele au frecvențe egale, atunci este posibil să facem perechi; altfel, nu se poate.
    public static boolean divideArray(int[] nums) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        for (int count : frequencyMap.values()) {
            if (count % 2 != 0) {
                return false;
            }
        }

        return true;
    }
}
