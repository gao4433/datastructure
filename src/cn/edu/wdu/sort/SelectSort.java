package cn.edu.wdu.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author gaojie  gao4433@qq.com
 * @Description 选择排序，经测试：80000 随机数据耗时 3s
 * @date 2021/12/4 18:40
 * @since 1.8
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {101, 34, 119, 1, -1, 90, 123};
        selectSort(arr);

    }


    /**
     * 选择排序
     * 选择排序时间复杂度是 O(n^2)
     * @param arr [in] 待排序的数组
     */
    public static void selectSort(int[] arr) {

        //在推导的过程，我们发现了规律，因此，可以使用for来解决
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            int min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                // 说明假定的最小值，并不是最小
                if (min > arr[j]) {
                    // 重置min
                    min = arr[j];
                    // 重置minIndex
                    minIndex = j;
                }
            }

            // 将最小值，放在arr[0], 即交换
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }

            System.out.println("第" + (i + 1) + "轮后~~");
            System.out.println(Arrays.toString(arr));
        }

/*
		//使用逐步推导的方式来，讲解选择排序
		//第1轮
		//原始的数组 ： 	101, 34, 119, 1
		//第一轮排序 :   1, 34, 119, 101
		//算法 先简单 ---> 再复杂。就是可以把一个复杂的算法，拆分成简单的问题（逐步解决）

        //--------------第1轮---------------
		//假定最小值下标为0
		int minIndex = 0;
        //先假定最小值为 arr[0]
		int min = arr[0];
		for(int j = 0 + 1; j < arr.length; j++) {
            //如果假定的最小值并不是最小
			if (min > arr[j]) {
                //重置min
				min = arr[j];
                //重置minIndex
				minIndex = j;
			}
		}

		//将最小值，放在arr[0], 即交换
		if(minIndex != 0) {
			arr[minIndex] = arr[0];
			arr[0] = min;
		}

		System.out.println("第1轮后~~");
		System.out.println(Arrays.toString(arr));
        // 1, 34, 119, 101

		//--------------第2轮------------------
		minIndex = 1;
		min = arr[1];
		for (int j = 1 + 1; j < arr.length; j++) {
            // 说明假定的最小值，并不是最小
			if (min > arr[j]) {
                // 重置min
				min = arr[j];
                // 重置minIndex
				minIndex = j;
			}
		}

		// 将最小值，放在arr[0], 即交换
		if(minIndex != 1) {
			arr[minIndex] = arr[1];
			arr[1] = min;
		}

		System.out.println("第2轮后~~");
		System.out.println(Arrays.toString(arr));
        // 1, 34, 119, 101

		//--------------第3轮--------------------
		minIndex = 2;
		min = arr[2];
		for (int j = 2 + 1; j < arr.length; j++) {
            // 说明假定的最小值，并不是最小
			if (min > arr[j]) {
                // 重置min
				min = arr[j];
                // 重置minIndex
				minIndex = j;
			}
		}

		// 将最小值，放在arr[0], 即交换
		if (minIndex != 2) {
			arr[minIndex] = arr[2];
			arr[2] = min;
		}
		System.out.println("第3轮后~~");
		System.out.println(Arrays.toString(arr));
        // 1, 34, 101, 119
*/

    }
}