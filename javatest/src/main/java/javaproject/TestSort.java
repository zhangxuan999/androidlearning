package javaproject;

public class TestSort {

	public static void main(String[] args) {
		// int[] array = new int[]{3,5,6,7,1,9};
		int[] array = { 23, 13, 49, 6, 31, 19, 28 };
		// int[] array = new int[5];
		// selectSort(array);
		 bubbleSort(array);
		//quickSort(array, 0, array.length - 1);
		

		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
		
		System.out.println(binarySearch(array, 5));;
	}

	/*
	 * 对序列划分为左右两个部分, 轴值为数组第一个元素 i，first:指向需要进行左右两侧排序的序列的第一个位置
	 * j，end:指向需要进行左右两侧排序的序列的最后一个位置
	 */
	public static int Partition(int[] array, int first, int end) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + "   ");
		}
		System.out.println();
		System.out.println("first = " + first + "/end = " + end);
		int i = first;
		int j = end;
		// 这个方法是讲first位置的元素作为轴值，将first元素移到相应的位置，在有序的情况下，该算法并不好。
		while (i < j) { // i和j会慢慢往中间靠，当i==j时，说明已经排好左右两侧的数据了，这里为什么不写i!=j作为条件呢？原因是有些情况是first>end，比如first=0，而end=-1，
			while (i < j && array[i] < array[j]) {// 右侧进行扫描，array[i]是轴值
				j--; // 最后一个元素是大于轴值的，那么就不动，因为已经在其右边的，j--，往前移动一个位置
			}
			if (i < j) { // 这一步是当array[i] > array[j]。轴值的位置变为了j
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
				i++;
			}
			while (i < j && array[i] < array[j]) {// 左侧扫描，如果都比轴值小的话，i往后移动
				i++;
			}
			if (i < j) { // 当发现有比轴值大的数时，进行互换
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
				j--;
			}
		}
		System.out.println("result pivot = " + j);
		return j;

	}

	// 快速排序
	public static void quickSort(int[] array, int first, int end) {
		System.out.println("quicksort first = " + first + ".end = " + end);
		if (first < end) {
			int pivot = Partition(array, first, end); // 返回轴值的位置，
			quickSort(array, first, pivot - 1);// 第一次排好后，pivot-1就是左侧最尾部的位置
			quickSort(array, pivot + 1, end); // pivot+1，右侧最开始的位置。
		}
	}

	// public static void insertSort(int[] array){
	//
	// for(int i =1;i< array.length;i++){
	//
	// if(array[i] < array [i-1]){
	// int temp = array[i];
	// for(int j = 0;j<i;j++){
	//
	// if(array[j] )
	// }
	//
	//
	// }
	// }
	//
	// }
	// 选择排序，讲第i个数与之后所有数一一比较，保证i位上是最小的。
	private static void selectSort(int[] array) {

		for (int i = 0; i < array.length; i++) {

			for (int j = i + 1; j < array.length; j++) {

				if (array[i] > array[j]) {

					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}

	// 冒泡排序 大数沉淀 思路两两比较，如果前数比后数达，交换，一圈下来，最大数沉淀。保证最后一位是最大的。
	public static void bubbleSort(int[] array) {

		for (int j = array.length - 1; j > 0; j--) {
			for (int i = 0; i < j; i++) {

				if (array[i] > array[i + 1]) {
					int temp = array[i];
					array[i] = array[i + 1];
					array[i + 1] = temp;
				}
			}
			System.out.println("j=" + j);
			for (int i = 0; i < array.length; i++) {

				System.out.print(array[i]);
			}
			System.out.println();

		}

		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}

	}

	//二分查找
	public static int binarySearch(int[] array, int value) {

		// int lenght = array.length
		int start = 0;
		int end = array.length - 1;
		int index = -1;

		while (start <= end) {
			 index = (start + end) / 2;
			if (value > array[index]) {
				start = index + 1;
			} else if (value < array[index]) {
				end = index - 1;
			} else {
				return index;
			}
		}

		return -1;

	}
}
