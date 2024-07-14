package lc.array.medium;

public class MinimumOperationsToMakeArrEqual {

    //You have an array arr of length n where arr[i] = (2 * i) + 1 for all valid values of i (i.e., 0 <= i < n).
    //In one operation, you can select two indices x and y where 0 <= x, y < n and subtract 1 from arr[x] and add 1 to arr[y]
        // (i.e., perform arr[x] -=1 and arr[y] += 1). The goal is to make all the elements of the array equal. It is guaranteed that
        // all the elements of the array can be made equal using some operations.
    //Given an integer n, the length of the array, return the minimum number of operations needed to make all the elements of arr equal.

    //Input: n = 3  //output:2
    //Explanation: arr = [1, 3, 5]
    //First operation choose x = 2 and y = 0, this leads arr to be [2, 3, 4]
    //In the second operation choose x = 2 and y = 0 again, thus arr = [3, 3, 3].

    public static void main(String[] args) {
       // System.out.println(minOperations(3)); //2
        System.out.println(minOperations(6)); //9
    }

    //TC: O(n); SC:O(1)
    public static int minOperations(int n) {
        int min = 1; //primul nr va fi intotdeauna 1; arr[i] = (2 * i) + 1-> cand i=0: 2*0=0; 0+1=1
        int max = 2 * (n - 1) + 1; //este bazat pe formula (2 * i)
        int equalNumber = (min + max) / 2;
        int ops = 0; //stocheaza nr de operatii

        for (int i = 0; i < n / 2; i++) { //iteram in prima jum de array calculand nr de operatii necesare pt a face fiecare element egal
            ops += equalNumber - (2 * i + 1);
        }
        return ops;
    }

    //explicatie


    //varianta 2
    //TC: O(1); sc:O(1)
    public static int minOperations2(int n) {
        int mid = n/2;
        return mid * (mid + n % 2);
    }

}
