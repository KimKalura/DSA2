package lc.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DissapearedNo {

    //Find All Numbers Disappeared in an Array:
    //Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers
    // in the range [1, n] that do not appear in nums.

    //Input: nums = [4,3,2,7,8,2,3,1]
    //Output: [5,6]

    //Input: nums = [1,1]
    //Output: [2]

    public static void main(String[] args) {
        int[] nums1 = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println("varianta 1: " + findMissingNumbers1(nums1)); //[5, 6]

        int[] nums2 = {1, 1};
        List<Integer> findMissingNumbers2 = findMissingNumbers2(nums2);
        System.out.println("varianta 2: " + findMissingNumbers2); //[2]
    }


    //adaugam toate nr intr-un set
    //parcurgem array-ul nums si verificam daca setul contine numerele de la 1..n; nr lipsa le stocam in lista[result]
    public static List<Integer> findMissingNumbers1(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        List<Integer> result = new ArrayList<>();

        for (int num : nums) {
            numSet.add(num);
        }

        for (int i = 1; i <= nums.length; i++) {
            if (!numSet.contains(i)) {
                result.add(i);
            }
        }

        return result;
    }


    //1.marcam numerele vizitate ca fiind vizitate prin anularea valorii indexului coresp -> nums[i] - 1
    //2.identificam numerele care lipsesc verificând care indici sunt încă pozitivi  ->5 si 6
    public static List<Integer> findMissingNumbers2(int[] nums) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] = -nums[index]; //initializam valoarea pozitiva din array cu -4, -3, -2...
            }
        }

        //identificam nr pozitive (incepem de la -4...-1). *valorile pozitive indica numerele lipsa
        //daca val este pozitiva, inseamna ca indexul i nu a fost marcat (nu este negativ). Asta indica ca numarul i+1 lipsesste din arrray
        //daca cond nums[i] > 0 este adevarata adaugam in lista result i+1
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }

        return result;
    }


}