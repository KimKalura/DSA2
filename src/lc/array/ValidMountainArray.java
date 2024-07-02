package lc.array;

public class ValidMountainArray {

    //Given an array of integers arr, return true if and only if it is a valid mountain array.
    //conditii: arr.length >= 3

    public static void main(String[] args) {
        int[] arr = {0, 2, 3, 4, 5, 2, 1, 0};
        int[] arr2 = {0, 2, 3, 3, 5, 2, 1, 0};
        System.out.println(validMountainArray(arr));//T
        System.out.println(validMountainArray(arr2));//F
        System.out.println(validMountainArray2(arr));//T


    }

    public static boolean validMountainArray(int[] arr) {
        //lungimea arr sa fie mai mare de 3 elemente
        if (arr.length < 3) {
            return false;
        }

        //mergem cu i atat timp cat nu se iese din arr si cat timp elemetele cresc
        //daca cond e satisfacuta incrementam i++
        int i = 0;
        while (i < arr.length - 1 && arr[i] < arr[i + 1]) {
            i++;
        }

        //i == 0 inseamna ca i este peak [in conditia 54321]  sau nu exista descrestere [in cond 12345]-> false
        if (i == 0 || i == arr.length - 1) {
            return false;
        }

        //
        while (i < arr.length - 1 && arr[i] > arr[i + 1]) {
            i++;
        }

        /*if(i==arr.length-1){
            return true;
        }
        return false;*/
        //s-a ajuns la sfarsitul arr
        return (i == arr.length - 1);
    }

    //TC: O(n); SC: O(1)
    public static boolean validMountainArray2(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        if (arr.length < 3) {
            return false;
        }

        //crestere
        while (left < right && arr[left] < arr[left + 1]) {
            left++;
        }

        //descrestere
        while (right >= 1 && arr[right] < arr[right - 1]) {
            right--;
        }

        //peak
        if (right != 0 && left != arr.length - 1 && left == right) {
            return true;
        }

        return false;
    }

}
