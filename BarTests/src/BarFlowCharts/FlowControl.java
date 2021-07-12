package BarFlowCharts;
import java.util.Arrays;

public class FlowControl {
    public static void main(String[] args) {
        //First
        int[] nums1 = Utilities.populateArray();
        int[] nums2 = Utilities.populateArray();

        //Second
        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));
        //Third
        int biggest = Utilities.biggestSubArray(nums1);
        System.out.println(biggest);

        //Fourth
        int[] distinct = new int[10];
        Arrays.fill(distinct, -1);
        distinct = Utilities.distinctNumbers(distinct,nums1,nums2);

        //Fifth
        System.out.println(Arrays.toString(distinct));

        //Sixth
        System.out.println(Utilities.arrayToNumber(distinct));

    }
}
