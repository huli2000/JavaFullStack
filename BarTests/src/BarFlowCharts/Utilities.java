package BarFlowCharts;
import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;

public class Utilities {
    public static int[] populateArray() {
        int[] array = new int[15];
        for (int i = 0; i < array.length; i++) {
           array[i] = new Random().nextInt(10);
        }
        return array;
    }

    public static int biggestSubArray(int[] array) {
        int biggest = ((array[0] * 100) + (array[1] * 10) + array[2]);
        for (int i = 3; i < array.length; i++) {
            if (array[i] < array.length - 3) {
                int temp = ((array[i - 2] * 100) + (array[i - 1] * 10) + array[i]);
                if (temp >= biggest) {
                    biggest = temp;
                }
            } else {
                break;
            }
        }
        return biggest;
    }

    public static int[] distinctNumbers(int[] distinct, int[] nums1, int[] nums2) {
        ArrayList<Integer> list = new ArrayList<>();
        boolean isExists = false;

        //Run from nums1 on nums2
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    isExists = true;
                    break;
                }
            }
            if (!isExists) {
                //Checking if the number is already in the list
                if (!list.contains(nums1[i])) {
                    list.add(nums1[i]);
                }
            } else {
                isExists = false;
            }
        }

        //Run from nums2 on nums1
        isExists = false;
        for (int i = 0; i < nums2.length; i++) {
            for (int j = 0; j < nums1.length; j++) {
                if (nums1[i] == nums2[j]) {
                    isExists = true;
                    break;
                }
            }

            if (!isExists) {
                //Checking if the number is already in the list
                if (!list.contains(nums2[i])) {
                    list.add(nums2[i]);
                }
            } else {
                isExists = false;
            }
        }
        return ArrayListToDistinctArray(list, distinct);
    }

    private static int[] ArrayListToDistinctArray(ArrayList<Integer> list, int[] distinct) {
        //Import the non-duplicate numbers to distinct array
        for (int i = 1; i < list.size(); i++) {
            distinct[i - 1] = list.get(i);
        }
        return distinct;
    }

    public static int arrayToNumber(int[] distinct) {
        int temp,num = 0;
        for (int i = distinct.length - 1; i >= 0; i--) {
            if (distinct[i] != -1) {
                temp = distinct[i];
                for (int j = 1; j <= i; j++) {
                    temp = temp * 10;
                }
                num += temp;
            }
        }
        return num;
    }

}
