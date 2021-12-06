package cn.edu.wdu.recursion.queue8;

/**
 * @author gaojie  gao4433@qq.com
 * @Description 递归回溯求解八皇后问题
 * @date 2021/11/30 22:10
 * @since 1.8
 */
public class Queue8 {

    /**
     * 表示共有多少个皇后
     */
    int max = 8;
    /**
     * 数组array, 保存所有皇后最终放置位置,比如 arr = {0 , 4, 7, 5, 2, 6, 1, 3}
     */
    int[] array = new int[max];
    static int count = 0;
    static int judgeCount = 0;

    public static void main(String[] args) {
        //测试一把 ， 8皇后是否正确
        Queue8 queue8 = new Queue8();
        queue8.check(0);
        System.out.printf("一共有%d解法", count);
        System.out.printf("一共判断冲突次数"+ judgeCount);

    }

    /**
     * 放置第 n+1 个皇后
     * 特别注意：每一次递归时，进入到 check 中都有 for(int i = 0; i < max; i++)，因此会有回溯
     *
     * @param n [in]
     */
    private void check(int n) {
        //n = 8 , 其实8个皇后已经放好
        if (n == max) {
            print();
            return;
        }
        //依次放入皇后，并判断是否冲突
        for (int i = 0; i < max; i++) {
            //先把当前这个皇后n （第 n=1 个皇后）, 放到该行的第 1 列
            array[n] = i;
            //判断当放置 皇后n 到 i 列时，是否冲突
            if (judge(n)) {
                //不冲突，接着放 皇后n+1,即开始递归
                check(n + 1);
            }
            //如果冲突，就继续执行 array[n] = i; 即将皇后n，放置在本行后移一个位置
        }
    }

    /**
     * 检测当前放置的皇后是否和前面摆放的皇后冲突
     *
     * @param n [in] 表示第 n 个皇后
     * @return
     */
    private boolean judge(int n) {
        judgeCount++;
        for (int i = 0; i < n; i++) {
            // 说明
            // 1. array[i] == array[n]
            //        表示判断第 n 个皇后是否和前面的 n-1个皇后在同一列
            // 2. Math.abs(n-i) == Math.abs(array[n] - array[i])
            //        表示判断第 n 个皇后是否和第 i 个皇后是否在同一斜线
            //        如第二个皇后放 n=1位置，即二行二列位置，此时 n=1， array[1] = 1
            //        Math.abs(1-0) == 1
            //        Math.abs(array[n] - array[i]) = Math.abs(1-0) = 1
            //3. 没有必要判断是否在同一行，因为摆放时 n 每次都在递增
            if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
                return false;
            }
        }
        return true;
    }

    /**
     * 将皇后摆放的位置输出
     */
    private void print() {
        count++;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

}