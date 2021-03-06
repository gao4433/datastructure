package cn.edu.wdu.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author gaojie  gao4433@qq.com
 * @Description 插入排序，经测试：8000 随机数据耗时 1s
 * @date 2021/12/4 19:21
 * @since 1.8
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {101, 34, 119, 1, -1, 89};
        insertSort(arr);

    }

    /**
     * 插入排序
     * 经测试：8000 随机数据耗时 1s
     * @param arr [in] 待排序数组
     */
    public static void insertSort(int[] arr) {
        int insertVal = 0;
        int insertIndex = 0;
        //使用for循环来把代码简化
        for (int i = 1; i < arr.length; i++) {
            //待插入的数
            insertVal = arr[i];
            // 待插入数前一个数的下标
            insertIndex = i - 1;

            // 给insertVal 找到插入的位置
            // 说明
            // 1. insertIndex >= 0 保证在给insertVal 找插入位置，不越界
            // 2. insertVal < arr[insertIndex] 待插入的数，还没有找到插入位置
            // 3. 就需要将 arr[insertIndex] 后移
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            // 当退出while循环时，说明插入的位置找到, insertIndex + 1
            //这里我们判断是否需要赋值
            if (insertIndex + 1 != i) {
                arr[insertIndex + 1] = insertVal;
            }

            System.out.println("第" + i + "轮插入");
            System.out.println(Arrays.toString(arr));
        }

/*
        //使用逐步推导的方式来讲解，便利理解
        //-------------第1轮--------------------
        // {101, 34, 119, 1};  => {34, 101, 119, 1}
        //定义待插入的数
        int insertVal = arr[1];
        //待插入数的前一个数的下标
        int insertIndex = 1 - 1;

        //给insertVal 找到插入的位置
        //说明
        //1. insertIndex >= 0 保证在给 insertVal 找插入位置时，不越界
        //2. insertVal < arr[insertIndex] 说明待插入的数，还没有找到插入位置
        //3. 就需要将 arr[insertIndex] 后移
        while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
            //后移 arr[insertIndex]
            arr[insertIndex + 1] = arr[insertIndex];
            insertIndex--;
        }
        //当退出while循环时，说明插入的位置找到, insertIndex + 1
        arr[insertIndex + 1] = insertVal;

        System.out.println("第1轮插入");
        System.out.println(Arrays.toString(arr));

        //---------------第2轮-----------------------
        insertVal = arr[2];
        insertIndex = 2 - 1;

        while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
            arr[insertIndex + 1] = arr[insertIndex];
            insertIndex--;
        }

        arr[insertIndex + 1] = insertVal;
        System.out.println("第2轮插入");
        System.out.println(Arrays.toString(arr));


        //--------------第3轮----------------------
        insertVal = arr[3];
        insertIndex = 3 - 1;

        while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
            arr[insertIndex + 1] = arr[insertIndex];
            insertIndex--;
        }

        arr[insertIndex + 1] = insertVal;
        System.out.println("第3轮插入");
        System.out.println(Arrays.toString(arr));
*/

    }
}