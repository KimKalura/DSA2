package lc.array.medium;

public class NextPermutation {

    //A permutation of an array of integers is an arrangement of its members into a sequence or linear order.
        //For example, for arr = [1,2,3], the following are all the permutations of arr: [1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].

    //The next permutation of an array of integers is the next lexicographically greater permutation of its integer. More formally, if all the permutations of
    // the array are sorted in one container according to their lexicographical order, then the next permutation of that array is the permutation that follows it
    // in the sorted container. If such arrangement is not possible, the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).

        //For example, the next permutation of arr = [1,2,3] is [1,3,2].
        //Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
        //While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a lexicographical larger rearrangement.

    //Given an array of integers nums, find the next permutation of nums.
    //The replacement must be in place and use only constant extra memory.


    public static void main(String[] args) {
        int[] nums = {1, 5, 2}; //2 1 5
        int[] nums1 = {1, 2, 3}; //1 3 2
        int[] nums2 = {3, 2, 1}; //1 2 3
        int[] nums3 = {1, 1, 5}; //1 5 1
        int[] nums4 = {1, 1, 5, 4, 6}; //1 1 5 6 4

        nextPermutation(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    //1.incepem de la ultimul el si gasim primul element care este mai mic decât elementul din dreapta sa
    //2.daca este crestere:Găsim cel mai mic element din dreapta lui nums[i] care este mai mare decât nums[i]. -> indexul este stocat în j
        //schimbam elem de la indicii i si j [swap]
    //3.inversam elem din dreapta lui i;  Acest pas asigură că secvența după poziția i originală este în cea mai mică *ordine lexicografică*.
        //reverse: schimba elem de la inceput pana la sfarsit

    //TC: O(n)
    //SC: O(1)
    public static void nextPermutation(int[] nums) {

        int i = nums.length - 2; //1.

        while(i >= 0 && nums[i] >= nums[i+1]){ //se oprește la primul element de la capătul care este mai mic decât următorul element
            i--;
        }

        if(i >= 0) { //2.
            int j = nums.length-1;
            while(j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i+1); //3.
    }

    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void reverse(int[] nums, int start){
        int end = nums.length-1;
        while(start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

}
