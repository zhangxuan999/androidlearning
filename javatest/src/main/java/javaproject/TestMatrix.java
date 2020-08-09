package javaproject;

import java.awt.List;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.Vector;

import org.omg.CORBA.PUBLIC_MEMBER;

public class TestMatrix {
public static void main(String[] args) {
	//yiweishuzu 
//	int a[] = new int[]{1,2,3,4,5};
//	
//	int b[][] = {{1,2,3,4,5},{3,4,5,7,8},{2,4,6,10,15}};
//
//	Test(a,b);
//	
//	System.out.println(getPosition(b,9));
//	
//	 
//	int c[][] = {{1,2,3,4,5,6},{7,8,9,10,11,12},{13,14,15,16,17,18},{19,20,21,22,23,24}};
//	huixingPrint(c);
	
	
	int a[] = {-1,-1,0,0,2,1,1};
	System.out.println(process(a));
	print(a);
	//System.out.println(process(randomArray()));
	System.out.println(removeDuplicates(a));
	print(a);
	
	
}
//��������ȥ��
public static int removeDuplicates(int[] nums) {
    int count=1;
    int k = nums.length;
    if( k==1){
        return 1;
    }
    else{
     for(int i=1;i<k;i++){
        if(nums[i] != nums[i-1]){
            nums[count++] = nums[i];
    }
        }
     return count;
    }
    
}

public static void Test(int a[],int b[][]){
	//��Ȼ��ֵ���ݣ�����Ҳ��ı�a��b������
	a[1] = 53;
	b[1][1] = 77;
}

//�ڶ�ά�����У�ÿһ�У�ÿһ�ж������򣬲���key�������е�λ�ã������±꣬ʱ�临�Ӷ� o��N + M��
public static String getPosition(int[][] matrix, int key){
	int row = 0;
	int colume = matrix[0].length-1;
	String  resultString = null;
	while (row < matrix.length  && colume >-1) {
		if (key< matrix[row][colume]) {//���key�ȸ�ֵС����ô��һ�п����ų�
			colume--;
		}else if (key > matrix[row][colume]) {//���key�ȸ�ֵ����ô��һ�п����ų�
			row++;
		}else{
			break;
		}
	}
	if (row < matrix.length && colume > -1) {
		resultString = "[" + row + "," + colume + "]";
	}else{
		resultString = "[-1,-1]";
	}
	
	return resultString;
}

//n*n������ת˳ʱ��90�ȣ�fail
public static int[][] rotate(int[][] matrix){
	
	if (matrix.length != matrix[0].length) {
		return null;
	}
	int c[][] = matrix.clone();
	for (int i = 0; i < matrix.length; i++) {
		for (int j = 0; j < matrix[0].length; j++) {
		  c[i][j] = matrix[j][matrix.length -1 -i] ;
		}
	}
	
	return c;
}

//����������飬������-99��99�����ظ�
public static int[] randomArray() {
	Random random = new Random();
	int length = random.nextInt(100);
    while (length < 1) {
		length = random.nextInt(100);
	}
	int[] array = new int[length];
	System.out.println("length = " + length);
	
	Set<Integer> set = new HashSet<>();
	
	while (set.size() < length) {
		set.add(random.nextInt(2)== 1? random.nextInt(100): -random.nextInt(100));
	}
	
	System.out.println("set = " +set);
	
	Iterator<Integer> iterator = set.iterator();
	int i = 0;
	while (iterator.hasNext()) {
		array[i] = iterator.next();
		i++;
	}
	System.out.println("array.length = "+ array.length);
	System.out.println(Arrays.toString(array));
	
	
	return array;
}

//����������飬ÿ������ӵ���0������ж����֣�
private static String process(int[] keys) {
	Arrays.sort(keys);
	print(keys);
	HashSet<Vector<Integer>> set = new HashSet<>();
	for (int i = 0; i < keys.length; i++) {
		int a = keys[i];
		int j = i + 1;
		int k = keys.length - 1;
		while (j < k) {
			int sum = a + keys[j] + keys[k];
			if (sum < 0) {
				j++;
			} else if (sum > 0) {
				k--;
			} else {
				Vector<Integer> vector = new Vector<>(3);
				vector.add(a);
				vector.add(keys[j]);
				vector.add(keys[k]);
				set.add(vector);
				j++;
				k--;
			}
		}
	}
	return set.toString();

}

private static void print(int[] keys) {
	for (int key : keys) {
		System.out.print(key + " ");
	}
	System.out.println();
}


//���δ�ӡ����
public static void huixingPrint(int[][] a){
	int colume = a[0].length;//����
	int row = a.length;//����
	int temp = colume *row;//�ܸ���
	int flag = 0;//�ڼ�Ȧ
	while (true) {
		for (int i = flag; i < colume-flag; i++) {
			System.out.println(a[flag][i]);
			temp --;
			if (temp == 0) {
				return;
			}
		}
		
		for (int i = flag + 1; i < row - flag ; i++) {
			System.out.println(a[i][colume - flag - 1]);
			temp --;
			if (temp == 0) {
				return;
			}
		}
		
		
		for (int i = colume -2 -flag; i > flag-1; i--) {
			System.out.println(a[row-flag - 1][i]);
			temp --;
			if (temp == 0) {
				return;
			}
		}
		
		//youbian
		for (int i = row - flag - 2; i > flag ; i--) {
			System.out.println(a[i][flag]);
			temp --;
			if (temp == 0) {
				return;
			}
		}
		
		flag ++;
		
	}
}
}
