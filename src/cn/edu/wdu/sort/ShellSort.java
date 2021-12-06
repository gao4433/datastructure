package cn.edu.wdu.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author gaojie  gao4433@qq.com
 * @Description 希尔排序
 * @date 2021/12/4 23:00
 * @since 1.8
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        System.out.println("排序前的数组为：" + Arrays.toString(arr));
        shellSort2(arr);

/*
        // 创建要给80000个的随机的数组
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 80000); // 生成一个[0, 80000) 数
        }

        System.out.println("排序前");
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);

        //shellSort1(arr); //交换式
        shellSort2(arr);//移位方式

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序后的时间是=" + date2Str);

        //System.out.println(Arrays.toString(arr));
*/

    }

    /**
     * 希尔排序-->交换法
     * 经测试，80000 随机数据排序用时 6s
     * @param arr
     */
    public static void shellSort1(int[] arr) {

        int temp = 0;
        int count = 0;
        //外循环：按【步长gap】匹配分组，哪些元素放在一组
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            //内循环：对每一组元素由后往前交换排序
            for (int i = gap; i < arr.length; i++) {
                // 遍历各组中所有的元素(共gap组), 步长gap
                for (int j = i - gap; j >= 0; j -= gap) {
                    // 如果当前元素大于加上步长后的那个元素，说明交换
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
            System.out.println("希尔排序第" + (++count) + "轮 =" + Arrays.toString(arr));
        }

/*
        // 使用逐步推导的方式来编写希尔排序
        // 希尔排序时，对有序序列在插入时采用交换法,
        // 思路(算法) ===> 代码

        //希尔排序的第1轮排序：将10个数据分成了 5组
        //这里我们分组时是让后五个匹配前五个，右后往前匹配比较
        for (int i = 5; i < arr.length; i++) {
            int temp = 0;
            // 遍历各组中所有的元素(共5组，每组有2个元素), 步长5
            // j -= 5,是让 arr[i] 去匹配 a[i-5],让这两个为一组
            for (int j = i - 5; j >= 0; j -= 5) {
                // 如果当前元素大于加上步长5后的那个元素，需要交换
                if (arr[j] > arr[j + 5]) {
                    temp = arr[j];
                    arr[j] = arr[j + 5];
                    arr[j + 5] = temp;
                }
            }
        } //a[5]和a[0]比 --> a[6]和a[1]比 --> …… --> a[9]和a[4]比
        System.out.println("希尔排序1轮后=" + Arrays.toString(arr));


        // 希尔排序的第2轮排序
        // 因为第2轮排序，是将10个数据分成了 5/2 = 2组
        for (int i = 2; i < arr.length; i++) {
            int temp = 0;
            // 遍历各组中所有的元素(共2组，每组有5个元素), 步长2
            for (int j = i - 2; j >= 0; j -= 2) {
                // 如果当前元素大于加上步长后的那个元素，则交换
                if (arr[j] > arr[j + 2]) {
                    temp = arr[j];
                    arr[j] = arr[j + 2];
                    arr[j + 2] = temp;
                }
            }
        } //a[2]和a[0]比 --> a[3]和a[1]比 --> a[4]和a[2]；a[2]和a[0]比 --> …… -->a[9]和……
        System.out.println("希尔排序2轮后=" + Arrays.toString(arr));

        // 希尔排序的第3轮排序
        // 因为第3轮排序，是将10个数据分成了 2/2 = 1组
        for (int i = 1; i < arr.length; i++) {
            // 遍历各组中所有的元素(共1组，每组有10个元素), 步长1
            for (int j = i - 1; j >= 0; j -= 1) {
                int temp = 0;
                // 如果当前元素大于加上步长后的那个元素，则交换
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        } // a[1]和a[0]比 --> a[2]和a[1]比；a[1]和a[0]比 -->  …… -->a[9]和……
        System.out.println("希尔排序3轮后=" + Arrays.toString(arr));
*/

    }

    /**
     * 希尔排序优化-->移位法
     * 经测试，80000 随机数据排序用时 1s
     * @param arr
     */
    public static void shellSort2(int[] arr) {

        // 增量gap, 并逐步的缩小增量
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            // 从第gap个元素，逐个对其所在的组进行直接插入排序
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                if (arr[j] < arr[j - gap]) {
                    while (j - gap >= 0 && temp < arr[j - gap]) {
                        //移动
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    //当退出while后，就给temp找到插入的位置
                    arr[j] = temp;
                }

            }
            System.out.println(Arrays.toString(arr));
        }
    }

}
