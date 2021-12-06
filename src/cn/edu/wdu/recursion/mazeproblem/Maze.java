package cn.edu.wdu.recursion.mazeproblem;

/**
 * @author gaojie  gao4433@qq.com
 * @Description 迷宫问题
 * @date 2021/11/28 18:06
 * @since 1.8
 */
public class Maze {
    public static void main(String[] args) {
        // 先创建一个二维数组，模拟迷宫
        int[][] map = new int[8][7];
        // 使用 1 表示墙，最上最下两行全部置为 1
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }

        // 最左最右两列全部置为1
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }

        //设置挡板, 1 表示
        map[3][1] = 1;
        map[3][2] = 1;
        //map[1][2] = 1;
        //map[2][2] = 1;

        // 输出地图
        System.out.println("地图初始情况：");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        //使用递归回溯给小球找路
        setWay1(map, 1, 1);
        //setWay2(map, 1, 1);

        //输出新的地图, 小球走过，并标识过的递归
        System.out.println("小球走过并标识路线后的地图：");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

    }

    /**
     * 使用递归回溯，按照策略 下->右->上->左  给找路
     * <p>
     * 约定：
     * 当map[i][j] 为 0， 表示该点没有走过 ；
     * 为 1 表示墙 ；
     * 为 2 表示通路可以走 ；
     * 为 3 表示该点已经走过，但是走不通；
     * 如果小球能到 map[6][5] 位置，则说明通路找到.
     *
     * @param map [in] 表示地图
     * @param i   [in] 开始位置横坐标
     * @param j   [in] 开始位置纵坐标
     * @return 如果找到通路，就返回true, 否则返回false
     */
    public static boolean setWay1(int[][] map, int i, int j) {
        // 通路已经找到
        if (map[6][5] == 2) {
            return true;
        } else {
            //如果当前这个点还没有走过
            //按照策略 下->右->上->左  走
            if (map[i][j] == 0) {
                // 假定该点是可以走通.
                map[i][j] = 2;
                if (setWay1(map, i + 1, j)) {//向下走
                    return true;
                } else if (setWay1(map, i, j + 1)) { //向右走
                    return true;
                } else if (setWay1(map, i - 1, j)) { //向上走
                    return true;
                } else if (setWay1(map, i, j - 1)) { //向左走
                    return true;
                } else {
                    //说明该点是走不通，是死路
                    map[i][j] = 3;
                    return false;
                }
            } else { // 如果map[i][j] != 0 , 可能是 1， 2， 3
                return false;
            }
        }
    }

    /**
     * 使用递归回溯，按照策略 上->右->下->左  给找路
     * 约定：
     * 当map[i][j] 为 0， 表示该点没有走过 ；
     * 为 1 表示墙 ；
     * 为 2 表示通路可以走 ；
     * 为 3 表示该点已经走过，但是走不通；
     * 如果小球能到 map[6][5] 位置，则说明通路找到.
     *
     * @param map [in] 表示地图
     * @param i   [in] 开始位置横坐标
     * @param j   [in] 开始位置纵坐标
     * @return 如果找到通路，就返回true, 否则返回false
     */
    public static boolean setWay2(int[][] map, int i, int j) {
        // 通路已经找到
        if (map[6][5] == 2) {
            return true;
        } else {
            //如果当前这个点还没有走过
            //按照策略 上->右->下->左
            if (map[i][j] == 0) {
                // 假定该点是可以走通.
                map[i][j] = 2;
                if (setWay2(map, i - 1, j)) { //向上走
                    return true;
                } else if (setWay2(map, i, j + 1)) { //向右走
                    return true;
                } else if (setWay2(map, i + 1, j)) { //向下
                    return true;
                } else if (setWay2(map, i, j - 1)) { // 向左走
                    return true;
                } else {
                    //说明该点是走不通，是死路
                    map[i][j] = 3;
                    return false;
                }
            } else { // 如果map[i][j] != 0 , 可能是 1， 2， 3
                return false;
            }
        }
    }
}