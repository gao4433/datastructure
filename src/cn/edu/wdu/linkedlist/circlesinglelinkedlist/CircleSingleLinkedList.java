package cn.edu.wdu.linkedlist.circlesinglelinkedlist;

/**
 * @author gaojie  gao4433@qq.com
 * @Description 模拟单向循环链表，解决 Josephu 问题
 * @date 2021/11/15 10:42
 * @since 1.8
 */
public class CircleSingleLinkedList {
    /**
     * 创建一个first节点,当前没有编号
     */
    private Boy first = null;

    /**
     * 按输入的结点的数量，创建建环形链表
     * @param nums [in] 要添加的小孩（结点）的数量
     */
    public void addBoy(int nums) {
        // nums 做一个数据校验
        if (nums < 1) {
            System.out.println("nums 必须大于0!");
            return;
        }
        // curBoy是辅助指针，帮助构建环形链表
        Boy curBoy = null;
        // 使用for来创建我们的环形链表
        for (int i = 1; i <= nums; i++) {
            // 根据编号，创建一个小孩节点
            Boy boy = new Boy(i);
            // 如果要创建的是第一个小孩，让first节点成为第一个小孩
            if (i == 1) {
                first = boy;
                // 让第一个结点的后继结点是自己，构成环
                first.setNext(first);
                // 将first结点赋值給curBoy，成为第一个小孩
                curBoy = first;
                // 要创建的小孩不是第一个结点，则加在链表'末尾'
            } else {
                //让新结点成为当前结点的后继
                curBoy.setNext(boy);
                //让头节点first成为新节点的后继，形成环
                boy.setNext(first);
                //让辅助指针后移至链表末尾，方便下一个节点继续往后面创建
                curBoy = boy;
            }
        }
    }

    /**
     * 遍历当前的环形链表
     */
    public void showBoy() {
        // 判断链表是否为空
        if (first == null) {
            System.out.println("没有任何小孩~~");
            return;
        }
        // first不能动，使用一个辅助指针完成遍历
        Boy curBoy = first;
        while (true) {
            System.out.printf("小孩的编号 %d \n", curBoy.getNo());
            // 说明已经遍历完毕
            if (curBoy.getNext() == first) {
                break;
            }
            // 让辅助指针curBoy后移，继续遍历
            curBoy = curBoy.getNext();
        }
    }

    /**
     * 根据用户输入，计算小孩（结点）出圈顺序
     * @param startNo [in] 表示从第几个小孩开始计数
     * @param countNum [in] 表示数几下让一个小孩出圈
     * @param nums [in] 表示最初有多少小孩在圈中
     */
    public void countBoy(int startNo, int countNum, int nums) {
        // 先对数据进行校验
        if (first == null || startNo < 1 || startNo > nums) {
            System.out.println("参数输入有误， 请重新输入");
            return;
        }
        // helper是用来遍历的辅助指针，first此时依然指向（是）头结点
        Boy helper = first;
        // 利用辅助指针遍历链表 , 让helper指向（成为）链表最后一个节点
        while (true) {
            // 说明helper指向（是）最后小孩结点
            if (helper.getNext() == first) {
                break;
            } // helper指向最后一个小孩节点
            //让helper后移，继续遍历
            helper = helper.getNext();
        }
        //遍历先让first指向第一个数数的小孩startNo，才能开始
        //让helper先指向开始数数的小孩前面一个人,作为后面判断游戏结束的依据
        //同时小孩出圈后重新让链表形成环也需要借助helper节点来完成
        for (int j = 0; j < startNo - 1; j++) {
            first = first.getNext();
            helper = helper.getNext();
        }
        //当小孩报数时，让first 和 helper 指针同时 的移动  m  - 1 次, 然后出圈
        //这里是一个循环操作，直到圈中只有一个节点
        while (true) {
            // 当开始数数的小孩的前一个人是他自己时，说明环中只有一个节点
            if (helper == first) {
                break;
            } //环中只剩一个人，游戏结束
            //让 first 和 helper 同时移动 countNum - 1
            for (int j = 0; j < countNum - 1; j++) {
                first = first.getNext();
                helper = helper.getNext();
            } //这时first指向的节点，就是要出圈的小孩节点
            System.out.printf("小孩%d出圈\n", first.getNo());
            //让first指向first后面一个节点（小孩），让原来的first出圈
            first = first.getNext();
            //让现在的first结点成为原first节点（已出圈节点）前面一个节点的后继
            //重新构成环
            helper.setNext(first);
        } //游戏结束，helper和first是同一个结点，也就是最后一个小孩
        System.out.printf("最后留在圈中的是小孩%d \n", first.getNo());

    }
}
