package c;

import java.util.Arrays;

public class FlowTest2 {


	public static int[] array3 = new int[10];

	public static void main(String[] args) {

		int[] arr1 = populateArray();
		int[] arr2 = populateArray();

		Arrays.fill(array3, -1);
		distinct(arr1,arr2);
		distinct(arr2,arr1);

		System.out.println(Arrays.toString(array3));
		System.out.println("================");

		System.out.println(Arrays.toString(arr1));
		System.out.println(Arrays.toString(arr2));
		System.out.println(Arrays.toString(array3));
	}

	public static int[] populateArray() {
		int[] array = new int[10];
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) (Math.random() * 10);
		}
		return array;
	}

	public static void fillArray(int num) {
		for (int x = 0; x < array3.length; x++) {
			if (array3[x] == -1) {
				array3[x] = num;
				break;
			} else if (array3[x] == num) {
				break;
			}
		}
	}

	public static void distinct(int[] array1,int[] array2) {
		for (int i = 0; i < array1.length; i++) {

			for (int y = 0; y < array2.length; y++) {

				if (array1[i] == array2[y]) {
					break;

				} else if (y == array2.length - 1) {
					fillArray(array1[i]);
				}
			}
		}
	}
}
