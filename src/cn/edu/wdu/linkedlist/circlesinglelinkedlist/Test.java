package cn.edu.wdu.linkedlist.circlesinglelinkedlist;

/**
 * @author gaojie  gao4433@qq.com
 * @Description 测试循环单向链表的功能
 * @date 2021/11/15 11:12
 * @since 1.8
 */
public class Test {
    public static void main(String[] args) {
        //创建一个循环单向链表对象
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();

        //创建有5个小孩（结点）的环形链表
        circleSingleLinkedList.addBoy(5);

        //遍历打印环形链表
        System.out.println("————圈中的小孩：————");
        circleSingleLinkedList.showBoy();

        //打印小孩出拳的顺序
        System.out.println("————小孩出队顺序：————");
        circleSingleLinkedList.countBoy(1,2,5);
    }
}
