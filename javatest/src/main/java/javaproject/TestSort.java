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
	 * �����л���Ϊ������������, ��ֵΪ�����һ��Ԫ�� i��first:ָ����Ҫ��������������������еĵ�һ��λ��
	 * j��end:ָ����Ҫ��������������������е����һ��λ��
	 */
	public static int Partition(int[] array, int first, int end) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + "   ");
		}
		System.out.println();
		System.out.println("first = " + first + "/end = " + end);
		int i = first;
		int j = end;
		// ��������ǽ�firstλ�õ�Ԫ����Ϊ��ֵ����firstԪ���Ƶ���Ӧ��λ�ã������������£����㷨�����á�
		while (i < j) { // i��j���������м俿����i==jʱ��˵���Ѿ��ź���������������ˣ�����Ϊʲô��дi!=j��Ϊ�����أ�ԭ������Щ�����first>end������first=0����end=-1��
			while (i < j && array[i] < array[j]) {// �Ҳ����ɨ�裬array[i]����ֵ
				j--; // ���һ��Ԫ���Ǵ�����ֵ�ģ���ô�Ͳ�������Ϊ�Ѿ������ұߵģ�j--����ǰ�ƶ�һ��λ��
			}
			if (i < j) { // ��һ���ǵ�array[i] > array[j]����ֵ��λ�ñ�Ϊ��j
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
				i++;
			}
			while (i < j && array[i] < array[j]) {// ���ɨ�裬���������ֵС�Ļ���i�����ƶ�
				i++;
			}
			if (i < j) { // �������б���ֵ�����ʱ�����л���
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
				j--;
			}
		}
		System.out.println("result pivot = " + j);
		return j;

	}

	// ��������
	public static void quickSort(int[] array, int first, int end) {
		System.out.println("quicksort first = " + first + ".end = " + end);
		if (first < end) {
			int pivot = Partition(array, first, end); // ������ֵ��λ�ã�
			quickSort(array, first, pivot - 1);// ��һ���źú�pivot-1���������β����λ��
			quickSort(array, pivot + 1, end); // pivot+1���Ҳ��ʼ��λ�á�
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
	// ѡ�����򣬽���i������֮��������һһ�Ƚϣ���֤iλ������С�ġ�
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

	// ð������ �������� ˼·�����Ƚϣ����ǰ���Ⱥ����������һȦ�����������������֤���һλ�����ġ�
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

	//���ֲ���
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
