package cn.edu.wdu.sort;

import java.util.Arrays;

/**
 * @author gaojie  gao4433@qq.com
 * @Description 快速排序，以中间的数为基准
 * @date 2021/12/6 21:19
 * @since 1.8
 */
public class QuickSort {
    public static void main(String[] args) {

        int[] arr = {-9, 78, 0, 23, -567, 70, -1, 900, 4561};
        System.out.println("排序前：" + Arrays.toString(arr));
        quickSort(arr, 0, arr.length-1);
        System.out.println("排序后：" + Arrays.toString(arr));

    }

    public static void quickSort(int[] arr, int left, int right) {

        //左下标
        int l = left;
        //右下标
        int r = right;
        //pivot 中轴值
        int pivot = arr[(left + right) / 2];
        //临时变量，交换时使用
        int temp = 0;


        /**把比 pivot 值小的放到左边，比 pivot值大的放到右边 **/
        while (l < r) {

            //在pivot的左边一直找,找到大于等于pivot值,才退出
            while (arr[l] < pivot) {
                l += 1;
            }

            //在pivot的右边一直找,找到小于等于pivot值,才退出
            while (arr[r] > pivot) {
                r -= 1;
            }

            //如果l >= r，说明pivot 左边已经全部是小于等于pivot值，右边全部是大于等于pivot值
            if (l >= r) {
                break;
            }

            //交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            //交换完后，如果arr[l] == pivot值，右值左移
            if (arr[l] == pivot) {
                r -= 1;
            }

            //交换完后，如果arr[r] == pivot值，左值右移
            if (arr[r] == pivot) {
                l += 1;
            }
        }


        // 如果 l == r, 必须l++, r--, 否则为出现栈溢出
        if (l == r) {
            l += 1;
            r -= 1;
        }

        //向左递归
        if(left < r) {
            quickSort(arr, left, r);
        }

        //向右递归
        if(right > l) {
            quickSort(arr, l, right);

        }

    }
}
