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
//有序数组去重
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
	//虽然是值传递，但是也会改变a，b的内容
	a[1] = 53;
	b[1][1] = 77;
}

//在二维数组中，每一行，每一列都是升序，查找key在数组中的位置，返回下标，时间复杂度 o（N + M）
public static String getPosition(int[][] matrix, int key){
	int row = 0;
	int colume = matrix[0].length-1;
	String  resultString = null;
	while (row < matrix.length  && colume >-1) {
		if (key< matrix[row][colume]) {//如果key比该值小，那么这一列可以排除
			colume--;
		}else if (key > matrix[row][colume]) {//如果key比该值大，那么这一行可以排除
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

//n*n矩阵旋转顺时针90度，fail
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

//生成随机数组，内容在-99到99，不重复
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

//给定随机数组，每三个相加等于0的情况有多少种？
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


//回形打印矩阵
public static void huixingPrint(int[][] a){
	int colume = a[0].length;//列数
	int row = a.length;//行数
	int temp = colume *row;//总个数
	int flag = 0;//第几圈
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
