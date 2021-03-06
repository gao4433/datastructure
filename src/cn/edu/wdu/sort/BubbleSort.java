package cn.edu.wdu.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author gaojie  gao4433@qq.com
 * @Description 冒泡排序，经测试：80000 随机数据耗时 10s
 * @date 2021/12/3 23:42
 * @since 1.8
 */
public class BubbleSort {
    public static void main(String[] args) {
        int arr[] = {3, 9, -1, 10, 20};

        System.out.println("排序前");
        System.out.println(Arrays.toString(arr));
        bubbleSort(arr);

    }


    /**
     * 将冒泡排序算法，封装成一个方法
     * 冒泡排序的【时间复杂度】为 O(n^2)
     *
     * @param arr [in] 待排序的数组
     */
    public static void bubbleSort(int[] arr) {
        // 临时变量
        int temp = 0;
        // 标识变量，表示是否进行过交换
        boolean flag = false;
        for (int i = 0; i < arr.length - 1; i++) {

            for (int j = 0; j < arr.length - 1 - i; j++) {
                // 如果前面的数比后面的数大，则交换位置
                if (arr[j] > arr[j + 1]) {
                    //发生交换，将flag置为false
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            System.out.println("第" + (i + 1) + "趟排序后的数组");
            System.out.println(Arrays.toString(arr));

            // 在一趟排序中，如果一次交换都没有发生过
            if (!flag) {
                break;
            } else { // 重置flag!!!, 进行下次判断
                flag = false;
            }
        }
    }

}
