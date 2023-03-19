// Учитывая два целочисленных массива nums1 и nums2, верните максимальную длину подмассива, который появляется в обоих массивах.
// Example 1:
// Input: nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
// Output: 3
// Explanation: Повторяющийся подмассив с максимальной длиной равен [3,2,1].
// Example 2:
// Input: nums1 = [0,0,0,0,0], nums2 = [0,0,0,0,0]
// Output: 5
// Explanation: Повторяющийся подмассив с максимальной длиной равен [0,0,0,0,0].

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HW_Task_Sem_5  {
    public static void main(String[] args) {
        System.out.print("\033[H\033[J");

        int[] array1 = {1, 3, 2, 1, 7};
        int[] array2 = {3, 2, 1, 4, 7};
        System.out.println(Array.findEqualsSubarray(array1, array2));

        int[] array3 = {0, 0, 0, 0, 0};
        int[] array4 = {0, 0, 0, 0, 0};
        System.out.println(Array.findEqualsSubarray(array3, array4));

    }
}

abstract class Array {

    private static final int MIN_LENGTH_SUBARRAY = 2;

    public static String findEqualsSubarray(int[] firstArray, int[] secondArray) {
        List<Integer> result = new ArrayList<>();
        int counter = 0;
        
        for (int startIndex = 0; startIndex <= firstArray.length; startIndex++) {
            for (int endIndex = startIndex + 1; endIndex <= firstArray.length; endIndex++) {
                int[] tempSubarray = Arrays.copyOfRange(firstArray, startIndex, endIndex);
                if (tempSubarray.length >= MIN_LENGTH_SUBARRAY && counter < tempSubarray.length && isContains(tempSubarray, secondArray)) {
                    result.clear();
                    for (int item : tempSubarray) result.add(item);
                    counter = tempSubarray.length;
                }
            }
        }

        if (result.size() < MIN_LENGTH_SUBARRAY) {
            return "\u001B[31mПовторяющиеся массивы не найдены";
        } else {
            return "\u001B[32mПовторяющийся подмассив " + result + ". Максимальная длина равна " + counter;
        }
    }

    private static boolean isContains(int[] arrayOne, int[] arrayTwo) {
        for (int startIndex = 0; startIndex <= arrayTwo.length; startIndex++) {
            for (int endIndex = startIndex + 1; endIndex <= arrayTwo.length; endIndex++) {
                int[] tmp = Arrays.copyOfRange(arrayTwo, startIndex, endIndex);
                if (arrayOne.length == tmp.length && Arrays.equals(arrayOne, tmp)) {
                    return true;
                }
            }
        }
        return false;
    }
}


