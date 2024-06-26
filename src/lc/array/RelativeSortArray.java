package lc.array;

import java.util.*;

public class RelativeSortArray {

    //Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are also in arr1.

    //Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2. Elements that do not appear
    // in arr2 should be placed at the end of arr1 in ascending order.


    public static void main(String[] args) {
        int[] arr1 = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] arr2 = {2, 1, 4, 3, 9, 6};
        int[] sortedArray = relativeSortArray(arr1, arr2);
        System.out.println(Arrays.toString(sortedArray)); // [2, 2, 2, 1, 4, 3, 3, 9, 6, 7, 19]
    }

    //TC: O(nlogn); SC: O(n)
    public static int[] relativeSortArray(int[] arr1, int[] arr2) {

        //adaugam elementele din arr1 intr-o mapa
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : arr1) { //O(n)
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        //cream o lista pt a stoca rezultatul sortat
        List<Integer> result = new ArrayList<>();

        //iteram prin arr2 si adaugam el in lista result in functie de frecventa lor in arr1
        for (int num : arr2) { //O(m+k); m=lungimea arr2, k=nr total de el adaugate in lista result
            int count = frequencyMap.get(num);
            for (int i = 0; i < count; i++) {
                result.add(num);
            }
            frequencyMap.remove(num);

        }

        //adaugam el ramase in arr1 care nu sunt in arr2, la lista result  in ordine cresc.
        List<Integer> remaining = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();
            for (int i = 0; i < count; i++) {
                remaining.add(num);
            }
        }
        Collections.sort(remaining); // 7, 19 //O(rlogr); r=numarul el ramase
        result.addAll(remaining); //O(r)

        //convertim List -> int[]
        int[] resultArray = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultArray[i] = result.get(i);
        }

        return resultArray;
    }

}
